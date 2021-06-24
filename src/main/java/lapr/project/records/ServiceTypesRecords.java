/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceType;

/**
 *
 * @author marta
 */
public class ServiceTypesRecords {

    //List of types of services.
    private List<ServiceType> lst = new ArrayList<>();

    /**
     * Returns the list of types of services.
     * @return 
     */
    public List<ServiceType> getServiceTypes() {
        return new ArrayList<>(this.lst);
    }
    /**
     * Creates the types of services that exist.
     * @param props
     * @return true if it adds all the existing types of services or false 
     * if it doesn't add all the types
     */
    public boolean createsServiceTypesSupported(Properties props) {
       boolean result = false;     
        // Knows how many ServiceTypes are supported
        String qtdTypes = props.getProperty(Constants.QUANTITY_TYPE_SERVICES);
        int qtd = Integer.parseInt(qtdTypes);
        // For each service type creates the respective instance
        for (int i = 1; i <= qtd; i++) {
            // Knows information (description and class) of the instance to be created
            String idType = props.getProperty("Company.ServiceType."+ i +".IdType");
            String designation = props.getProperty("Company.ServiceType."+ i +".Designation");
            // Creates the instance
            ServiceType servType = new ServiceType(designation, idType);
            // Adds the service type to the list
            this.lst.add(servType);
        }
        if(lst.size() == qtd){
           result = true; 
        }
        return result;
    }
    
    /**
     * Returns a service type that has the id received by parameter.
     * @param idType
     * @return 
     */
    public ServiceType getServiceTypeByID(String idType){
        for(ServiceType sv : lst){
            if(sv.getIdType().equals(idType)){
                return sv;
            }
        }
        return null;
    }
}
