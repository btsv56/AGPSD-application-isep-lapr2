/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lulu
 */
public class AssociationSPtoRequest {
    
    private ProviderAssociation psAss;
    private List<ServiceProvidingRequestDescription> requestDesc;

    /**
     * Constructor of the class AssociationSPtoRequest
     *
     * @param ps ServiceProvider
     * @param request ServiceProvidingRequest
     */
    public AssociationSPtoRequest(ServiceProvider ps, ServiceProvidingRequest request) {
        this.psAss=new ProviderAssociation(ps, request);
        this.requestDesc=request.getDescriptionList();
    }

    /**
     * @return List requestDesc
     */
    public List<ServiceProvidingRequestDescription> getRequestDescription() {
        return new ArrayList<>(this.requestDesc);
    }

    /**
     * @return ProviderAssociation psAss
     */
    public ProviderAssociation getProviderAssociation() {
        return this.psAss;
    }
    
    /**
     * @return String SP ID
     */
    @Override
    public String toString() {
        return psAss.getPSId();
    }

}
