/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.scene.control.Alert;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.gpsd.model.Time;
import lapr.project.gpsd.model.TimePreference;

/**
 *
 * @author Utilizador
 */
public class ServiceProvidingRequestRecords {

    private List<ServiceProvidingRequest> serviceProvidingRequestList = new ArrayList<>();
    private AssociationProviderRequestRecords assRcds= new AssociationProviderRequestRecords();

    /**
     * Creates and returns a new service providing request
     *
     * @param cli: client that made the request
     * @param address: postal address where the services will be executed
     * @return new ServiceProvidingRequest
     */
    public ServiceProvidingRequest newRequest(Client cli, PostalAddress address) {
        return new ServiceProvidingRequest(cli, address);
    }

    /**
     * Validates the request received and generates the request cost
     *
     * @param request: request received
     * @return boolean that indicates if the request is valid or not
     */
    public boolean validateRequest(ServiceProvidingRequest request) {
        double c = request.calculateCost();
        return verifyRequest(request);
    }

    /**
     * Validates the request received
     *
     * @param request: request received
     * @return boolean that indicates if the request is valid or not
     */
    private boolean verifyRequest(ServiceProvidingRequest request) {
        boolean vef = true;
        if (request == null) {
            vef = false;
        }
        return vef;
    }

    /**
     * Registers the request received
     *
     * @param request: request received
     * @return boolean that indicates if the request is valid or not
     */
    public int registerRequest(ServiceProvidingRequest request) {
        if (!validateRequest(request)) {
            throw new IllegalArgumentException("The request is invalid");
        }
        int num = generateRequestNumber();
        request.setNumber(num);
        addRequest(request);
        return num;
    }

    /**
     * Registers the request received (for testing purposes)
     *
     * @param request: request received
     * @return boolean that indicates if the request is valid or not
     */
    public int registerRequestTest(ServiceProvidingRequest request) {
        if (!validateRequestTest(request)) {
            throw new IllegalArgumentException("The request is invalid");
        }
        int num = generateRequestNumber();
        request.setNumber(num);
        addRequest(request);
        return num;
    }

    /**
     * Validates the request received and generates the request cost
     *
     * @param request: request received
     * @return boolean that indicates if the request is valid or not
     */
    public boolean validateRequestTest(ServiceProvidingRequest request) {
        double c = request.calculateCostTest();
        return verifyRequest(request);
    }

    /**
     * Generates the number of the request
     *
     * @return request number
     */
    private int generateRequestNumber() {
        return serviceProvidingRequestList.size();
    }

    /**
     * Returns the request list associated to service providing request
     *
     * @return list of requests
     */
    public List<ServiceProvidingRequest> getRequestsList() {
        return new ArrayList<>(this.serviceProvidingRequestList);
    }
    
    public List<ServiceProvidingRequest> getUnassociatedRequests() {
        AssociationProviderRequestRecords assRcds = AppGPSD.getInstance().getCompany().getAssociationRecords();
        ArrayList<ServiceProvidingRequest> unassList=new ArrayList<>();
        List<AssociationSPtoRequest> assList=assRcds.getAssociationsList();
        for (AssociationSPtoRequest ass: assList) {
            ServiceProvidingRequest req=ass.getProviderAssociation().getRequest();
            boolean exists=false;
            for (ServiceProvidingRequest req2: this.serviceProvidingRequestList) {
                if (req.equals(req2)) {
                    exists=true;
                }
            }
            if (!exists) {
                unassList.add(req);
            }
        }
        return unassList;
    }

    /**
     * Adds a request to the service providing request list
     *
     * @param request : request to be added
     */
    private void addRequest(ServiceProvidingRequest request) {
        this.serviceProvidingRequestList.add(request);
    }

    /**
     * Comparates two objects of ServiceProvidingRequestRecords and verify if
     * they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
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
        ServiceProvidingRequestRecords obj = (ServiceProvidingRequestRecords) o;
        return (Objects.equals(this.serviceProvidingRequestList, obj.serviceProvidingRequestList));
    }
}
