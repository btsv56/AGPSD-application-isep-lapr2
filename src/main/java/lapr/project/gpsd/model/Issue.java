/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author marta
 */
public class Issue {
    
    /**
     * Service order.
     */
    private ServiceOrder or;
    /**
     * Description
     */
    private String desc;
    /**
     * Troubleshooting strategy.
     */
    private String troublest;
    
    /**
     * Constructor.
     * @param or service order
     * @param desc description
     * @param troublest troubleshooting strategy
     */
    public Issue(ServiceOrder or, String desc, String troublest){
        if(or == null || desc.isEmpty() || troublest.isEmpty()){
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.or = or;
        this.desc = desc;
        this.troublest = troublest;
    }

    /**
     * Returns service order.
     * 
     * @return the or
     */
    public ServiceOrder getOr() {
        return or;
    }

    /**
     * Returns the description.
     * 
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Returns the troubleshooting strategy.
     * 
     * @return the troublest
     */
    public String getTroublest() {
        return troublest;
    }

    /**
     * Changes the service order to the one received by parameter.
     * 
     * @param or the or to set
     */
    public void setOr(ServiceOrder or) {
        this.or = or;
    }

    /**
     * Changes the description to the one received by parameter.
     * 
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Changes troubleshooting strategy to the one received by parameter.
     * 
     * @param troublest the troublest to set
     */
    public void setTroublest(String troublest) {
        this.troublest = troublest;
    }
    
    /**
     * Checks if 2 objects are equal.
     * 
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Issue obj = (Issue) o;
        return (Objects.equals(this.desc, obj.desc) && 
                Objects.equals(this.troublest, obj.troublest) && Objects.equals(this.or, obj.or));
    }
    
    public String toString(){
        return String.format("%s%n Issue description: %s%n "
                + "Troubleshooting strategy: %s%n", or.toString(), this.desc, this.troublest);
    }
}
