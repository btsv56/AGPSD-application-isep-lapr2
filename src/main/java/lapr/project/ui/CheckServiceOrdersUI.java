/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.CheckServiceOrdersController;
import lapr.project.gpsd.model.FormatType;
import lapr.project.gpsd.model.ServiceOrder;

/**
 * FXML Controller class
 *
 * @author lulu
 */
public class CheckServiceOrdersUI implements Initializable {

    @FXML
    private DatePicker initialDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private Button cancelButton;
    @FXML
    private Button exportButton;
    @FXML
    private Button btnConfirm;
    @FXML
    private ComboBox<String> formatComboBox;
    @FXML
    private ListView<ServiceOrder> serviceOrderList;
    private CheckServiceOrdersController checkServOrdersController;
    private List<ServiceOrder> servOrderList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.checkServOrdersController = new CheckServiceOrdersController();
    }

    /**
     * makes the controller go get the needed information to populate the format
     * combobox
     */
    public void initiateNewCheck() {
        checkServOrdersController.initiateNewCheck();
        List<FormatType> listFormats = checkServOrdersController.getFormatTypes();
        for (FormatType format : listFormats) {
            formatComboBox.getItems().add(format.getDesignation());
        }
    }

    /**
     * populates the ListView with the Service Orders gotten by the controller
     */
    @FXML
    private void getServiceOrders() {
        try {
            LocalDate dateB = initialDate.getValue();
            LocalDate dateE = endDate.getValue();
            this.servOrderList = checkServOrdersController.getServOrdersByProvider(dateB, dateE);
            serviceOrderList.getItems().clear();
            for (ServiceOrder servOrder : this.servOrderList) {
                serviceOrderList.getItems().add(servOrder);
            }
            formatComboBox.setDisable(false);
        } catch (IllegalArgumentException | NullPointerException iae) {
            errorAlert(iae.getMessage());
        }
    }

    /**
     * FXML Event. Cancels the Checking of the service orders
     *
     * @param event event
     */
    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Gets the data of the List of Service Orders to be exported, and sends it
     * to the controller class, to be exported
     *
     * @param event event
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     */
    @FXML
    private void export(ActionEvent event) throws InstantiationException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, IOException {
        List<ServiceOrder> servOrders = new ArrayList<>();
        for (int i = 0; i < serviceOrderList.getItems().size(); i++) {
            servOrders.add(serviceOrderList.getItems().get(i));
        }
        String format = this.formatComboBox.getValue();
        if (this.checkServOrdersController.export(servOrders, format)) {
            confirmationAlert("Service Orders exported Successfully");
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * Resets the scene
     */
    public void resetScene() {
//        exportButton.setDisable(true);
//        formatComboBox.setDisable(true);
    }

    /**
     * creates an error message
     *
     * @param msg message to be displayed
     */
    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't get Service Orders. Please check your Data.");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * creates a confirmation message
     *
     * @param msg message to be displayed
     */
    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Service Orders Exported Successfully. Please check your file.");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
