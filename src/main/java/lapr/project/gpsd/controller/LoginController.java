/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import lapr.project.gpsd.model.Company;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.autorization.model.UserSession;
import lapr.project.autorization.model.UsersPaper;
import lapr.project.gpsd.model.Instanciate;

/**
 * FXML Controller class
 *
 * @author joaol
 */
public class LoginController {

    private AuthorizationFacade authFacade;
    private UserSession userSession;
    private AppGPSD app;
    private Company company;

    public LoginController() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException, UnsupportedEncodingException {
        app = AppGPSD.getInstance();
        this.company = app.getCompany();
        authFacade = company.getClientRecords().getAutorizacaoFacade();
    }

    public boolean login(String email, String pass) {
        try {
            userSession = authFacade.doLogin(email, pass);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<UsersPaper> getUserType() {
        if (userSession != null) {
            return userSession.getUserPapers();
        }
        return null;
    }

    public UserSession getUserSession() {
        return this.userSession;
    }

    public Company getCompany() {
        return this.company;
    }

}
