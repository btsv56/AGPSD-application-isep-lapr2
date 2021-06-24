/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SubmitApplicationController;
import lapr.project.gpsd.model.Instanciate;
import lapr.project.gpsd.model.PostalAddress;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SubmitApplicationUI implements Initializable {

    private int num;
    private Stage submitDocuments;
    private SubmitApplicationController saController;
    @FXML
    private Button importButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField tinTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button addButton;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField listPostCodes;
    @FXML
    private ListView<String> listPostCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        importButton.setDisable(true);
    }

    /**
     * Open a Submit Documents Window
     *
     * @param event action event
     * @throws IOException
     */
    @FXML
    private void handleImport(ActionEvent event) throws IOException {
        submitDocuments = new Stage();
        submitDocuments.initModality(Modality.APPLICATION_MODAL);

        submitDocuments.setTitle("Submit Service Provider Application");
        submitDocuments.setResizable(false);

        FXMLLoader loaderSubmitDocuments = new FXMLLoader(getClass().getResource("/fxml/SubmitSPDocuments.fxml"));
        Parent rootSubmitDocuments = loaderSubmitDocuments.load();

        SubmitSPDocumentsUI sdoc = loaderSubmitDocuments.getController();
        sdoc.associateController(saController);

        Scene sceneRegisterClient = new Scene(rootSubmitDocuments);

        submitDocuments.setScene(sceneRegisterClient);
        submitDocuments.show();
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Cancel operation
     *
     * @param event action event
     */
    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Creates Application instance
     *
     * @param event action event
     */
    @FXML
    private void addAddress(ActionEvent event) {
        try {
            String name = nameTextField.getText();
            int tin = Integer.parseInt(tinTextField.getText());
            int tel = Integer.parseInt(phoneTextField.getText());
            String email = emailTextField.getText();
            String address = addressTextField.getText();
            String postalCode = listPostCodes.getText();
            String location = locationTextField.getText();
            if (checkInfo(String.valueOf(tin), String.valueOf(tel), email)) {
                listPostCode.getItems().add(address + ", " + postalCode + ", " + location);
                saController.newApplication(name, tin, tel, email, address, postalCode, location);
                addButton.setDisable(true);
                importButton.setDisable(false);
            }
        } catch (RuntimeException ex) {
            errorAlert("Something went wrong, check the submitted data and try again.");
            clearAllFields();
        }
    }

    /**
     * Clears all fields
     */
    private void clearAllFields() {
        nameTextField.clear();
        tinTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();
        addressTextField.clear();
        locationTextField.clear();
        listPostCodes.clear();
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

    /**
     * Initializes SubmitApplicationController
     *
     */
    public void fillPostalCodes1() {
        saController = new SubmitApplicationController();
    }

    /**
     *
     * Check if introduced informations are valid
     *
     * @param tin tin of the candidate
     * @param phNumber phoneNumber of candidate
     * @param email email of the candidate
     * @return boolean relative to the operation
     */
    public boolean checkInfo(String tin, String phNumber, String email) {
        if (nameTextField.getText().equals("") || emailTextField.getText().equals("")) {
            errorAlert("No field should be left empty. Please try again.");
            return false;
        }
        if (tin.length() != 9) {
            errorAlert("TIN number should have 9 digits. Please try again.");
            tinTextField.clear();
            return false;
        } else if (phNumber.length() != 9) {
            errorAlert("Phone number should have 9 digits. Please try again.");
            phoneTextField.clear();
            return false;
        } else if (saController.checkEmail(email)) {
            errorAlert("There already exists an account with that email. Please try again.");
            emailTextField.clear();
            return false;
        } else if (addressTextField.getText().isEmpty()) {
            errorAlert("No field should be left empty. Please try again.");
            addressTextField.clear();
            return false;
        } else if (locationTextField.getText().isEmpty()) {
            errorAlert("No field should be left empty. Please try again.");
            locationTextField.clear();
            return false;
        } else if (listPostCodes.getText().isEmpty()) {
            errorAlert("No field should be left empty. Please try again.");
            return false;
        } else if (!Instanciate.readPostalCodes(listPostCodes.getText())) {
            errorAlert("Invalid Postal Code");
            return false;
        }
        return true;
    }

}
