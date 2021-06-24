/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;

/**
 *
 * @author lulu
 */
public class AssociationProviderRequestRecords {
    
    private List<AssociationSPtoRequest> assList=new ArrayList<>();
    private List<ServiceProvidingRequest> unassList=new ArrayList<>();
    
    /**
     * Empty constructor
     */
    public AssociationProviderRequestRecords() {
        
    }
    
    /**
     * Adds an instance of AssociationSPtoRequest to the assList array
     * @param sp
     * @param request
     * @return boolean result of assList.add(Association)
     */
    public boolean addAssociation(ServiceProvider sp, ServiceProvidingRequest request) {
        return assList.add(new AssociationSPtoRequest(sp, request));
    }
    
    /**
     * @return List of associations (assList) 
     */
    public List<AssociationSPtoRequest> getAssociationsList() {
        return new ArrayList<>(assList);
    }
    
    /**
     * @return A list of requests that haven't been associated 
     */
    public List<ServiceProvidingRequest> getUnassociatedRequests() {
        ServiceProvidingRequestRecords sprr=AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        List<ServiceProvidingRequest> requestList=sprr.getRequestsList();
        List<ServiceProvidingRequest> unassList=new ArrayList<>();
        for (ServiceProvidingRequest req : requestList) {
            boolean isAss = false;
            for (AssociationSPtoRequest ass : assList) {
                ServiceProvidingRequest assReq=ass.getProviderAssociation().getRequest();
                if (assReq.equals(req)) {
                    isAss=true;
                    break;
                }
            }
            if (!isAss) {
                unassList.add(req);
            }
        }
        return unassList;
    }
    
    public void removeAssoFromList (int num) {
        assList.remove(num);
    }
}
