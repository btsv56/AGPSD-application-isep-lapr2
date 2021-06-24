/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.RegisterClientMenuController;
import lapr.project.gpsd.model.Instanciate;

/**
 *
 * @author lulu
 */
public class RegisterClientMenuUI implements Initializable {

    private RegisterMainUI registerMainUI;
    private RegisterClientMenuController rcmController;
    
    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField postalCodeTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private ListView<String> addressesField;
    @FXML
    private Button addAddressButton;
    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField tinTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private PasswordField passTextField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rcmController = new RegisterClientMenuController();
    }
    
    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleRegister(ActionEvent event){
        String name = fullNameTextField.getText();
        String email = emailTextField.getText();
        String tin = tinTextField.getText();
        String phNumber = phoneTextField.getText();
        String pass = passTextField.getText();
        String[][] adds=new String[addressesField.getItems().size()][3];
        if (checkInfo(tin, phNumber, email)) {
            for (int i=0;i<adds.length;i++) {
                String[] line = addressesField.getItems().get(i).split(",");
                adds[i][0]=line[0].trim();
                adds[i][1]=line[1].trim();
                adds[i][2]=line[2].trim();
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("GPSD");
            alert.setHeaderText("Confirm register");
            alert.setContentText("Name: "+name+"\nEmail: "+email+"\nTIN: "+tin+"\nPhone number: "+phNumber+"\nIs this correct?");
            if (alert.showAndWait().get() == ButtonType.CANCEL) {
                event.consume();
            }
            else {
                if (rcmController.newClient(name, tin, phNumber, email, pass, adds)) {
                    rcmController.registerClient();
                    Stage stage = (Stage) cancelButton.getScene().getWindow();
                    stage.close();
                }else {
                    errorAlert("Something went wrong, check the submitted data and try again.");
                    clearAllFields();
                }
            }
        }  
    }

    @FXML
    private void addAddress(ActionEvent event) {
        String address = addressTextField.getText();
        String postalCode = postalCodeTextField.getText();
        String location = locationTextField.getText();
        if(Instanciate.readPostalCodes(postalCode)) {
            addressesField.getItems().add(address+", "+postalCode+", "+ location);
        }else{
            errorAlert("Invalid Postal Code");
        }
    }
    
    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't register client");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    void associateController(RegisterMainUI registerMainUI) {
        this.registerMainUI=registerMainUI;
    }
    
    public RegisterClientMenuController getControllerClass() {
        return this.rcmController;
    }
    
    private void clearAllFields() {
        addressTextField.clear();
        locationTextField.clear();
        fullNameTextField.clear();
        emailTextField.clear();
        tinTextField.clear();
        phoneTextField.clear();
        passTextField.clear();
        addressesField.getItems().clear();
    }
    
    public boolean checkInfo(String tin, String phNumber, String email) {
        if (fullNameTextField.getText().equals("") || emailTextField.getText().equals("") || passTextField.getText().equals("") || addressesField.getItems().size()==0) {
            errorAlert("No field should be left empty. Please try again.");
            return false;
        }
        if (tin.length()!=9) {
            errorAlert("TIN number should have 9 digits. Please try again.");
            tinTextField.clear();
            return false;
        }
        else if (phNumber.length()!=9) {
            errorAlert("Phone number should have 9 digits. Please try again.");
            phoneTextField.clear();
            return false;
        }
        else if (rcmController.checkEmail(email)) {
            errorAlert("There already exists an account with that email. Please try again.");
            emailTextField.clear();
            return false;
        }
        return true;
    }
    
}
