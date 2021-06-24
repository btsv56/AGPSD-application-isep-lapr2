/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SpecifyGeographicalAreaController;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.Instanciate;

/**
 * FXML Controller class
 *
 * @author lulu
 */
public class SpecifyGeographicalAreaUI implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField designationTextField;
    @FXML
    private TextField postalCodeTextField;
    @FXML
    private TextField radiusTextField;
    @FXML
    private TextField travelCostTextField;
    @FXML
    private ListView<String> listViewArea;

    private SpecifyGeographicalAreaController sgaController;
    @FXML
    private Button buttonEnterData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sgaController = new SpecifyGeographicalAreaController();
        confirmButton.setDisable(true);
        listViewArea.setDisable(true);
    }

    @FXML
    private void cancelEvent(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmEvent(ActionEvent event) {
        if (sgaController.registersGeographicalArea()) {
            successAlert("Geographical Area created with success!");
            clearAllFields();
        } else {
            errorAlert("Invalid area");
            clearAllFields();
        }
    }

    @FXML
    private void eventEnter(ActionEvent event) {
        try {
            String desig = designationTextField.getText();
            double cost = Double.parseDouble(travelCostTextField.getText());
            String postalCode = postalCodeTextField.getText();
            float radius = Float.parseFloat(radiusTextField.getText());
            if (Instanciate.readPostalCodes(postalCode)) {
                GeographicalArea ga = sgaController.newGeographicalArea(desig, cost, postalCode, radius);
                listViewArea.setDisable(false);
                confirmButton.setDisable(false);
                listViewArea.getItems().add(ga.toString());
            }else{
                errorAlert("Invalid Postal Code");
                clearAllFields();
            }
        } catch (ClassNotFoundException | IllegalArgumentException | InstantiationException | IllegalAccessException | FileNotFoundException ex) {
            errorAlert("Something went wrong, check the submitted data and try again.");
            clearAllFields();
        }

    }

    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Create Area");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void clearAllFields() {
        designationTextField.clear();
        postalCodeTextField.clear();
        radiusTextField.clear();
        travelCostTextField.clear();
        listViewArea.getItems().clear();
        confirmButton.setDisable(true);
        listViewArea.setDisable(true);
    }

    private void successAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Register Geographical Area");
        alert.setHeaderText("Success!");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
