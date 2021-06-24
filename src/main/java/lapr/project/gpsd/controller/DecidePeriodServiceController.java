package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ProviderAssociation;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.TimePreference;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.RateList;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceScheduleRecords;
import lapr.project.timer.AssociationProviderServiceAlgorithm;

/**
 *
 * @author André
 */
public class DecidePeriodServiceController {

    private Company company;
    private MainClientController mcc;
    private AssociationProviderRequestRecords rapr;
    private AssociationSPtoRequest apr;
    private ServiceProviderRecords spr;
    private RateList rl;
    private ServiceSchedule ss;
    private ServiceOrderRecords rso;
    private AssociationProviderServiceAlgorithm assAlg;
    private List<AssociationSPtoRequest> AssoListRefCli = new ArrayList<>();
    private Client cli;
    private ServiceScheduleRecords ssr;

    /**
     * Gets the client who is deciding the new period
     *
     * @throws java.io.FileNotFoundException
     */
    public DecidePeriodServiceController() throws FileNotFoundException {

        if (!AppGPSD.getInstance().getCurrentSession().isLoggedInWithPaper(Constants.PAPER_CLIENT)) {
            throw new IllegalStateException("User not allowed");
        }
        AppGPSD app = AppGPSD.getInstance();
        company=app.getCompany();
        System.out.print(company);
        UserSession session = app.getCurrentSession();
        String email = session.getEmailUser();
        ClientRecords rc = company.getClientRecords();
        cli = rc.getClientByEmail(email);
    }

    /**
     *  Gets the List of clients who are already 
     * associated with a provider.
     * 
     */
    public void getListAssociatedClient() {
        rapr = this.company.getAssociationRecords();
        List<AssociationSPtoRequest> AssoList = rapr.getAssociationsList();
        for (int i = 0; i < AssoList.size(); i++) {
            AssociationSPtoRequest aprTest = AssoList.get(i);
            ProviderAssociation pa = aprTest.getProviderAssociation();
            ServiceProvidingRequest request = pa.getRequest();
            Client cli1 = request.getClient();
            if (cli1.equals(cli)) {
                AssoListRefCli.add(aprTest);
            }
        }
    }

    /**
     *  Client selects a number from the list of associated clients 
     * and the service schedule suggested is saved.
     * 
     * @param numSer
     * @return ServiceSchedule
     */
    public ServiceSchedule getServiceSchedule(int numSer) {
        apr = AssoListRefCli.get(numSer);
        ProviderAssociation pa = apr.getProviderAssociation();
        ServiceProvidingRequest request = pa.getRequest();
        ssr= company.getServiceScheduleRecords();
        assAlg = new AssociationProviderServiceAlgorithm();
        assAlg.associate(request);
        ss = ssr.getSSfromServiceScheduleList(0);
        ssr.removeSSfromList(0);
        return ss;
    }

    /**
     *  Client accepts the suggested service schedule, the state of the schedule
     * turns "Accepted" and will be generated varios ServiceOrders, depending
     * on how many descriptions the request had.
     * 
     * @param ss 
     */
    public void registerServiceOrdersIfAccept(ServiceSchedule ss) {
        int j=0;
        ss.setStateSchedule("Accepted");
        ProviderAssociation pa = apr.getProviderAssociation();
        ServiceProvidingRequest ped = pa.getRequest();
        List<ServiceProvidingRequestDescription> lstDesc = ped.getDescriptionList();
        PostalAddress end = ped.getPostalAddress();
        rso = company.getServiceOrderRecords();
        for (int i = 0; i < lstDesc.size(); i++) {
            ServiceProvider prov = pa.getProvider();
            ServiceProvidingRequestDescription descServTest = lstDesc.get(i);
            ServiceOrder so = rso.generateOrderServiceExecution(j, prov, descServTest, ss, end, cli);
            int num = registerOrderService(so);
        }
        
    }
    /**
     *  Gets the provider mean rating, to show to the client when deciding
     * about de period of the service.
     * 
     * @param prov
     * @return 
     */
    public double getRatingProvider(ServiceProvider prov) {
        return prov.getEvaluation().getMeanRating();
    }

    /**
     * Regists the service orders.
     * 
     * @param so
     * @return 
     */
    public int registerOrderService(ServiceOrder so) {
        int num = rso.registerServiceOrder(so);
        return num;

    }

    /**
     * 
     * Client rejects the suggested service schedule.
     * 
     */
    public void IfRejectsSchedule() {
        ss.setStateSchedule("Rejected");
        
    }
    
    /**
     *  Gets the abreviated name of a provider from the associated list, 
     * the provider is selected by the variable i.
     * 
     * @param i
     * @return Provider name (String)
     */
    public String getProviderNameFromAssociatedList (int i) {
        return this.AssoListRefCli.get(i).getProviderAssociation().getProvider().getAbrevName();
    }
    /**
     *  Gets the provider from the associated list, 
     * the provider is selected by the variable i.
     * 
     * @param i
     * @return 
     */
    public ServiceProvider getProviderFromAssociatedList (int i) {
        return this.AssoListRefCli.get(i).getProviderAssociation().getProvider();
    }
    
    /**
     * Gets the descriptions from a associated  list.
     * @param i
     * @return List of description of a service
     */
    public List<ServiceProvidingRequestDescription> getDescList (int i) {
        return this.AssoListRefCli.get(i).getRequestDescription();
    }
    
    /**
     * Gets the associated list size.
     * 
     * @return int 
     */
    public int getAssoListRefCliSize () {
        return this.AssoListRefCli.size();   
    }
    
    /**
     * Gets the service schedule.
     * 
     * @return ServiceSchedule
     */
    public ServiceSchedule getServiceSchedule () {
        return this.ss;
    }
    
    /**
     * Removes an association from the association list.
     * @param num 
     */
    public void removeAssoFromAssoList (int num) {
        rapr = this.company.getAssociationRecords();
        rapr.removeAssoFromList(num);
    }
    
    public List<AssociationSPtoRequest> getAssoListRefCli() {
        return new ArrayList<>(this.AssoListRefCli);
    }
    

}
