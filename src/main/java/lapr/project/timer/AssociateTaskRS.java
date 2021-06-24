package lapr.project.timer;

import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssociateTaskRS implements AssociationTask {

    private AppGPSD app;
    private Company company;
    private ServiceProviderRecords spRcds;
    private ServiceProvidingRequestRecords requestRcds;
    private AssociationProviderRequestRecords assRcds;
    private AssociationProviderServiceAlgorithm assAlg;
    private ServiceProvidingRequest request;
    private List<ServiceProvidingRequest> requestList;
    private int unAss=0;
    Random rand = new Random();

    /**
     * Constructor, informs the user if the chosen request was associated or not, and displays the number of requests
     * that haven't been associated
     * @throws FileNotFoundException e
     */
    public AssociateTaskRS() throws FileNotFoundException {
        this.app = AppGPSD.getInstance();
        this.company=app.getCompany();
        this.spRcds=company.getServiceProviderRecords();
        this.requestRcds=company.getServiceProvidingRequestRecords();
        this.assRcds=company.getAssociationRecords();
        requestList=assRcds.getUnassociatedRequests();
        if (associateSPtoRequest()) {
            System.out.println("Request has been successfully associated. ("+unAss+" requests left unassociated.)");
        } else {
            System.out.println("Request has not been associated. ("+unAss+" requests left unassociated.)");
        }
    }

    /**
     * Special contructor for testing purposes
     * @param test any number
     */
    public AssociateTaskRS(int test) {

    }

    /**
     * Associates a request to available providers (RANDOM-SCHEDULING method)
     *
     * @return boolean flag
     */
    @Override
    public boolean associateSPtoRequest() {
        assAlg=new AssociationProviderServiceAlgorithm();
        boolean flag=false;
        int counter=rand.nextInt(requestList.size());
        request=assRcds.getUnassociatedRequests().get(counter);
        flag=assAlg.associate(request);
        unAss=requestRcds.getRequestsList().size()-assRcds.getAssociationsList().size();
        return flag;
    }

    /**
     * Same as above, but for testing purposes
     *
     * @param requests list of requests
     * @return flag
     */
    public boolean associateSPtoRequestTest(List<ServiceProvidingRequest> requests) {
        assAlg=new AssociationProviderServiceAlgorithm();
        boolean flag=false;
        do {
            int counter=rand.nextInt(requestList.size());
            request=requests.get(counter);
            flag=assAlg.associate(request);
        } while (!flag);
        return flag;
    }
}
