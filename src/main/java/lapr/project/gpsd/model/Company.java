/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.Objects;
import lapr.project.records.ApplicationRecords;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.GeographicalAreaRecords;
import lapr.project.records.PostalCodeRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import lapr.project.records.ServiceRecords;
import lapr.project.records.ServiceTypesRecords;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.FormatTypeRecords;
import lapr.project.records.IssueRecords;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceScheduleRecords;
import lapr.project.timer.AssociateSPtoRequestTimer;

/**
 *
 * @author Paulo Maio (pam@isep.ipp.pt)
 */
public class Company {

    /**
     * Designation
     */
    private String m_strDesignation;
    /**
     * TIN
     */
    private String m_strTIN;

    /**
     * Client Records
     */
    private ClientRecords clientRecords;
    /**
     * Service Providing Request Records
     */
    private ServiceProvidingRequestRecords serviceProvidingRequestRecords;
    /**
     * Geographical Area Records
     */
    private GeographicalAreaRecords geographicalAreaRecords;
    /**
     * Category Records
     */
    private CategoryRecords categoryRecords;
    /**
     * Service Records
     */
    private ServiceRecords serviceRecords;
    /**
     * Service Type Records
     */
    private ServiceTypesRecords serviceTRecords;
    /**
     * Service Provider Records
     */
    private ServiceProviderRecords serviceProviderRecords;
    /**
     * Application Records
     */
    private ApplicationRecords applicationRecords;
    /**
     * Postal Code Records
     */
    private PostalCodeRecords postalCodeRecords;
    /**
     * Assocation Provider Request Records
     */
    private AssociationProviderRequestRecords associationRecords;
    /**
     * External Service
     */
    private ExternalService extService;
    /**
     * Service Order Records
     */
    private ServiceOrderRecords serviceOrderRecords;
    /**
     * Format Type Records
     */
    private FormatTypeRecords formatTypeRecords;
    /**
     * Issue Records
     */
    private IssueRecords issueRecords;
    /**
     * Service schedule Records
     */
    private ServiceScheduleRecords ssr;

    /**
     * Constructor
     * 
     * @param strDesignation: designation
     * @param strTIN: tin
     * @throws FileNotFoundException fnfe
     */
    public Company(String strDesignation, String strTIN) throws FileNotFoundException {
        if ((strDesignation == null) || (strTIN == null)
                || (strDesignation.isEmpty()) || (strTIN.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }

        this.m_strDesignation = strDesignation;
        this.m_strTIN = strTIN;
        this.categoryRecords = new CategoryRecords();
        this.clientRecords = new ClientRecords();
        this.geographicalAreaRecords = new GeographicalAreaRecords();
        this.serviceProvidingRequestRecords = new ServiceProvidingRequestRecords();
        this.serviceRecords = new ServiceRecords();
        this.serviceTRecords = new ServiceTypesRecords();
        this.serviceProviderRecords = new ServiceProviderRecords();
        this.applicationRecords = new ApplicationRecords();
        this.associationRecords = new AssociationProviderRequestRecords();
        this.postalCodeRecords = new PostalCodeRecords();
        this.serviceOrderRecords = new ServiceOrderRecords();
        this.formatTypeRecords = new FormatTypeRecords();
        this.issueRecords = new IssueRecords();
        this.ssr = new ServiceScheduleRecords();
    }

    /**
     * Returns the format type records
     * 
     * @return format type records
     */
    public FormatTypeRecords getFormatTypeRecords() {
        return this.formatTypeRecords;
    }

    /**
     * Returns the client records
     * 
     * @return client
     */
    public ClientRecords getClientRecords() {
        return this.clientRecords;
    }

    /**
     * Returns the service providing request records
     * 
     * @return service providing request records
     */
    public ServiceProvidingRequestRecords getServiceProvidingRequestRecords() {
        return this.serviceProvidingRequestRecords;
    }

    /**
     * Returns the geographical area records
     * 
     * @return geographical area records
     */
    public GeographicalAreaRecords getGeographicalAreaRecords() {
        return this.geographicalAreaRecords;
    }

    /**
     * Returns the category records
     * 
     * @return category records
     */
    public CategoryRecords getCategoryRecords() {
        return this.categoryRecords;
    }

    /**
     * Returns the service records
     * 
     * @return service records
     */
    public ServiceRecords getServiceRecords() {
        return this.serviceRecords;
    }

    /**
     * Returns the service type records
     * 
     * @return service type records
     */
    public ServiceTypesRecords getServiceTypesRecords() {
        return this.serviceTRecords;
    }

    /**
     * Returns the service provider records
     * 
     * @return 
     */
    public ServiceProviderRecords getServiceProviderRecords() {
        return this.serviceProviderRecords;
    }

    /**
     * Returns the application records
     * 
     * @return application records
     */
    public ApplicationRecords getApplicationRecords() {
        return this.applicationRecords;
    }

    /**
     * Returns the postal code records
     * 
     * @return postal code records
     */
    public PostalCodeRecords getPostalCodeRecords() {
        return this.postalCodeRecords;
    }

    /**
     * Returns the external service records
     * 
     * @return external service records
     * @throws ClassNotFoundException cnfe
     * @throws InstantiationException ie
     * @throws IllegalAccessException iae
     */
    public ExternalService getExternalService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> oClass = Class.forName("lapr.project.gpsd.adapters.ExternalService1Adapter");
        this.extService = (ExternalService) oClass.newInstance();
        return extService;
    }

    /**
     * Returns the company's designation
     * 
     * @return comapny's designation
     */
    public String getDesignation() {
        return this.m_strDesignation;
    }

    /**
     * Returns the association records
     * 
     * @return association recordss
     */
    public AssociationProviderRequestRecords getAssociationRecords() {
        return this.associationRecords;
    }

    /**
     * Returns the service order records
     * 
     * @return service order records
     */
    public ServiceOrderRecords getServiceOrderRecords() {
        return this.serviceOrderRecords;
    }

    /**
     * Returns the issue records
     * 
     * @return issue records
     */
    public IssueRecords getIssueRecords() {
        return this.issueRecords;
    }

    /**
     * Returns a new AssociateSPtoRequestTimer
     * 
     * @param minutes: minutes
     * @param method: method
     * @return new AssociateSPtoRequestTimer
     */
    public AssociateSPtoRequestTimer startTimerTask(int minutes, String method) {
        return new AssociateSPtoRequestTimer(minutes, method);
    }
    
    /**
     * Returns the service schedule records
     * 
     * @return service schedule records
     */
    public ServiceScheduleRecords getServiceScheduleRecords () {
        return this.ssr;
    }

    /**
     * Comparates two objects of Comapny description and verify if they are
     * equal
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
        Company obj = (Company) o;
        return (Objects.equals(this.m_strTIN, obj.m_strTIN) && Objects.equals(this.m_strDesignation, obj.m_strDesignation));
    }
}
