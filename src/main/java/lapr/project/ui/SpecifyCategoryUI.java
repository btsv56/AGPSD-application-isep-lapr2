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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SpecifyCategoryController;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SpecifyCategoryUI implements Initializable {

    @FXML
    private Label labCode;
    @FXML
    private TextField txtFieldCode;
    @FXML
    private Label labDesc;
    @FXML
    private TextField txtFieldDesc;
    @FXML
    private Button butEnter;
    @FXML
    private Button butCancel;
    @FXML
    private Button butConfirm;
    private SpecifyCategoryController scc;
    @FXML
    private ListView<String> List;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            scc = new SpecifyCategoryController();
    }

    private void cancelEvent(ActionEvent event) {
        Stage stage = (Stage) butCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void EnterAction(ActionEvent event) {
        String strCodigo = txtFieldCode.getText();
        String strDescricao = txtFieldDesc.getText();
        scc.newCategory(strCodigo, strDescricao);
        List.getItems().add(strCodigo+", "+strDescricao);
    }

    @FXML
    private void CancelAction(ActionEvent event) {
        Stage stage = (Stage) butCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ConfirmAction(ActionEvent event) {
        scc.registerCategory();
        confirmationAlert("Category sucessfully registered.");
        clearFields();
    }
    
    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Successful operation.");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    private void clearFields() {
        txtFieldCode.clear();
        txtFieldDesc.clear();
        List.getItems().clear();
    }
    
}
