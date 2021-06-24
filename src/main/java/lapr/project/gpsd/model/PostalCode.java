/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;


import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.PostalCodeRecords;
import java.util.Objects;
/**
 *
 * @author Utilizador
 */
public class PostalCode {
    
    /**
     * Postal Code
     */
    private String postalCode;
    /**
     * Latitude
     */
    private double latitude;
    /**
     * Longitude
     */
    private double longitude;
    /**
     * Postal code records
     */
    private PostalCodeRecords pcr;
    
    /**
     * Constructor
     * @param postalCode
     * @param latitude
     * @param longitude 
     */
    public PostalCode(String postalCode, double latitude, double longitude) {
        if(postalCode.isEmpty()){
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }
        this.postalCode=postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Constructor receiving only postal code.
     * @param postalCod 
     */
    public PostalCode(String postalCod){
        pcr = AppGPSD.getInstance().getCompany().getPostalCodeRecords();
        double lat = pcr.getLatitudeByID(postalCod);
        double lon = pcr.getLongitudeByID(postalCod);
        this.postalCode=postalCod;
        this.latitude = lat;
        this.longitude = lon;
    }
    
    /**
     * Returns postal code.
     * @return 
     */
    public String getPostalCode() {
        return this.postalCode;
    }
    
    /**
     * Returns latitude.
     * @return 
     */
    public double getLatitude() {
        return this.latitude;
    }
    
    /**
     * Returns longitude
     * @return 
     */
    public double getLongitude() {
        return this.longitude;
    }
    
    /**
     * Checks if 2 objects are the same.
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        PostalCode obj = (PostalCode) o;
        return (Objects.equals(this.postalCode, obj.postalCode) && 
                Objects.equals(this.latitude, obj.latitude) &&
                Objects.equals(this.longitude, obj.longitude));
    }
    
    /**
     * Returns the textual format of Postal Code.
     * @return 
     */
    @Override
    public String toString() {
        return postalCode+", "+latitude+", "+longitude;
    }
    
}
