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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lapr.project.gpsd.controller.SubmitApplicationController;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SubmitSPDocumentsUI implements Initializable {

    private SubmitApplicationController saController;
    private Stage submitCategories;
    @FXML
    private Button cancelButton;
    @FXML
    private Button addCategoriesButton;
    @FXML
    private TextField designationTextField;
    @FXML
    private TextField degreeTextField;
    @FXML
    private TextField classificationTextField;
    @FXML
    private Button addAcadButton;
    @FXML
    private Button addProfButton;
    @FXML
    private ListView<String> academicList;
    @FXML
    private TextField suppTextField;
    @FXML
    private Button addSuppButton;
    @FXML
    private ListView<String> profList;
    @FXML
    private ListView<String> suppList;
    @FXML
    private TextField acadTextField;
    private SubmitApplicationController sac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addCategoriesButton.setDisable(true);
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
     * Open a Submit Categories Window
     *
     * @param event acation event
     * @throws IOException
     */
    @FXML
    private void handleAddCategories(ActionEvent event) throws IOException {
        submitCategories = new Stage();
        submitCategories.initModality(Modality.APPLICATION_MODAL);

        submitCategories.setTitle("Submit Service Provider Application");
        submitCategories.setResizable(false);

        FXMLLoader loaderSubmitCategories = new FXMLLoader(getClass().getResource("/fxml/SubmitSPCategories.fxml"));
        Parent rootSubmitDocuments = loaderSubmitCategories.load();

        SubmitSPCategoriesUI sspc = loaderSubmitCategories.getController();
        sspc.associateController(sac);

        submitCategories.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                sspc.initial();
            }
        });

        Scene sceneRegisterClient = new Scene(rootSubmitDocuments);

        submitCategories.setScene(sceneRegisterClient);
        submitCategories.show();
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Adds Supporting document
     *
     * @param event acction event
     */
    @FXML
    private void addSupporting(ActionEvent event) {
        String doc = suppTextField.getText();
        if (sac.addSupportingDoc(doc)) {
            suppList.getItems().add(doc);
            addCategoriesButton.setDisable(false);
        } else {
            errorAlertSupport("Something went wrong, check the submitted data and try again.");
        }

    }

    /**
     * Adds professional habilitation
     *
     * @param event action event
     */
    @FXML
    private void addProf(ActionEvent event) {
        try {
            String designation = designationTextField.getText();
            int degree = Integer.parseInt(degreeTextField.getText());
            String classification = classificationTextField.getText();
            if (sac.addProfHabilitation(designation, degree, classification)) {
                academicList.getItems().add(designation + "," + degree + "," + classification);
            } else {
                errorAlertProf("Something went wrong, check the submitted data and try again.");
            }
        } catch (RuntimeException ex) {
            errorAlertProf("Something went wrong, check the submitted data and try again.");
        }

    }

    /**
     * Adds an academic habilitation
     *
     * @param event action event
     */
    @FXML
    private void addAcad(ActionEvent event) {
        String desc = acadTextField.getText();
        if (sac.addAcadHabilitation(desc)) {
            profList.getItems().add(desc);
        } else {
            errorAlertAca("Something went wrong, check the submitted data and try again.");
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
    private void errorAlertAca(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Submit Academic Habilitations");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Creates a Alert instance
     *
     * @param msg message to be displayed on the screen
     */
    private void errorAlertProf(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Submit Professsional Habilitations");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Creates a Alert instance
     *
     * @param msg message to be displayed on the screen
     */
    private void errorAlertSupport(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Submit Supporting Document");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
