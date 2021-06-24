/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.autorization.model.UserRecords;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.ClientRecords;
import lapr.project.records.PostalCodeRecords;

/**
 *
 * @author paulomaio
 */
public class RegisterClientMenuController {

    private AppGPSD m_oApp;
    private Company m_oCompany;
    private Client m_oClient;
    private String m_strPwd;
    private ClientRecords m_cliRcds;
    private PostalCodeRecords m_postCodRcds;
    private AuthorizationFacade m_authFac;

    /**
     * Constructor
     */
    public RegisterClientMenuController() {
        m_oApp = AppGPSD.getInstance();
        this.m_oCompany = m_oApp.getCompany();
        this.m_postCodRcds = m_oCompany.getPostalCodeRecords();
        this.m_cliRcds=m_oCompany.getClientRecords();
        this.m_authFac=m_cliRcds.getAutorizacaoFacade();
    }
    
    /**
     * Validates client information
     * 
     * @param strNome String
     * @param strNIF String
     * @param strTelefone String
     * @param strEmail String
     * @param strPwd String
     * @param adds String[][]
     * @return boolean true if valid, false otherwise
     */
    public boolean newClient(String strNome, String strNIF, String strTelefone, String strEmail, String strPwd, String[][] adds)
    {
        try
        {
            this.m_strPwd = strPwd;
            this.m_oClient = this.m_cliRcds.newClient(strNome, strNIF, strTelefone, strEmail);
            addPostalAddress(adds);
            return true;
        }
        catch(RuntimeException ex)
        {
            //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oClient = null;
            return false;
        }
    }

    /**
     * Goes through Postal Address information
     * 
     * @param adds String[][]
     * @return boolean true if information is valid, false, otherwise
     */
    public boolean addPostalAddress(String[][] adds)
    {
        PostalCode postalCode;
        String address;
        String location;
        double lat;
        double lon;
        if (this.m_oClient != null)
        {
            try
            {
                for (int i=0;i<adds.length;i++) {
                    lat=m_postCodRcds.getLatitudeByID(adds[i][1]);
                    lon=m_postCodRcds.getLongitudeByID(adds[i][1]);
                    if (lat!=91 && lon!=181) {
                        PostalCode pc = new PostalCode(adds[i][1], lat, lon);
                        address = adds[i][0];
                        location = adds[i][2];
                        PostalAddress pAddress = Client.newPostalAddress(address, pc, location);
                        boolean flag=this.m_oClient.addPostalAddress(pAddress);
                    }
                    else { return false; }
                }
                return true;
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }

    /**
     * Registers the client
     * 
     * @return boolean result of clientRecords.registerClient
     */
    public boolean registerClient()
    {
        return this.m_cliRcds.registerClient(this.m_oClient, this.m_strPwd);
    }

    /**
     * @return String client.toString() 
     */
    public String getClientsString()
    {
        return this.m_oClient.toString();
    }

    /**
     * Checks if email is already registered
     * @param email String
     * @return boolean result of userRecords.hasUser(email)
     */
    public boolean checkEmail(String email) {
        return m_authFac.getUserRecords().hasUser(email);
    }
}
