/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SpecifyServiceController;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ServiceType;

/**
 * FXML Controller class
 *
 * @author lulu
 */
public class SpecifyServiceUI implements Initializable {

    private SpecifyServiceController ssController;
    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private ComboBox<String> serviceTypesBox;
    @FXML
    private TextField idenTextField;
    @FXML
    private TextField costTimeTextField;
    @FXML
    private TextArea descTextArea;
    @FXML
    private TextField addCompDescTextField;
    @FXML
    private ComboBox<Category> categoryComboBox;
    @FXML
    private Label labelPreDuration;
    @FXML
    private TextField textboxDuration;
    @FXML
    private Label labelMinutes;
    @FXML
    private ListView<String> listViewData;
    @FXML
    private Button enterDataButton;
    @FXML
    private Button enterNewButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ssController = new SpecifyServiceController();
        for (ServiceType serv : ssController.getServiceTypes()) {
            serviceTypesBox.getItems().add(serv.getIdType());
        }
        for (Category cat : ssController.getCategories()) {
            categoryComboBox.getItems().add(cat);
        }
        labelPreDuration.setDisable(true);
        textboxDuration.setDisable(true);
        labelMinutes.setDisable(true);
        enterNewButton.setDisable(true);
    }

    @FXML
    private void cancelEvent(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmEvent(ActionEvent event) {
        if (ssController.registersService()) {
            confirmationAlert("Service registered with success!");
            clearAllFields();
        }
    }

    private void clearAllFields() {
        idenTextField.clear();
        costTimeTextField.clear();
        descTextArea.clear();
        addCompDescTextField.clear();
        textboxDuration.clear();
        labelPreDuration.setDisable(true);
        textboxDuration.setDisable(true);
        labelMinutes.setDisable(true);
        enterNewButton.setDisable(true);
        listViewData.getItems().clear();
        serviceTypesBox.setValue("Service Type");

    }

    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Create Service");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Successful operation.");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void serviceTypeEvent(ActionEvent event) {

    }

    @FXML
    private void eventEnterData(ActionEvent event) {
        String idType = serviceTypesBox.getValue();
        ssController.setServiceType(idType);
        try {
            String catId = categoryComboBox.getValue().getM_strID();
            String id = idenTextField.getText();
            String briefDesc = descTextArea.getText();
            String compDesc = addCompDescTextField.getText();
            double cost = Double.parseDouble(costTimeTextField.getText());
            boolean bAtrbs = ssController.newService(id, briefDesc, compDesc, cost, catId);
            if (bAtrbs == true) {
                String atrbs = ssController.getOtherAttributes();
                labelPreDuration.setDisable(false);
                labelPreDuration.setText(atrbs);
                textboxDuration.setDisable(false);
                labelMinutes.setDisable(false);
                enterNewButton.setDisable(false);
            } else {
                listViewData.getItems().add(ssController.validates());
                if (ssController.validates().equalsIgnoreCase("Invalid service.")) {
                    errorAlert("The service already exists.");
                    clearAllFields();
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException ex) {
            errorAlert("Something went wrong, check the submitted data and try again.");
            clearAllFields();
        } catch (IllegalArgumentException ex) {
            errorAlert("Submitted wrong data.");
            clearAllFields();
        } catch (NullPointerException ex) {
            errorAlert("Inserted null data");
            clearAllFields();
        }
    }

    @FXML
    private void enterNewDataEvent(ActionEvent event) {
        try {
            int data = Integer.parseInt(textboxDuration.getText());
            if (data > 0 && data % 30 == 0) {
                ssController.setAdditionalData(data);
                listViewData.getItems().add(ssController.validates());
                if (ssController.validates().equalsIgnoreCase("Invalid service.")) {
                    errorAlert("The service already exists.");
                    clearAllFields();
                }
            } else {
                errorAlert("Pre-Determined Duration isn't a positive number or it isn't a multiple of 30.");
                textboxDuration.clear();
            }
        } catch (NumberFormatException ex) {
            errorAlert("Duration must be a number");
            textboxDuration.clear();
        }

    }
}
