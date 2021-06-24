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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lapr.project.gpsd.controller.MakeServiceProvidingRequestController;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.Service;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class MakeServiceProvidingRequestUI implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private TextField hour;
    @FXML
    private TextField dur;
    @FXML
    private Button buttonAddService;
    @FXML
    private ComboBox<Category> menuCategories;
    @FXML
    private ComboBox<PostalAddress> menuAddresses;
    @FXML
    private ComboBox<Service> menuServices;
    @FXML
    private Button btnAddTime;
    @FXML
    private TextField description;
    @FXML
    private Button buttonConfirm;
    @FXML
    private ListView<String> listService;
    @FXML
    private ListView<String> listTime;
    private MakeServiceProvidingRequestController mspr;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Gets the client's postal addresses
     */
    public void newServiceProvidingRequest() {
        mspr = new MakeServiceProvidingRequestController();
        List<PostalAddress> postalAddressList = mspr.newServiceProvidingRequest();
        menuAddresses.setDisable(false);
        for (PostalAddress end : postalAddressList) {
            menuAddresses.getItems().add(end);
        }
    }

    /**
     * Chooses one postal address
     * 
     * @param event action event
     */
    @FXML
    private void setPostalAddress(ActionEvent event) {
        if (menuAddresses.getValue() instanceof PostalAddress) {
            PostalAddress endP = menuAddresses.getValue();
            mspr.setPostalAddress(endP);
            activateRequestFields();
        }
    }

    /**
     * Gets de available categories
     * 
     * @param event mouse event
     */
    @FXML
    private void getCategories(MouseEvent event) {
        menuCategories.getItems().clear();
        menuServices.getItems().clear();
        menuServices.setDisable(true);
        List<Category> cl = mspr.getCategories();
        for (Category cat : cl) {
            menuCategories.getItems().add(cat);
        }
    }

    /**
     * Disables de service menu
     * 
     * @param event action event
     */
    @FXML
    private void activateServices(ActionEvent event) {
        if (menuCategories.getValue() instanceof Category) {
            menuServices.setDisable(false);
            menuServices.getItems().clear();
        }
    }

    /**
     * Gets services by the category selected
     * 
     * @param event mouse event
     */
    @FXML
    private void getServicesByCategory(MouseEvent event) {
        menuServices.getItems().clear();
        dur.setDisable(true);
        dur.clear();
        Category cat = menuCategories.getValue();
        List<Service> ls = mspr.getServicesByCategory(cat);
        for (Service serv : ls) {
            menuServices.getItems().add(serv);
        }
    }

    /**
     * Creates a service providing request
     * 
     * @param event action event
     */
    @FXML
    private void addServiceProvidingRequest(ActionEvent event) {
        try {
            Service serv = menuServices.getValue();
            int temp;
            if (serv instanceof FixedService) {
                temp = ((FixedService) serv).getPreDeterminedDuration();
            } else {
                temp = Integer.parseInt(dur.getText());
            }
            String desc = description.getText();
            mspr.addServiceProvidingRequest(serv, desc, temp);
            listService.getItems().add("Service: " + serv + " - " + desc + " Duration time: " + temp);
            cleanRequest();
            dur.setDisable(true);
            activateTimeFields();
        } catch (NumberFormatException nfe) {
            dur.setText("");
            createAlert(Alert.AlertType.ERROR, "Error", "Problem with the service selected", "Duration must be an integer");
        } catch (IllegalArgumentException iae) {
            createAlert(Alert.AlertType.ERROR, "Error", "Problem with the service selected", iae.getMessage());
        }
    }

    /**
     * Adds time to the service providing request
     * 
     * @param event action event
     */
    @FXML
    private void addTime(ActionEvent event) {
        try {
            mspr.addTime(date.getValue(), hour.getText());
            listTime.getItems().add(date.getEditor().getText() + " - " + hour.getText());
            cleanTime();
            buttonConfirm.setDisable(false);
        } catch (NumberFormatException nfe) {
            createAlert(Alert.AlertType.ERROR, "Error", "Problem with the schedule", "The time introduced is invalid");
        } catch (IllegalArgumentException iae) {
            createAlert(Alert.AlertType.ERROR, "Error", "Problem with the schedule", iae.getMessage());
        }
    }

    /**
     * Registers the service providing request
     * 
     * @param event  action event
     */
    @FXML
    private void registerRequest(ActionEvent event) {
        mspr.validates();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Confirm request?");
        alert.setContentText("Estimated cost: " + String.valueOf(mspr.getTotalCost())+" €");
        if (alert.showAndWait().get() == ButtonType.CANCEL) {
            event.consume();
        } else {
            int num = mspr.registerRequest();
            closeWindow(event);
        }

    }

    /**
     * Closes the window
     *
     * @param event
     */
    @FXML
    private void closeWindow(ActionEvent event) {
        resetScene();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    /**
     * Avtivates the fields related to categories, duration and description
     */
    private void activateRequestFields() {
        menuCategories.setDisable(false);
        description.setDisable(false);
    }

    /**
     * Cleans all fields
     */
    public void resetScene() {
        menuAddresses.getItems().clear();
        menuAddresses.setDisable(false);
        menuCategories.setDisable(true);
        dur.setDisable(true);
        hour.setDisable(true);
        date.setDisable(true);
        description.setDisable(true);
        btnAddTime.setDisable(true);
        listTime.getItems().clear();
        listService.getItems().clear();
        buttonConfirm.setDisable(true);
        cleanRequest();
        cleanTime();
    }

    /**
     * Cleans the time fields
     */
    private void cleanTime() {
        date.getEditor().clear();
        hour.setText("");
    }

    /**
     * Cleans the category menu, service menu e desactivates the address and
     * service menu
     */
    private void cleanRequest() {
        menuCategories.getItems().clear();
        menuServices.getItems().clear();
        dur.setText("");
        description.setText("");
        menuAddresses.setDisable(true);
        menuServices.setDisable(true);
    }

    /**
     * Ativa os campos da hora, data e o botão para adicionar
     */
    private void activateTimeFields() {
        hour.setDisable(false);
        date.setDisable(false);
        btnAddTime.setDisable(false);
    }

    /**
     * Creates an alert
     *
     */
    private void createAlert(Alert.AlertType al, String title, String cab, String msg) {
        Alert alert = new Alert(al);
        alert.setTitle(title);
        alert.setHeaderText(cab);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Activates or deactivates the duration field
     * 
     * @param event action event
     */
    @FXML
    private void activateDuration(ActionEvent event) {
        if(menuServices.getValue() instanceof FixedService) {
            dur.setDisable(true);
            dur.clear();
        }else{
            dur.setDisable(false);
        }
    }
}
