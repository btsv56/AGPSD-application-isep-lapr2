/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.controller.MainClientController;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class MainClientUI implements Initializable {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Button exitButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button requestButton;
    @FXML
    private Button associateAddressButton;
    @FXML
    private Button decidePeriodButton;
    @FXML
    private Button rateSPButton;
    private Stage makeServiceProviding;
    private Stage associatePostAddress;
    private Stage rateServiceProvider;
    private Stage decidePeriodService;
    private MainClientController mcc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mcc = new MainClientController();
    }

    @FXML
    private void openMakeServiceProvidingRequest(ActionEvent event) {
        try {
            makeServiceProviding = new Stage();
            makeServiceProviding.initModality(Modality.APPLICATION_MODAL);

            makeServiceProviding.setTitle("Make Service Providing Request");
            makeServiceProviding.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvidingRequest.fxml"));
            Parent root = loader.load();
            Scene sceneMakeServiceProvidingController = new Scene(root);
            MakeServiceProvidingRequestUI makeServiceProvidingRequestUI = loader.getController();
            makeServiceProviding.setOnShowing(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    makeServiceProvidingRequestUI.resetScene();
                    makeServiceProvidingRequestUI.newServiceProvidingRequest();
                }

            });

            makeServiceProviding.setScene(sceneMakeServiceProvidingController);
            makeServiceProviding.show();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Window window = exitButton.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void setNameEmail() {
        welcomeLabel.setText("Welcome, " + mcc.getCurrentSession().getUserName());
        emailLabel.setText(mcc.getCurrentSession().getEmailUser());
    }

    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong credentials");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML

    private void logOut(ActionEvent event) {
        AppGPSD app = AppGPSD.getInstance();
        app.doLogout();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void handleAssociate(ActionEvent event) {
        try {
            associatePostAddress = new Stage();
            associatePostAddress.initModality(Modality.APPLICATION_MODAL);

            associatePostAddress.setTitle("Associate Postal Adress");
            associatePostAddress.setResizable(false);
            FXMLLoader loaderAssociatePostalAddress = new FXMLLoader(getClass().getResource("/fxml/AssociatePostalAddress.fxml"));
            Parent rootAssociatePostalAddress = loaderAssociatePostalAddress.load();
            Scene sceneAssociatePostAddress = new Scene(rootAssociatePostalAddress);

            associatePostAddress.setScene(sceneAssociatePostAddress);
            associatePostAddress.show();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }

    @FXML
    private void handleDecide(ActionEvent event) {
        try {
            decidePeriodService = new Stage();
            decidePeriodService.initModality(Modality.APPLICATION_MODAL);

            decidePeriodService.setTitle("Decide Period Service");
            decidePeriodService.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DecidePeriodService.fxml"));
            Parent root = loader.load();
            Scene sceneMakeServiceProvidingController = new Scene(root);
            DecidePeriodServiceUI decidePeriodServiceUI = loader.getController();
           decidePeriodService.setOnShowing(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    try {
                        decidePeriodServiceUI.FillNumProvList();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainClientUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

            decidePeriodService.setScene(sceneMakeServiceProvidingController);
            decidePeriodService.show();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    @FXML
    private void handleRate(ActionEvent event) {
        try {
            rateServiceProvider = new Stage();
            rateServiceProvider.initModality(Modality.APPLICATION_MODAL);

            rateServiceProvider.setTitle("Rate Service Provider");
            rateServiceProvider.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RateServiceProvider.fxml"));
            Parent root = loader.load();
            Scene sceneMakeServiceProvidingController = new Scene(root);
            RateServiceProviderUI rateServiceProviderUI = loader.getController();
           rateServiceProvider.setOnShowing(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    rateServiceProviderUI.getServices();
                }

            });

            rateServiceProvider.setScene(sceneMakeServiceProvidingController);
            rateServiceProvider.show();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

}
