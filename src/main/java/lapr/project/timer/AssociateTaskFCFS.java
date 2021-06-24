/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.ClientRecords;

/**
 *
 * @author lulu
 */
public class AssociateTaskFCFS implements AssociationTask {
    
    private AppGPSD app;
    private Company company;
    private ServiceProviderRecords spRcds;
    private ServiceProvidingRequestRecords requestRcds;
    private AssociationProviderRequestRecords assRcds;
    private AssociationProviderServiceAlgorithm assAlg;
    private ServiceProvidingRequest request;
    private int counter=0;
    private int unAss=0;

    /**
     * Constructor, informs the user if the chosen request was associated or not, and displays the number of requests
     * that haven't been associated
     * @throws FileNotFoundException e
     */
    public AssociateTaskFCFS() throws FileNotFoundException {
        this.app = AppGPSD.getInstance();
        this.company=app.getCompany();
        this.spRcds=company.getServiceProviderRecords();
        this.requestRcds=company.getServiceProvidingRequestRecords();
        this.assRcds=company.getAssociationRecords();
        if (associateSPtoRequest()) {
            System.out.println("Request has been successfully associated. ("+unAss+" requests left unassociated.)");
        } else {
            System.out.println("Request has not been associated. ("+unAss+" requests left unassociated.)");
        }
    }
    
    /**
     * Special constructor for testing purposes
     * @param test any int
     */
    public AssociateTaskFCFS(int test) {
        
    }

    /**
     * Associates a request to available providers (FIRST-COME-FIRST-SERVED method)
     *
     * @return boolean flag
     */
    @Override
    public boolean associateSPtoRequest() {
        assAlg=new AssociationProviderServiceAlgorithm();
        boolean flag=false;
        counter=0;
        do {
            request=assRcds.getUnassociatedRequests().get(counter);
            flag=assAlg.associate(request);
        } while (!flag && ++counter!=assRcds.getUnassociatedRequests().size());
        unAss=requestRcds.getRequestsList().size()-assRcds.getAssociationsList().size();
        return flag;
    }

    /**
     * Same as above, but for testing purposes
     *
     * @param requests List of requests
     * @return flag
     */
    public boolean associateSPtoRequestTest(List<ServiceProvidingRequest> requests) {
        assAlg=new AssociationProviderServiceAlgorithm();
        boolean flag=false;
        do {
            request=requests.get(counter);
            flag=assAlg.associate(request);
        } while (!flag && ++counter!=assRcds.getUnassociatedRequests().size());
        return flag;
    }
}
