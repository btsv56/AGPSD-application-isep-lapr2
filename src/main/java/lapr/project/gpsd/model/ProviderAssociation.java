/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author lulu
 */
public class ProviderAssociation {
    
    private ServiceProvider ps;
    private ServiceProvidingRequest request;
    
    /**
     * Constructor for the ProviderAssociation class
     * 
     * @param ps
     * @param request 
     */
    public ProviderAssociation(ServiceProvider ps, ServiceProvidingRequest request) {
        this.ps=ps;
        this.request=request;
    }
    
    /**
     * @return String Service Provider's ID (full name, mechanumber) 
     */
    public String getPSId() {
        return this.ps.getFullName()+", "+this.ps.getMechaNumber();
    }
    
    /**
     * @return ServiceProvider ps
     */
    public ServiceProvider getProvider() {
        return this.ps;
    }
    
    /**
     * @return ServiceProvidingRequest request 
     */
    public ServiceProvidingRequest getRequest() {
        return this.request;
    }
    
    /**
     * Compares an instance of ProviderAssociations to an Object and checks if they're equal
     * @param o Object
     * @return true if it's exactly equal, false otherwise
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
        ProviderAssociation obj = (ProviderAssociation) o;
        return (Objects.equals(this.ps, obj.ps) && 
                Objects.equals(this.request, obj.request));
    }
}
