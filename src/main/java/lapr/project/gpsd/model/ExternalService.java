/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;

/**
 *
 * @author marta
 */
public interface ExternalService {
    
    /**
     * Method that returns a list of ActsIn, receiving a postal code and radius by parameter.
     * @param pc postal code
     * @param radius float
     * @return List of ActsIn
     */
    List<ActsIn> obtainActing(PostalCode pc, float radius);
}
