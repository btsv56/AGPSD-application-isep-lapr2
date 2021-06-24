/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

/**
 *
 * @author marta
 */
public interface Service {
 
 //Returns true or false depending on whether a service has other attributes or not.
 boolean hasOtherAttributes();
 //Returns the name of the other attributes of a service.
 String getOtherAttributes();
 //Sets the value of the other attributes.
 void setAdditionalData(int data);
 //Returns the category of a service.
 Category getCategory();
 //Validates if a service has the correct data.
 boolean validates();
 //Returns the cost of a service for a determined duration.
 double getCostForDuration(int dur);
 //Returns id.
 String getUniqueID();

}