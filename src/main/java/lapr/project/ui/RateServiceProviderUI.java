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
import javafx.scene.control.Label;
import lapr.project.gpsd.controller.RateServiceProviderController;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class RateServiceProviderUI implements Initializable {

    @FXML
    private ComboBox<ServiceOrder> menuService;
    @FXML
    private ComboBox<String> rate;

    private RateServiceProviderController rspc;
    @FXML
    private Button confirm;
    @FXML
    private Label serviceProvider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Gets the service orders that haven't been rated but have already been executed
     */
    public void getServices() {
        menuService.getItems().clear();
        rate.setValue("Rate...");
        confirm.setDisable(true);
        rspc = new RateServiceProviderController();
        rspc.newRateService();
        List<ServiceOrder> services = rspc.getServiceOrdersExecutedByClient();
        menuService.getItems().addAll(services);

    }

    /**
     * Gets the service provider who executed the service order
     * 
     * @param event action event
     */
    @FXML
    private void getServiceProviderByService(ActionEvent event) {
        if (menuService.getValue() instanceof ServiceOrder) {
            ServiceProvider sp= rspc.getServiceProviderByServiceOrder(menuService.getValue());
            serviceProvider.setText(sp.getFullName());
            verifyAtivation();
        }
    }

    /**
     * Activates the confirm field
     * 
     * @param event action event
     */
    @FXML
    private void activateConfirm(ActionEvent event) {
        verifyAtivation();
    }

    
    /**
     * Confirms the rate selected
     * 
     * @param event action event
     */
    @FXML
    private void confirmRate(ActionEvent event) {
        rspc.rateServiceProvider(Integer.parseInt(rate.getValue()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Confirm rate?");
        alert.setContentText("Service Provider: " + serviceProvider.getText() + "\nRate: " + rate.getValue().toString());
        if (alert.showAndWait().get() == ButtonType.CANCEL) {
            event.consume();
        } else {
            rspc.registerRate();
            closeWindow(event);
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Invoice");
            alert2.setHeaderText("Service Order Cost");
            alert2.setContentText(menuService.getValue().showInvoice());
            alert2.showAndWait();
            
        }
    }

    /**
     * Verifies if the confirm field can be activated
     */
    private void verifyAtivation() {
        if (menuService.getValue() instanceof ServiceOrder && rspc.isInteger(rate.getValue())) {
            confirm.setDisable(false);
        }
    }

    /**
     * Closes the window
     * 
     * @param event action event
     */
    private void closeWindow(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
