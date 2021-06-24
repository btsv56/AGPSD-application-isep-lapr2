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
import lapr.project.gpsd.controller.MainHROController;

/**
 *
 * @author lulu
 */
public class MainHROUI implements Initializable {

    private Stage registerServProv;
    private Stage evaluateServProv;
    private MainHROController mhc;

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
    private Button registerProviderButton;
    @FXML
    private Button evaluateProviderButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mhc = new MainHROController();
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
    private void handleRegisterProvider(ActionEvent event) throws IOException {
        registerServProv = new Stage();
        registerServProv.initModality(Modality.APPLICATION_MODAL);

        registerServProv.setTitle("Register Service Provider");
        registerServProv.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegisterSP.fxml"));
        Parent root = loader.load();

        Scene sceneMakeServiceProvidingController = new Scene(root);

        RegisterSPUI registerSPUI = loader.getController();

        registerServProv.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                registerSPUI.resetScene();
                registerSPUI.initial();
            }
        });
        registerServProv.setScene(sceneMakeServiceProvidingController);
        registerServProv.show();
    }

    @FXML
    private void handleEvaluateProvider(ActionEvent event) throws IOException {
        evaluateServProv = new Stage();
        evaluateServProv.initModality(Modality.APPLICATION_MODAL);

        evaluateServProv.setTitle("Evaluate Service Provider");
        evaluateServProv.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EvaluateServiceProvider.fxml"));
        Parent root = loader.load();

        Scene sceneMakeServiceProvidingController = new Scene(root);

        EvaluateServiceProviderUI evaluateServProvUI = loader.getController();

        evaluateServProv.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                evaluateServProvUI.resetScene();
//                evaluateServProvUI.initial();
            }
        });
        evaluateServProv.setScene(sceneMakeServiceProvidingController);
        evaluateServProv.show();
    }

    public void setNameEmail() {
        welcomeLabel.setText("Welcome, " + mhc.getCurrentSession().getUserName());
        emailLabel.setText(mhc.getCurrentSession().getEmailUser());
    }

}
