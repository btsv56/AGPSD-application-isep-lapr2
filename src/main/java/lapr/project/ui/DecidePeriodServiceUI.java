/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.DecidePeriodServiceController;
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
import lapr.project.records.AssociationProviderRequestRecords;

/**
 *
 * @author Andre
 *
 */
public class DecidePeriodServiceUI implements Initializable {

    private DecidePeriodServiceController dps;
    private AssociationProviderRequestRecords aprr;
    @FXML
    private Label labSR;
    @FXML
    private Label labSS;
    @FXML
    private Button butReject;
    @FXML
    private Button butCancel;
    @FXML
    private ListView<Integer> lstNum;
    @FXML
    private ListView<String> lstProv;
    @FXML
    private ListView<Integer> lstDur;
    @FXML
    private ListView<ServiceProvidingRequestDescription> lstDesc;
    @FXML
    private TextField txtNumCheckDurDesc;
    @FXML
    private Button ConfirmNum;
    @FXML
    private ListView<LocalDate> lstDay;
    @FXML
    private ListView<Time> lstHour;
    @FXML
    private Label labSelectSSbyNum;
    @FXML
    private Button butAccept;
    @FXML
    private Button butShow;
    @FXML
    private ListView<Double> lstRating;

    /**
     * Fill the first and second ListViews (Number and Provider)
     * 
     * @throws FileNotFoundException 
     */
    public void FillNumProvList() throws FileNotFoundException {
        dps = new DecidePeriodServiceController();
        dps.getListAssociatedClient();
        int num = dps.getAssoListRefCliSize();
        for (int i = 0; i < num; i++) {
            lstNum.getItems().add(i);
            lstProv.getItems().add(i, dps.getProviderNameFromAssociatedList(i));
        }
        butAccept.setDisable(true);
        butReject.setDisable(true);
    }

    /**
     * Initialize
     * 
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * The client rejects the service schedule
     * 
     * @param event 
     */
    @FXML
    private void IfReject(ActionEvent event) {
        dps.IfRejectsSchedule();
        Stage stage = (Stage) butReject.getScene().getWindow();
        stage.close();
    }

    /**
     * The client cancels the operation
     * 
     * @param event 
     */
    @FXML
    private void IfCancel(ActionEvent event) {
        Stage stage = (Stage) butCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Alert after success
     * 
     * @param msg 
     */
    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Successful operation.");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Clear fields
     */
    private void clearFields() {
        txtNumCheckDurDesc.clear();
    }

    /**
     * The client accepts the service schedule sugested
     * 
     * @param event 
     */
    @FXML
    private void IfAccept(ActionEvent event) {
        ServiceSchedule ssAccepted = dps.getServiceSchedule();
        dps.registerServiceOrdersIfAccept(ssAccepted);
        confirmationAlert("Period service defined with success");
        String strNum = txtNumCheckDurDesc.getText();
        int num = Integer.parseInt(strNum);
        dps.removeAssoFromAssoList(num);
        clearFields();
        Stage stage = (Stage) butAccept.getScene().getWindow();
        stage.close();
    }

    /**
     *  After seing the number inserted, shows the descriptions
     * and duration of the request assignied to the provider shown.
     * 
     * @param event 
     */
    @FXML
    private void CheckDescAndDurByNum(ActionEvent event) {
        lstDesc.getItems().clear();
        lstDur.getItems().clear();
        lstRating.getItems().clear();
        String strNum = txtNumCheckDurDesc.getText();
        int num = Integer.parseInt(strNum);
        List<ServiceProvidingRequestDescription> lstDescCli = dps.getDescList(num);
        lstDesc.getItems().setAll(lstDescCli);
        for (int i = 0; i < lstDescCli.size(); i++) {
            lstDur.getItems().add(lstDescCli.get(i).getDuration());
        }
        ServiceProvider prov =dps.getProviderFromAssociatedList(num);
        lstRating.getItems().add(dps.getRatingProvider(prov));   
    }

    /**
     *  Client confirms that the number inserted corresponds to
     * the request he wanted to decide the period of execution.
     * 
     * @param event 
     */
    @FXML
    private void confirmNumServiceSelected(ActionEvent event) {
        String strServ = txtNumCheckDurDesc.getText();
        int numServ = Integer.parseInt(strServ);
        ServiceSchedule ss = dps.getServiceSchedule(numServ); 
        LocalDate day = ss.getDate();
        Time hour = ss.getHour();
        lstDay.getItems().add(day);
        lstHour.getItems().add(hour);
        butAccept.setDisable(false);
        butReject.setDisable(false);
        ConfirmNum.setDisable(true);
        butShow.setDisable(true);   
                

    }

}
