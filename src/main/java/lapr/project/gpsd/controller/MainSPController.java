/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import lapr.project.autorization.model.UserSession;

/**
 * FXML Controller class
 *
 * @author joaol
 */
public class MainSPController {
    
    private AppGPSD app;

     public MainSPController() {
        app=AppGPSD.getInstance();
    }
    
    public UserSession getCurrentSession() {
        return this.app.getCurrentSession();
    }
}
