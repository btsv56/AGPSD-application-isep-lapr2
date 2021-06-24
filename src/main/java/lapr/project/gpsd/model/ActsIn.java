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
public class ActsIn {
    
    /**
     * Distance
     */
    private double distance;
    /**
     * Postal Code
     */
    private PostalCode pc;
    
    /**
     * Constructor
     * 
     * @param pc postal code
     * @param distance double
     */
    public ActsIn(PostalCode pc, double distance){
        this.pc = pc;
        this.distance = distance;
    }
    
    /**
     * Returns the postal code
     * @return PostalCode pc 
     */
    public PostalCode getPostalCode() {
        return this.pc;
    }
    
    /**
     * Return textual format of ActsIn.
     * @return String "Postal Code: (postal code) 
     *         Distance: (distance)"
     */
    @Override
    public String toString(){
        return String.format("Postal Code: %s%n Distance: %.2f%n", this.pc.toString(), 
                this.distance);
    }
}
