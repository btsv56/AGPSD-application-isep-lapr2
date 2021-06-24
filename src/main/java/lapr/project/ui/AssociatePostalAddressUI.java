/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.net.URL;
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
import lapr.project.gpsd.controller.AssociatePostalAddressController;
import lapr.project.gpsd.model.Instanciate;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AssociatePostalAddressUI implements Initializable {

    @FXML
    private TextField addresTextFiel;
    @FXML
    private TextField postCodCombo;
    @FXML
    private TextField locationTxtField;
    @FXML
    private ListView<String> showPostAddre;
    @FXML
    private Button confirmB;
    @FXML
    private Button add;

    private AssociatePostalAddressController apaController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillPostalCodes1();
            confirmB.setDisable(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AssociatePostalAddressUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Registered Address
     *
     * @param event action event
     */
    @FXML
    private void confirmButton(ActionEvent event) {
        apaController.registerAddress();
        Stage stage = (Stage) confirmB.getScene().getWindow();
        stage.close();

    }

    /**
     * Creates and associates an address to the client
     *
     * @param event action event
     * @throws FileNotFoundException exception
     */
    @FXML
    private void addHandle(ActionEvent event) throws FileNotFoundException {
        String address = addresTextFiel.getText();
        String codPostal = postCodCombo.getText();
        String location = locationTxtField.getText();
        if (checkInfo()) {
            apaController.newPostalAddress();
            apaController.newPostalAdress(address, codPostal, location);
            showPostAddre.getItems().add(address + "," + codPostal + "," + location);
            confirmB.setDisable(false);
            addresTextFiel.clear();
            postCodCombo.clear();
            locationTxtField.clear();
        }

    }

    /**
     * Initializes AssociatePostalAddressController
     *
     * @throws FileNotFoundException
     */
    public void fillPostalCodes1() throws FileNotFoundException {
        apaController = new AssociatePostalAddressController();
    }

    /**
     * Check if introduced informations are valid
     *
     * @return boolean relative o the operation
     */
    public boolean checkInfo() {

        if (addresTextFiel.getText().isEmpty()) {
            errorAlert("No field should be left empty. Please try again.");
            addresTextFiel.clear();
            return false;
        } else if (locationTxtField.getText().isEmpty()) {
            errorAlert("No field should be left empty. Please try again.");
            locationTxtField.clear();
            return false;
        } else if (postCodCombo.getText().isEmpty()) {
            errorAlert("No field should be left empty. Please try again.");
            return false;
        } else if (!Instanciate.readPostalCodes(postCodCombo.getText())) {
            errorAlert("Invalid Postal Code");
            return false;
        }
        return true;
    }

    /**
     * Creates a Alert instance
     *
     * @param msg message to be displayed on the screen
     */
    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Submit Application");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
