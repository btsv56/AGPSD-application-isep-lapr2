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
public class Rate {
    
    /**
     * Rate of the service provider
     */
    private int rate;
    
    /**
     * Creates a rate for the service provider
     * 
     * @param rate service provider rate
     */
    public Rate(int rate) {
        this.rate=rate;
    }
    
    /**
     * Returns the rate
     * 
     * @return rate
     */
    public int getRate() {
        return rate;
    }
    
     /**
     * Comparates two objects of Rate and
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
        Rate obj = (Rate) o;
        return (Objects.equals(this.rate,obj.rate));
                
    }
}
