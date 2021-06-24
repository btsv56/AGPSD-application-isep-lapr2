/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.gpsd.model.PostalCode;

/**
 *
 * @author User
 */
public class PostalCodeRecords {

    /**
     * List of postal codes
     */
    private List<PostalCode> lst;

    /**
     * Constructor
     */
    public PostalCodeRecords() {
        this.lst = new ArrayList<>();
    }

    /**
     * Receives a list of postal codes and makes the list of postal codes equal
     * to the one in this class.
     *
     * @param lpc list of postal codes
     */
    public PostalCodeRecords(List<PostalCode> lpc) {
        this.lst = new ArrayList<>(lpc);
    }
    
    public void addPostalCode(PostalCode code) {
        this.lst.add(code);
    }

    /**
     * Returns the position of the postal code that has the postal code received by parameter.
     * @param postalCode
     * @return 
     */
    public int searchPositionPostalCode(String postalCode) {
        for (int i = 0; i < getLst().size(); i++) {
            if (getLst().get(i).getPostalCode().equals(postalCode)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the latitude of a postal code received by parameter.
     * @param postalCode
     * @return 
     */
    public double getLatitudeByID(String postalCode) {
        int position = searchPositionPostalCode(postalCode);
        if (position != -1) {
            PostalCode pc = getLst().get(position);
            return pc.getLatitude();
        }
        return 91;
    }

    /**
     * Returns longitude of a postal code received by parameter.
     * @param postalCode
     * @return 
     */
    public double getLongitudeByID(String postalCode) {
        double position = searchPositionPostalCode(postalCode);
        if (position != -1) {
            PostalCode pc = getLst().get((int) position);
            return pc.getLongitude();
        }
        return 181;
    }

    /**
     * Returns the size of the list of postal codes.
     * @return 
     */
    public int getListSize() {
        return getLst().size();
    }

    /**
     * Returns a postal code by the position in the list.
     * @param i
     * @return 
     */
    public PostalCode getPostalCodeByPos(int i) {
        return getLst().get(i);
    }

    /**
     * Returns the list of postal codes.
     * 
     * @return the lst
     */
    public List<PostalCode> getLst() {
        return new ArrayList<>(lst);
    }
    
    /**
     * Finds the postal code that has that id on the list.
     * 
     * @param pc postal code in string
     * @return 
     */
    public PostalCode getPostalCodeByID(String pc){
        PostalCode postc = new PostalCode(pc);
        for(PostalCode x : this.lst){
            if(x.equals(postc)){
                return x;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Compares an object with and object of PostalCodeRecords and sees if 
     * they are equal.
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PostalCodeRecords other = (PostalCodeRecords) obj;
        if (!Objects.equals(this.lst, other.lst)) {
            return false;
        }
        return true;
    }

}
