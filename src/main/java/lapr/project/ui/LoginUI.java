/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import lapr.project.autorization.model.UsersPaper;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.controller.DecidePeriodServiceController;
import lapr.project.gpsd.controller.LoginController;
import lapr.project.gpsd.model.Constants;

/**
 *
 * @author lulu
 */
public class LoginUI implements Initializable {
    
    private Stage mainClient;
    private Stage mainSP;
    private Stage mainHRO;
    private Stage mainAdmin;
    private Stage mainChoice;
    private Stage registerMain;
    private LoginController loginController;
    private AppGPSD app;
    private DecidePeriodServiceUI dps;

    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loginController=new LoginController();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void loginProcess(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loginController=new LoginController();
        String email=emailTextField.getText();
        String password=passwordTextField.getText();
        try {
            loginController.login(email, password);
            List<UsersPaper> list=loginController.getUserType();
            if (list.size()>1) {
                mainChoice = new Stage();
                mainChoice.initModality(Modality.APPLICATION_MODAL);

                mainChoice.setTitle("Role selection");
                mainChoice.setResizable(false);

                FXMLLoader loaderMainChoice = new FXMLLoader(getClass().getResource("/fxml/MainChoice.fxml"));
                Parent rootMainChoice = loaderMainChoice.load();

                Scene sceneMainChoice = new Scene(rootMainChoice);

                mainChoice.setScene(sceneMainChoice);
                mainChoice.show();
            } else {
                openStage(list.get(0).getPaper());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            errorAlert("Incorrect email or password. Please try again");
            emailTextField.clear();
            passwordTextField.clear();
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Window window = exitButton.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void registerProcess(ActionEvent event) throws IOException {
        registerMain = new Stage();
        registerMain.initModality(Modality.APPLICATION_MODAL);

        registerMain.setTitle("Choose an account type");
        registerMain.setResizable(false);

        FXMLLoader loaderRegisterMain = new FXMLLoader(getClass().getResource("/fxml/RegisterMain.fxml"));
        Parent rootRegisterMain = loaderRegisterMain.load();

        Scene sceneRegisterMain = new Scene(rootRegisterMain);

        registerMain.setScene(sceneRegisterMain);
        registerMain.show();
    }

    @FXML
    private void passFocus(ActionEvent event) {
        passwordTextField.requestFocus();
    }

    public LoginController getControllerClass() {
        return this.loginController;
    }
    
    public void openStage(String role) throws IOException {
        switch (role) {
            case Constants.PAPER_CLIENT:
                mainClient = new Stage();
                mainClient.initModality(Modality.APPLICATION_MODAL);

                mainClient.setTitle("Client Menu");
                mainClient.setResizable(false);

                FXMLLoader loaderMainClient = new FXMLLoader(getClass().getResource("/fxml/MainClient.fxml"));
                Parent rootMainClient = loaderMainClient.load();

                Scene sceneMainClient = new Scene(rootMainClient);

                MainClientUI mc = loaderMainClient.getController();
                mainClient.setOnShowing(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        try {
                            mc.setNameEmail();
                            dps.FillNumProvList();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                });
                mainClient.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                        alerta.setTitle("GPSD");
                        alerta.setHeaderText("Confirm action");
                        alerta.setContentText("Do you really want to close the application?");

                        if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                            event.consume();
                        }
                        else {
                            System.exit(0);
                        }
                    }
                });

                mainClient.setScene(sceneMainClient);
                mainClient.show();
                break;
            case Constants.PAPER_SERVICE_PROVIDER:
                mainSP = new Stage();
                mainSP.initModality(Modality.APPLICATION_MODAL);

                mainSP.setTitle("Service Provider Menu");
                mainSP.setResizable(false);

                FXMLLoader loaderMainSP = new FXMLLoader(getClass().getResource("/fxml/MainSP.fxml"));
                Parent rootMainSP = loaderMainSP.load();

                Scene sceneMainSP = new Scene(rootMainSP);

                MainSPUI msp = loaderMainSP.getController();
                mainSP.setOnShowing(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        try {
                            msp.setNameEmail();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                });

                mainSP.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                        alerta.setTitle("GPSD");
                        alerta.setHeaderText("Confirm action");
                        alerta.setContentText("Do you really want to close the application?");

                        if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                            event.consume();
                        }
                        else {
                            System.exit(0);
                        }
                    }
                });
                mainSP.setScene(sceneMainSP);
                mainSP.show();
                break;
            case Constants.PAPEL_HRO:
                mainHRO = new Stage();
                mainHRO.initModality(Modality.APPLICATION_MODAL);

                mainHRO.setTitle("HRO Menu");
                mainHRO.setResizable(false);

                FXMLLoader loaderMainHRO = new FXMLLoader(getClass().getResource("/fxml/MainHRO.fxml"));
                Parent rootMainHRO = loaderMainHRO.load();

                Scene sceneMainHRO = new Scene(rootMainHRO);

                MainHROUI mhro = loaderMainHRO.getController();
                mainHRO.setOnShowing(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        try {
                            mhro.setNameEmail();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                });
                mainHRO.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                        alerta.setTitle("GPSD");
                        alerta.setHeaderText("Confirm action");
                        alerta.setContentText("Do you really want to close the application?");

                        if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                            event.consume();
                        }
                        else {
                            System.exit(0);
                        }
                    }
                });
                mainHRO.setScene(sceneMainHRO);
                mainHRO.show();
                break;
            case Constants.PAPER_ADMINISTRATOR:
                mainAdmin = new Stage();
                mainAdmin.initModality(Modality.APPLICATION_MODAL);

                mainAdmin.setTitle("Admin Menu");
                mainAdmin.setResizable(false);

                FXMLLoader loaderMainAdmin = new FXMLLoader(getClass().getResource("/fxml/MainAdmin.fxml"));
                Parent rootMainAdmin = loaderMainAdmin.load();

                Scene sceneMainAdmin = new Scene(rootMainAdmin);

                MainAdminUI madm = loaderMainAdmin.getController();
                mainAdmin.setOnShowing(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        try {
                            madm.setNameEmail();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                });
                mainAdmin.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                        alerta.setTitle("GPSD");
                        alerta.setHeaderText("Confirm action");
                        alerta.setContentText("Do you really want to close the application?");

                        if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                            event.consume();
                        }
                        else {
                            System.exit(0);
                        }
                    }
                });
                mainAdmin.setScene(sceneMainAdmin);
                mainAdmin.show();
                break;
        }
    }
    
    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong credentials");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
