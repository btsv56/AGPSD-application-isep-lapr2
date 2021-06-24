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
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class RegisterMainUI implements Initializable {
    
    private Stage registerClient;
    private Stage submitApplication;
    
    @FXML
    private Button clientButton;
    @FXML
    private Button spButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void registerClient(ActionEvent event) throws IOException {
        registerClient = new Stage();
        registerClient.initModality(Modality.APPLICATION_MODAL);

        registerClient.setTitle("Register as a Client");
        registerClient.setResizable(false);

        FXMLLoader loaderRegisterClient = new FXMLLoader(getClass().getResource("/fxml/RegisterClientMenu.fxml"));
        Parent rootRegisterClient = loaderRegisterClient.load();

        Scene sceneRegisterClient = new Scene(rootRegisterClient);

        RegisterClientMenuUI rc = loaderRegisterClient.getController();

        registerClient.setScene(sceneRegisterClient);
        registerClient.show();
        Stage stage = (Stage) spButton.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void registerSP(ActionEvent event) throws IOException {
        submitApplication = new Stage();
        submitApplication.initModality(Modality.APPLICATION_MODAL);

        submitApplication.setTitle("Submit Application ");
        submitApplication.setResizable(false);

        FXMLLoader loaderSubmitApplicationSP = new FXMLLoader(getClass().getResource("/fxml/SubmitSPApplication.fxml"));
        Parent rootSubmitApplicationSP  = loaderSubmitApplicationSP.load();

        Scene scenesubmitApplication = new Scene(rootSubmitApplicationSP);
        SubmitApplicationUI sa = loaderSubmitApplicationSP.getController();
        submitApplication.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    sa.fillPostalCodes1();
            }
        });
        submitApplication.setScene(scenesubmitApplication);
        submitApplication.show();
        Stage stage = (Stage) spButton.getScene().getWindow();
        stage.close();
    }
    
}
