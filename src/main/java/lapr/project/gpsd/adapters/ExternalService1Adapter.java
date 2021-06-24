/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.adapters;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.ActsIn;
import lapr.project.gpsd.model.ExternalService;
import lapr.project.gpsd.model.ExternalService1API;
import lapr.project.gpsd.model.PostalCode;

/**
 *
 * @author marta
 */
public class ExternalService1Adapter implements ExternalService{

    private ExternalService1API api;
    
    public ExternalService1Adapter(){
        this.api = new ExternalService1API();
    }
    
    @Override
    public List<ActsIn> obtainActing(PostalCode pc, float radius) {
        try {
            return api.obtainActing(pc, radius);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExternalService1Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }
    
}
