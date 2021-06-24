/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author Andre
 */
public class Association {
    
    private ServiceProvider prov;
    private ServiceProvidingRequestDescription serviceDesc;
    private Service service;
    
    /**
     * Constructor for the class Association
     * @param prov ServiceProvider
     * @param servDesc ServiceProvidingRequestDescription
     * @param service Service
     */
    public Association(ServiceProvider prov, ServiceProvidingRequestDescription servDesc, Service service) {
        this.prov=prov;
        this.serviceDesc=servDesc;
        this.service=service;
    }

    /**
     * @return ServicePorvider prov 
     */
    public ServiceProvider getServiceProvider() {
        return prov;
    }

    /**
     * @return ServiceProvidingRequestDescription serviceDesc
     */
    public ServiceProvidingRequestDescription getServiceDescription() {
        return serviceDesc;
    }
    
     /**
     * Comparates two objects of Association and
     * verifies if they are equal
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
        Association obj = (Association) o;
        return (Objects.equals(this.prov, obj.prov) && Objects.equals(this.service, obj.service) && (Objects.equals(this.serviceDesc, obj.serviceDesc)));
    }
}
