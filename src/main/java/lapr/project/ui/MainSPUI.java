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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.controller.MainSPController;

/**
 *
 * @author lulu
 */
public class MainSPUI implements Initializable {

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
    private Button indicateAvailabilityButton;
    @FXML
    private Button serviceOrdersButton;
    private Stage newAvailability;
    private Stage newCheckOrders;
    private Stage newCompleteService;
    private MainSPController mcc;
    @FXML
    private Button indicateCompleteServButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mcc = new MainSPController();
    }

    @FXML
    private void exit(ActionEvent event) {
        Window window = exitButton.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void help(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
        AppGPSD app = AppGPSD.getInstance();
        app.doLogout();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void handleIndicateAvailability(ActionEvent event) throws IOException {
        newAvailability = new Stage();
        newAvailability.initModality(Modality.APPLICATION_MODAL);

        newAvailability.setTitle("New availability");
        newAvailability.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewAvailability.fxml"));
        Parent root = loader.load();

        Scene sceneMakeServiceProvidingController = new Scene(root);

        NewAvailabilityUI newAvailabilityUI = loader.getController();

        newAvailability.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                newAvailabilityUI.resetScene();
                newAvailabilityUI.indicateNewAvailability();
            }

        });

        newAvailability.setScene(sceneMakeServiceProvidingController);
        newAvailability.show();
    }

    @FXML
    private void handleServiceOrders(ActionEvent event) throws IOException {
        newCheckOrders = new Stage();
        newCheckOrders.initModality(Modality.APPLICATION_MODAL);

        newCheckOrders.setTitle("New Order Check");
        newCheckOrders.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CheckServiceOrders.fxml"));
        Parent root = loader.load();

        Scene sceneCheckServiceOrdersController = new Scene(root);

        CheckServiceOrdersUI checkServOrdersUI = loader.getController();

        newCheckOrders.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
//                checkServOrdersUI.resetScene();
                checkServOrdersUI.initiateNewCheck();
            }

        });

        newCheckOrders.setScene(sceneCheckServiceOrdersController);
        newCheckOrders.show();
    }


    public void setNameEmail() {
        welcomeLabel.setText("Welcome, " + mcc.getCurrentSession().getUserName());
        emailLabel.setText(mcc.getCurrentSession().getEmailUser());
    }

    @FXML
    private void handleCompleteService(ActionEvent event) throws IOException {
        newCompleteService = new Stage();
        newCompleteService.initModality(Modality.APPLICATION_MODAL);

        newCompleteService.setTitle("Complete Service");
        newCompleteService.setResizable(false);

        FXMLLoader loaderSpecifyService = new FXMLLoader(getClass().getResource("/fxml/CompleteService.fxml"));
        Parent rootCompleteService = loaderSpecifyService.load();
        
        Scene sceneCompleteService = new Scene(rootCompleteService);

        newCompleteService.setScene(sceneCompleteService);
        newCompleteService.show();
    }
}
