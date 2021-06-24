/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.records.ClientRecords;
import lapr.project.records.PostalCodeRecords;

/**
 *
 * @author User
 */
public class AssociatePostalAddressController {

    /**
     * Company
     */
    private Company company;
    /**
     * Client
     */
    private Client cli;
    /**
     * Postal Address
     */
    private PostalAddress ad1;
    /**
     * AppGPSD
     */
    private AppGPSD app;
    /**
     * Postal Code Records
     */
    private PostalCodeRecords pcr;

    /**
     * Method that gets the company, and PostalCodeRecords
     *
     * @throws FileNotFoundException exception
     */
    public AssociatePostalAddressController() throws FileNotFoundException {
        this.app = AppGPSD.getInstance();
        this.company = AppGPSD.getInstance().getCompany();
        this.pcr = company.getPostalCodeRecords();
    }

    /**
     * Method that gets client by email
     *
     * @throws FileNotFoundException
     */
    public void newPostalAddress() throws FileNotFoundException {
        AppGPSD app = AppGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email = session.getEmailUser();
        ClientRecords rc = company.getClientRecords();
        this.cli = rc.getClientByEmail(email);
    }

    /**
     * Method that create a new Postal Address and equals the attribute
     *
     * @param adress Address of Postal Address
     * @param postCode PostalCode of Postal Address
     * @param local location of Postal Address
     * @throws FileNotFoundException exception
     */
    public void newPostalAdress(String adress, String postCode, String local) throws FileNotFoundException {
        ad1 = cli.newPostalAddress(adress, postCode, local);
    }

    /**
     * Method that register a postal address to the client
     */
    public void registerAddress() {
        cli.addAddress(ad1);
    }

    /**
     * Returns a postal code by the position in the list.
     *
     * @param i position
     * @return String of the Postal Code
     */
    public String getPostalCodeByPos(int i) {
        return pcr.getPostalCodeByPos(i).getPostalCode();
    }

    /**
     * Method that returns client
     *
     * @return client
     */
    public Client getCli() {
        return cli;
    }

}
