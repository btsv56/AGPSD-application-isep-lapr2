/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;

/**
 *
 * @author Utilizador
 */
public class ServiceRecords {
    
    /**
     * List of services
     */
    private List<Service> servicesList = new ArrayList<>();
    

    /**
     * After validating the service, adds the service to the list of services.
     * @param service
     * @return true if the service was added and false if the service wasn't added to the list.
     */
    public boolean registersService(Service service){
        if (validatesService(service)){
            return addService(service);
        }
        return false;
    }

    /**
     * Adds service to the list of services.
     * @param service
     * @return true if it adds the service, false if it doesn't add
     */
    public boolean addService(Service service)
    {
        return this.servicesList.add(service);
    }
    
    /**
     * Returns true if the service is validated and verified by other methods.
     * @param service
     * @return 
     */
    public boolean validatesService(Service service){
        if(service.validates() == true){
             return verifyService(service);
        }
        return false;
    }
    
    /**
     * Verifies if a service with an unique id already exists in the servicesList.
     * @param service
     * @return false if it already exists and true if it doesn't exist
     */
    public boolean verifyService(Service service){
        for(Service x : servicesList){
            if(service.getUniqueID().equals(x.getUniqueID())){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a list of services with a certain category.
     * @param cat
     * @return 
     */
     public List<Service> getServiceByCat(Category cat) {
        List<Service> servCat = new ArrayList<>();
        for (Service serv : this.servicesList) {
            if (serv.getCategory().equals(cat)) {
                servCat.add(serv);
            }
        }
        return servCat;
    }
     
         public Service getServiceByID(String id) {
        for (Service serv : this.servicesList) {
            if (serv.getUniqueID().equals(id)) {
                return serv;
            }
        }

        return null;
    }
    
   
}
