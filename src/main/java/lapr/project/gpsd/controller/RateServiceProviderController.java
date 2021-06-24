/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.ClientRecords;
import lapr.project.records.RateList;
import lapr.project.records.ServiceOrderRecords;

/**
 *
 * @author Utilizador
 */
public class RateServiceProviderController {
    
    /**
     * Companys
     */
    private Company company;
    /**
     * Client
     */
    private Client cli;
    /**
     * Service provider
     */
    private ServiceProvider sp;
    /**
     * Service Order
     */
    private ServiceOrder so;
    /**
     * Rate list
     */
    private RateList rateList;
    /**
     * Rate
     */
    private Rate r;
    
    /**
     * Gets the user in session
     */
    public void newRateService() {
        AppGPSD app= AppGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email= session.getEmailUser();
        company=app.getCompany();
        ClientRecords cr= company.getClientRecords();
        cli= cr.getClientByEmail(email);
    }
    
    /**
     * Gets the services executed to the client
     * 
     * @return list of services
     */
    public List<ServiceOrder> getServiceOrdersExecutedByClient() {
        ServiceOrderRecords sor= company.getServiceOrderRecords();
        return sor.getServiceOrdersByClient(cli);
    }
    
    /**
     * Gets the service provider who executed the service order
     * 
     * @param so service order
     * @return service provider
     */
    public ServiceProvider getServiceProviderByServiceOrder(ServiceOrder so) {
        this.so=so;
        sp= so.getProvider();
        return sp;
    }
    
    /**
     * Rates the service provider
     * 
     * @param rate rate
     */
    public void rateServiceProvider(int rate) {
        rateList= sp.getRateList();
        this.r = rateList.addNewRate(rate);
        so.setRateState("Rated");
    }
    
    /**
     * Sabes the rate given to the service provider
     */
    public void registerRate() {
        rateList.registerRate(r);
    }
    
    /**
     * Verifies if a string is integer
     * 
     * @param str string 
     * @return boolean that indicates if the string is an integer or not
     */
    public boolean isInteger(String str ) {
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException nfe) {
            return false;
        }
    }
}
