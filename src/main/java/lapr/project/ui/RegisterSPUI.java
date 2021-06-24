package lapr.project.ui;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.RegisterSPController;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.Instanciate;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class RegisterSPUI implements Initializable {

    private RegisterMainUI registerMain;

    private RegisterSPController regSPController;

    @FXML
    private TextField txtTinNumber;
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAbreviatedName;
    @FXML
    private TextField txtTelephoneNumber;
    @FXML
    private TextField txtPostalAddress;
    @FXML
    private ComboBox<Category> menuCategories;
    @FXML
    private ComboBox<GeographicalArea> menuGeoAreas;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnRegister;
    @FXML
    private Button cancelButton;
    @FXML
    private ListView<Category> categoryList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        regSPController = new RegisterSPController();
    }

    public void initial() {
        List<Category> categories = regSPController.getCategories();
        List<GeographicalArea> geoAreas = regSPController.getGeoAreas();
        for (Category cat : categories) {
            menuCategories.getItems().add(cat);
        }
        for (GeographicalArea geoArea : geoAreas) {
            menuGeoAreas.getItems().add(geoArea);
        }
    }

    @FXML
    private void getProviderInfo(ActionEvent event) {
        try {
            int tinNumber = Integer.parseInt(txtTinNumber.getText());
            regSPController.getProviderInfo(tinNumber);
            txtFullName.setText(regSPController.getFullName());
            txtAbreviatedName.setText(regSPController.getAbreviatedName());
            txtEmail.setText(regSPController.getEmail());
            txtTelephoneNumber.setText(regSPController.getTelephoneNumber());
            txtPostalAddress.setText(regSPController.getPostalAddress().getPostalCode().getPostalCode());
            List<Category> catList = regSPController.getCategorySP();
            for (Category cat : catList) {
                categoryList.getItems().add(cat);
            }
            txtFullName.setDisable(false);
            txtEmail.setDisable(false);
            txtAbreviatedName.setDisable(false);
            txtTelephoneNumber.setDisable(false);
            txtPostalAddress.setDisable(false);
            btnConfirm.setDisable(false);
            menuCategories.setDisable(false);
            menuGeoAreas.setDisable(false);
            btnRegister.setDisable(false);
        } catch (IllegalArgumentException iae) {
            errorAlert("Invalid TIN Number");
        }
    }

    @FXML
    private void confirmInfo(ActionEvent event) {
        checkInfo();
    }

    @FXML
    private void registerNewServiceProvider(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedEncodingException {
        int tinNumber = Integer.parseInt(txtTinNumber.getText());
        int phoneNumber = Integer.parseInt(txtTelephoneNumber.getText());
        Category[] categories = new Category[categoryList.getItems().size()];
        for (int i = 0; i < categoryList.getItems().size(); i++) {
            categories[i] = categoryList.getItems().get(i);
        }
        GeographicalArea geoArea = menuGeoAreas.getValue();
        if (regSPController.registerNewServiceProvider(txtFullName.getText(), txtAbreviatedName.getText(), tinNumber, phoneNumber, txtEmail.getText(), categories, geoArea)) {
            confirmationAlert("New Service Provider Registered Succesfully\nPassword:" + regSPController.getPWD());
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        } else {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void cancelNewServProvider(ActionEvent event) {
        clearFields();
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        txtFullName.clear();
        txtAbreviatedName.clear();
        txtEmail.clear();
        txtTelephoneNumber.clear();
        txtTinNumber.clear();
        txtPostalAddress.clear();
    }

    /**
     * Resets the scene
     */
    public void resetScene() {
        clearFields();
        categoryList.getItems().clear();
        menuCategories.setDisable(true);
        menuGeoAreas.setDisable(true);
        btnRegister.setDisable(true);
        btnConfirm.setDisable(true);

    }

    @FXML
    private void addCategory(ActionEvent event) {
        Category category = menuCategories.getValue();
        categoryList.getItems().add(category);
    }

    void associateController(RegisterMainUI registerMain) {
        this.registerMain = registerMain;
    }

    private void errorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Couldn't Register Service Provider");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void confirmationAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Service Provider Registered Successfully");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public boolean checkInfo() {
        if (txtFullName.getText().equals("") || txtEmail.getText().equals("") || txtAbreviatedName.getText().equals("")) {
            errorAlert("No field should be left empty. Please try again.");
            return false;
        }
        if (txtTinNumber.getText().length() != 9) {
            errorAlert("TIN number should have 9 digits. Please try again.");
            txtTinNumber.clear();
            return false;
        } else if (txtTelephoneNumber.getText().length() != 9) {
            errorAlert("Phone number should have 9 digits. Please try again.");
            txtTelephoneNumber.clear();
            return false;
        } else if (regSPController.checkEmail(txtEmail.getText())) {
            errorAlert("There already exists an account with that email. Please try again.");
            txtEmail.clear();
            return false;
        } else if (menuGeoAreas.getSelectionModel().isEmpty()) {
            errorAlert("Please select a Geographical Area.");
            return false;
        } else if (categoryList.getItems().isEmpty()) {
            errorAlert("Please select at least one Category.");
            return false;
        }
        return true;
    }
}
