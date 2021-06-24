/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.AvailabilityList;
import lapr.project.records.ServiceProviderRecords;

/**
 * FXML Controller class
 *
 * @author Bruno Veiga
 */
public class NewAvailabilityController {

    /**
     * Company
     */
    private Company company;
    /**
     * Service Provider
     */
    private ServiceProvider sp;
    /**
     * Availability list
     */
    private AvailabilityList al;
    /**
     * Availability
     */
    private Availability aval;

    /**
     * Gets the service provider who is indicating a new availability
     */
    public void indicateNewAvailability() {
        AppGPSD app = AppGPSD.getInstance();
        company = app.getCompany();
        UserSession session = app.getCurrentSession();
        String email = session.getEmailUser();
        ServiceProviderRecords spr = company.getServiceProviderRecords();
        sp = spr.getServiceProvider(email);
    }

    /**
     * Indicates a new availability
     *
     * @param dateI initial date of the availability
     * @param dateF final date of the availability
     * @param hourI initial time of the availability
     * @param period period of realization of the availabilty
     * @param hourF final time of the availability
     * @return
     */
    public Availability newAvailibilityTime(LocalDate dateI, LocalDate dateF, String hourI, String hourF, String period) {
        al = sp.getAvailabilityList();
        aval = al.newAvailabilityTime(dateI, hourI, dateF, hourF, period);
        return aval;
    }

    /**
     * Confirms the new availbilities
     *
     * @param aval availability to be registered
     */
    public void registerAvailabilityTime(Availability aval) {
        al.registerAvailabiityTime(aval);
    }
    
    /**
     * Changes the service provider´
     * 
     * @param sp : service provider
     */
    public void setServiceProvider(ServiceProvider sp) {
        this.sp=sp;
    }

}
