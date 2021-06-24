/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class OtherCost {
    
    
     /**
     * designation of the other cost
     */
    private String designation;
    /**
     * deslocation cost
     */
    private double deslocationCost;

    /**
     * Constructor
     *
     * @param designation : designation of the ohter cost
     * @param deslocationCost : deslocation cost
     */
    public OtherCost(String designation, double deslocationCost) {
        if ((designation == null) || (designation.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }
        this.deslocationCost = deslocationCost;
        this.designation = designation;
    }
    
    /**
     * Returns de deslocation cost
     * 
     * @return deslocation cost
     */
    public double getDesclocationCost() {
        return deslocationCost;
    }
    

     /**
     * Comparates two objects of OtherCost description and
     * verify if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
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
        OtherCost obj = (OtherCost) o;
        return (Objects.equals(this.deslocationCost, obj.deslocationCost) && Objects.equals(this.designation, obj.designation));
    }

      
    /**
     * Método toString: Return a description of otherCost
     * 
     * @return description of otherCost
     */
    @Override
    public String toString() {
        String str = String.format("%s - %s" ,this.designation, Double.toString(this.deslocationCost) );
        return str;
    }
}
