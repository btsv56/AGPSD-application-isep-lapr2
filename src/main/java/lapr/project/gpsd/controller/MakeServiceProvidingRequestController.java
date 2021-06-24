/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import lapr.project.records.ServiceRecords;

/**
 * FXML Controller class
 *
 * @author Utilizador
 */
public class MakeServiceProvidingRequestController {

    /**
     * Company
     */
    private Company company;
    /**
     * Client
     */
    private Client cli;
    /**
     * Service providing request
     */
    private ServiceProvidingRequest spr;
    /**
     * Service providing request records
     */
    private ServiceProvidingRequestRecords sprr;
    /**
     * Cost
     */
    private double cost;
    /**
     * Main client controller
     */
    private MainClientController mcc;
    /**
     * AppGPSD
     */
    private AppGPSD app;

    /**
     * Returns a new make service providing request controller
     * 
     * @return make service providing request controller
     */
    public static MakeServiceProvidingRequestController getInstance()  {
        return new MakeServiceProvidingRequestController();
    }
    
    /**
     * Gets the company
     */
    public MakeServiceProvidingRequestController() {
        app = AppGPSD.getInstance();
        this.company = app.getCompany();
    }

    /**
     * Identifies the client who is making the request and gets his adresses
     *
     * @return list of addresses
     */
    public List<PostalAddress> newServiceProvidingRequest() {
        UserSession session = app.getCurrentSession();
        String email = session.getEmailUser();
        ClientRecords rc = company.getClientRecords();
        cli = rc.getClientByEmail(email);
        List<PostalAddress> led = cli.getPostalAddresses();
        return led;
    }

    /**
     * Selects the address where the service will be executed
     *
     * @param event
     */
    public void setPostalAddress(PostalAddress postalAddress) {
        sprr = company.getServiceProvidingRequestRecords();
        spr = sprr.newRequest(cli, postalAddress);
    }

    /**
     * Shows the available categories
     *
     * @param event
     */
    public List<Category> getCategories() {
        CategoryRecords cr = company.getCategoryRecords();
        List<Category> catList = cr.getCategories();
        return catList;
    }

    /**
     * Gets the services associated to the category selected
     *
     * @param event
     */
    public List<Service> getServicesByCategory(Category cat) {
        ServiceRecords sr = company.getServiceRecords();
        List<Service> serviceList = sr.getServiceByCat(cat);
        return serviceList;
    }

    /**
     * Adds a request after all the fields are filled
     *
     * @param event
     */
    public void addServiceProvidingRequest(Service serv, String desc, int dur) {
        spr.addServiceProvidingRequest(serv, desc, dur);
        
    }

    /**
     * Adds a time preference
     *
     * @param event
     */
    public void addTime(LocalDate date, String hour) {
        spr.addTime(date, hour);
    }

    /**
     * Registers the request
     *
     * @param event
     */
    public int registerRequest() {
        int num = sprr.registerRequest(spr);
        return num;
    }

    /**
     * Validates the request
     */
    public void validates() {
        sprr.validateRequest(spr);
    }

    /**
     * Gets the total cost of the request
     */
    public double getTotalCost() {
        cost = spr.calculateCost();
        return cost;
    }

    /**
     * Associtates this controller to the main client controller
     *
     * @param mcc main client controller
     */
    public void associateController(MainClientController mcc) {
        this.mcc = mcc;
    }

}
