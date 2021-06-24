/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.CompleteServiceController;
import lapr.project.gpsd.model.Issue;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;

/**
 * FXML Controller class
 *
 * @author marta
 */
public class CompleteServiceUI implements Initializable {

    @FXML
    private ComboBox<String> servOrdComboBox;
    @FXML
    private ListView<String> listViewServOrder;
    @FXML
    private Button buttonExecStipul;
    @FXML
    private Button buttonNotStipulated;
    @FXML
    private TextField textfieldDesc;
    @FXML
    private TextField textfieldTroublest;
    @FXML
    private Button buttonIssue;

    private CompleteServiceController csController;
    private ServiceOrder o;
    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servOrdComboBox.getItems().clear();
        try {
            csController = new CompleteServiceController();
            List<ServiceOrder> ol = csController.newCompleteService();
            for (ServiceOrder or : ol) {
                servOrdComboBox.getItems().add(String.format("%d", or.getNumber()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompleteServiceUI.class.getName()).log(Level.SEVERE, null, ex);
            errorAlert("Something went wrong");
            clearAllFields();
        }
        textfieldDesc.setDisable(true);
        textfieldTroublest.setDisable(true);
        buttonIssue.setDisable(true);
    }

    @FXML
    private void eventExecAsStipulated(ActionEvent event) {
        try {
            csController.setServiceOrderStatus(this.o, "Executed");
            confirmationAlert("Registered complete service!");
            Stage stage = (Stage) buttonExecStipul.getScene().getWindow();
            stage.close();
        } catch (NullPointerException ex) {
            errorAlert("Select an order.");
        }
    }

    @FXML
    private void eventNotStipulated(ActionEvent event) {
        if (servOrdComboBox.getValue() != null) {
            textfieldDesc.setDisable(false);
            textfieldTroublest.setDisable(false);
            buttonIssue.setDisable(false);
        } else {
            errorAlert("Select an order.");
        }

    }

    @FXML
    private void eventEnterIssue(ActionEvent event) {
        try {
            String desc = textfieldDesc.getText();
            String troublest = textfieldTroublest.getText();
            Issue i = csController.newIssue(this.o, desc, troublest);
            if (csController.registersIssue(i)) {
                csController.setServiceOrderStatus(this.o, "Executed");
                confirmationIssue(i.toString());
                Stage stage = (Stage) buttonIssue.getScene().getWindow();
                stage.close();
            }
        } catch (IllegalArgumentException ex) {
            errorAlert("Inserted wrong data.");
        }
    }

    @FXML
    private void eventSOComboBox(ActionEvent event) {
        this.o = csController.getServiceOrderByNum(Integer.parseInt(servOrdComboBox.getValue().trim()));
        listViewServOrder.getItems().add(this.o.toString());
    }

    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Register Complete Service");
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

    private void clearAllFields() {
        textfieldDesc.clear();
        textfieldTroublest.clear();
        textfieldTroublest.setDisable(true);
        textfieldDesc.setDisable(true);
        buttonIssue.setDisable(true);
        listViewServOrder.getItems().clear();
    }

    private void confirmationIssue(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Registered Complete Service.");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void eventCancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
