/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.GeographicalAreaRecords;

/**
 *
 * @author marta
 */
public class SpecifyGeographicalAreaController {
    
    private Company company;
    private GeographicalAreaRecords gar;
    private GeographicalArea ga;
    
    public SpecifyGeographicalAreaController(){
        if(!AppGPSD.getInstance().getCurrentSession().isLoggedInWithPaper(Constants.PAPER_ADMINISTRATOR))
            throw new IllegalStateException("User not allowed");
        this.company = AppGPSD.getInstance().getCompany();
    }

    public GeographicalArea newGeographicalArea(String desig, double cost, String postalCode, float radius) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException{
        this.gar = this.company.getGeographicalAreaRecords();
        this.ga = this.gar.newGeographicalArea(desig, cost, postalCode, radius);
        return ga;
    }
    
    public boolean registersGeographicalArea(){
       return this.gar.registersGeographicalArea(ga);
    }
}
