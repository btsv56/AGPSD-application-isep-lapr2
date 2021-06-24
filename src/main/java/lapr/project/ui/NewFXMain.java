/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Instanciate;

/**
 *
 * @author Utilizador
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        primaryStage.setTitle("GPSD");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

                alerta.setTitle("GPSD");
                alerta.setHeaderText("Confirm action");
                alerta.setContentText("Do you really want to close the window?");

                if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                } else {
                    System.exit(0);
                }
            }
        });
        Instanciate.createCategories();
        Instanciate.createGeographicalAreas();
        Instanciate.createClients();
        Instanciate.createService();
        Instanciate.createServiceProvider();
        Instanciate.createApplication();
        Instanciate.createServiceProvidingRequest();
        Instanciate.createDisponibilities();
        Instanciate.createServiceOrders();
        Instanciate.createCompleteServices();
        Instanciate.createRate();
        primaryStage.show();
        company.startTimerTask(Constants.ASS_TASK_TIMER_MINUTES, Constants.ASS_TASK_METHOD_RS);
        System.out.println("Task scheduled.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
