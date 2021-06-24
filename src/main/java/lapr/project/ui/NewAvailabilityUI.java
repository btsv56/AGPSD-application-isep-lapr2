/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.NewAvailabilityController;
import lapr.project.gpsd.model.Availability;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class NewAvailabilityUI implements Initializable {

    @FXML
    private DatePicker initialDate;
    @FXML
    private TextField initialHour;
    @FXML
    private TextField finalHour;
    @FXML
    private Button buttonAdd;
    @FXML
    private DatePicker finalDate;
    @FXML
    private CheckBox everydayPeriod;
    @FXML
    private CheckBox mondayPeriod;
    @FXML
    private CheckBox tuesdayPeriod;
    @FXML
    private CheckBox wednesdayPeriod;
    @FXML
    private CheckBox thursdayPeriod;
    @FXML
    private CheckBox fridayPeriod;
    @FXML
    private CheckBox saturdayPeriod;
    @FXML
    private Button buttonConfirm;
    @FXML
    private Button buttonCancel;
    @FXML
    private ListView<Availability> avalList;
    private NewAvailabilityController nav;
    private Availability aval;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Starts to indicate a new availability
     */
    public void indicateNewAvailability() {
        nav =new NewAvailabilityController();
        nav.indicateNewAvailability();
    }

    /**
     * Creates a new availability
     *
     * @param event action event
     */
    @FXML
    private void newAvailibilityTime(ActionEvent event) {
        try {
            LocalDate dateI = initialDate.getValue();
            LocalDate dateF = finalDate.getValue();
            String hourI = initialHour.getText();
            String hourF = finalHour.getText();
            ArrayList<CheckBox> periodList = new ArrayList<>();
            periodList.add(mondayPeriod);
            periodList.add(tuesdayPeriod);
            periodList.add(wednesdayPeriod);
            periodList.add(thursdayPeriod);
            periodList.add(fridayPeriod);
            periodList.add(saturdayPeriod);
            periodList.add(everydayPeriod);
            String period = "";
            for (CheckBox p : periodList) {
                if (p.isSelected()) {
                    period += p.getText() + "|";
                }
            }
            aval = nav.newAvailibilityTime(dateI, dateF, hourI, hourF, period);
            nav.registerAvailabilityTime(aval);
            avalList.getItems().add(aval);
            cleanFields();
            buttonConfirm.setDisable(false);
        } catch (IllegalArgumentException iae) {
            createErrorAlert(iae.getMessage());
        } catch (NullPointerException npe) {
            createErrorAlert("There are still empty fields");
        }
    }

    /**
     * Registers all the availabilities
     *
     * @param event action event 
     */
    @FXML
    private void registerAvailabilityTime(ActionEvent event) {
        closeWindow(event);
    }

    /**
     * Cancels the process
     * 
     * @param event action event
     */
    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Closes the window
     *
     * @param event action event
     */
    private void closeWindow(ActionEvent event) {
        confirmationAlert("Added new availabilities successfully.");
        resetScene();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    /**
     * Resets the scene
     */
    public void resetScene() {
        cleanFields();
        avalList.getItems().clear();
        buttonConfirm.setDisable(true);
    }

    /**
     * Deactivates other periods when the everyday is activated
     *
     * @param event action event
     */
    @FXML
    private void deactivateOtherPeriods(ActionEvent event) {
        mondayPeriod.setSelected(false);
        tuesdayPeriod.setSelected(false);
        wednesdayPeriod.setSelected(false);
        thursdayPeriod.setSelected(false);
        fridayPeriod.setSelected(false);
        saturdayPeriod.setSelected(false);
    }

    /**
     * Cleans fields
     */
    private void cleanFields() {
        initialDate.getEditor().clear();
        finalDate.getEditor().clear();
        initialHour.setText("");
        finalHour.setText("");
    }

    /**
     * Creates a error message
     *
     * @param msg error message
     */
    private void createErrorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Problem indicating new availability");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Shows a confirmation alert
     * 
     * @param msg alert message
     */
    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Successfull Operation");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Deactivates the everyday period when ohter period is selected
     * 
     * @param event action event
     */
    @FXML
    private void deactivateEveryday(ActionEvent event) {
        everydayPeriod.setSelected(false);
        if (mondayPeriod.isSelected() && tuesdayPeriod.isSelected() && wednesdayPeriod.isSelected() && thursdayPeriod.isSelected()
                && fridayPeriod.isSelected() && saturdayPeriod.isSelected()) {
            everydayPeriod.setSelected(true);
            mondayPeriod.setSelected(false);
            tuesdayPeriod.setSelected(false);
            wednesdayPeriod.setSelected(false);
            thursdayPeriod.setSelected(false);
            fridayPeriod.setSelected(false);
            saturdayPeriod.setSelected(false);
        }
    }

}
