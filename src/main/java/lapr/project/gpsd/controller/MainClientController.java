/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Company;

/**
 * FXML Controller class
 *
 * @author joaol
 */
public class MainClientController {
    
    private AppGPSD app;
    private LoginController lg;
    
    public MainClientController() {
        app=AppGPSD.getInstance();
    }
    
    public UserSession getCurrentSession() {
        return this.app.getCurrentSession();
    }
    
    public Company getCompany() {
        return app.getCompany();
    }

}
