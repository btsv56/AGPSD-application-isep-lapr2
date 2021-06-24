/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SubmitApplicationController;
import lapr.project.gpsd.model.Category;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SubmitSPCategoriesUI implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;
    @FXML
    private ComboBox<Category> categoriesBox;
    @FXML
    private Button addButton;
    @FXML
    private ListView<String> showCategories;
    private SubmitApplicationController sac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Method that fill the combo box of the category
     */
    public void initial() {
        List<Category> cl = sac.getCategories();
        for (Category cat : cl) {
            categoriesBox.getItems().add(cat);
        }
    }

    /**
     * Cancel action
     *
     * @param event action event
     */
    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Registers application
     *
     * @param event
     */
    @FXML
    private void register(ActionEvent event) {
        try {
            if (sac.registerApplication()) {
                confirmationAlert("Submit Application Sucessful");
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            } else {
                errorAlert("Error");
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
        } catch (NullPointerException ex) {
            errorAlert("Error");
            errorAlert("Error");
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }

    }

    /**
     * Method that adds a category to the application
     *
     * @param event action event
     */
    @FXML
    private void addCategory(ActionEvent event) {
        Category cat = categoriesBox.getValue();
        if (cat != null) {
            sac.addCategory(cat);
            showCategories.getItems().add(cat.toString());
            registerButton.setDisable(false);
        } else {
            errorAlert("No categories have been selected.");
        }

    }

    /**
     * Method that assiates controller
     *
     * @param sac Submit Application Controller
     */
    public void associateController(SubmitApplicationController sac) {
        this.sac = sac;
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
     * Creates a Alert instance
     *
     * @param msg message to be displayed on the screen
     */
    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Submit Application Sucessful");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
