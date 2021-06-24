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
import lapr.project.gpsd.controller.MainAdminController;

/**
 *
 * @author lulu
 */
public class MainAdminUI implements Initializable {

    private Stage specifyCategory;
    private Stage specifyService;
    private Stage specifyArea;
    private MainAdminController mac;
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
    private Button specifyCategoryButton;
    @FXML
    private Button specifyServiceButton;
    @FXML
    private Button specifyAreaButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mac = new MainAdminController();
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
        AppGPSD app= AppGPSD.getInstance();
        app.doLogout();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void handleSpecifyCategory(ActionEvent event) {
        try {
            specifyCategory = new Stage();
            specifyCategory.initModality(Modality.APPLICATION_MODAL);

            specifyCategory.setTitle("Specify category");
            specifyCategory.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SpecifyCategory.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            SpecifyCategoryUI specifyCategoryUI = loader.getController();
//            specifyCategory.setOnShowing(new EventHandler<WindowEvent>() {
//                @Override
//                public void handle(WindowEvent event) {
//                    specifyCategoryUI.resetScene();
//                    specifyCategoryUI.newServiceProvidingRequest();
//                }
//
//            });

            specifyCategory.setScene(scene);
            specifyCategory.show();
        } catch (IOException ioe) {
        }
    }

    @FXML
    private void handleSpecifyService(ActionEvent event) throws IOException {
        specifyService = new Stage();
        specifyService.initModality(Modality.APPLICATION_MODAL);

        specifyService.setTitle("Specify Service");
        specifyService.setResizable(false);

        FXMLLoader loaderSpecifyService = new FXMLLoader(getClass().getResource("/fxml/SpecifyService.fxml"));
        Parent rootSpecifyService = loaderSpecifyService.load();
        
        Scene sceneSpecifyService = new Scene(rootSpecifyService);

        specifyService.setScene(sceneSpecifyService);
        specifyService.show();
    }

    @FXML
    private void handleSpecifyArea(ActionEvent event) throws IOException {
        specifyArea = new Stage();
        specifyArea.initModality(Modality.APPLICATION_MODAL);

        specifyArea.setTitle("Specify Area");
        specifyArea.setResizable(false);

        FXMLLoader loaderSpecifyArea = new FXMLLoader(getClass().getResource("/fxml/SpecifyGeographicalArea.fxml"));
        Parent rootSpecifyArea = loaderSpecifyArea.load();
        
        Scene sceneSpecifyArea = new Scene(rootSpecifyArea);

        specifyArea.setScene(sceneSpecifyArea);
        specifyArea.show();
    }
    
    public void setNameEmail() {
        welcomeLabel.setText("Welcome, " + mac.getCurrentSession().getUserName());
        emailLabel.setText(mac.getCurrentSession().getEmailUser());
    }

}
