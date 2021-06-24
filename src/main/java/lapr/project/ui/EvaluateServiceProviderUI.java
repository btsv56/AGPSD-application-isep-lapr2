package lapr.project.ui;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.controller.EvaluateServiceProviderController;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.ServiceProviderRecords;

public class EvaluateServiceProviderUI implements Initializable {

    private EvaluateServiceProviderController evServProvController;
    private ServiceProviderRecords servProvRecords;

    @FXML
    private Button btnCancel;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button btnSearch;

    @FXML
    private BarChart<?, ?> ratingDistribution;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private TextField txtMeanSP;

    @FXML
    private TextField txtDeviationAll;

    @FXML
    private TextField txtMeanAll;

    @FXML
    private ComboBox<String> classificationBox;

    @FXML
    private ComboBox<ServiceProvider> serviceProviderBox;

    @FXML
    private TextField txtDeviationSP;

    @FXML
    private Button btnConfirm;

    private List<ServiceProvider> serviceProviderList;
    private ServiceProvider servProvider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            evServProvController = new EvaluateServiceProviderController();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EvaluateServiceProviderUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvaluateServiceProviderUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        classificationBox.getItems().add(Constants.OUTSANDING);
        classificationBox.getItems().add(Constants.REGULAR);
        classificationBox.getItems().add(Constants.WORST);
        this.servProvRecords = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        this.serviceProviderList = new ArrayList<>(evServProvController.getServiceProviders());
        for (ServiceProvider servProv : this.serviceProviderList) {
            serviceProviderBox.getItems().add(servProv);
        }

    }

    /**
     * handles the cancel button
     *
     * @param event event
     */
    @FXML
    void cancelRatingSP(ActionEvent event) {
        clearFields();
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * handles the confirmation button
     *
     * @param event event
     */
    @FXML
    void confirmRatingSP(ActionEvent event) {
        String evaluation = classificationBox.getValue();
        double mean = Double.parseDouble(txtMeanSP.getText());
        if (this.evServProvController.registerEvaluation(evaluation, mean)) {

            confirmationAlert("New Service Provider Registered Succesfully");
            clearFields();
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        } else {
            clearFields();
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * handles the search button
     *
     * @param event event
     */
    @FXML
    void getServProvByEmail(ActionEvent event) {
        classificationBox.setDisable(false);
        btnConfirm.setDisable(false);
        XYChart.Series set1 = new XYChart.Series<>();
        for (ServiceProvider servProv : this.serviceProviderList) {
            set1.getData().add(new XYChart.Data(servProv.getFullName(), servProv.getRateList().getMeanRate()));
        }
        ratingDistribution.getData().clear();
        ratingDistribution.getData().addAll(set1);
        ServiceProvider serv = serviceProviderBox.getValue();
        evServProvController.setServProv(serv);
        double meanSP = serv.getRateList().getMeanRate();
        DecimalFormat format = new DecimalFormat("#.##");
        txtMeanSP.setText(String.valueOf(format.format(meanSP)));
        double meanAllSP = evServProvController.calculateMeanRate();
        txtMeanAll.setText(String.valueOf(format.format(meanAllSP)));
        double deviationAllSP = evServProvController.calculateStandardDeviationAll();
        txtDeviationAll.setText(String.valueOf(format.format(deviationAllSP)));
        double deviationSP = evServProvController.calculateStandardDeviationSP();
        txtDeviationSP.setText(String.valueOf(format.format(deviationSP)));
        String label = evServProvController.labelSP();
        classificationBox.setValue(label);
    }

    /**
     * resets the scene to it's original form
     */
    public void resetScene() {
        clearFields();
        classificationBox.setDisable(true);
        btnConfirm.setDisable(true);
    }

    /**
     * clears all fields
     */
    private void clearFields() {
        txtMeanSP.clear();
        txtMeanAll.clear();
        txtDeviationAll.clear();
        txtDeviationSP.clear();
    }

    /**
     * creates an error alert
     *
     * @param msg message
     */
    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Register Evaluation");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * creates a confirmation alert
     *
     * @param msg message
     */
    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Evaluation Registered Successfully");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
