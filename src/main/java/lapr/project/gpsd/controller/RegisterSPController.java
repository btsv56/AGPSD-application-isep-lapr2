/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.ApplicationRecords;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.CategoryRecords;
import lapr.project.records.GeographicalAreaRecords;
import lapr.project.records.ServiceProviderRecords;

/**
 * FXML Controller class
 *
 * @author Pedro Brandao
 */
public class RegisterSPController {

    /**
     * Current instance of the application
     */
    private final AppGPSD appGPSD;
    /**
     * Current instance of the company
     */
    private final Company company;
    /**
     * Current instance of the ApplicationRecords
     */
    private final ApplicationRecords applicationRecords;
    /**
     * Current instance of Service Provider Records
     */
    private final ServiceProviderRecords servProvRecords;
    /**
     * Current instance of category records
     */
    private final CategoryRecords catRecords;
    /**
     * Current instance of Geographical Area Records
     */
    private final GeographicalAreaRecords geoAreaRecords;
    /**
     * Instance of Application to be treated
     */
    private Application application = null;
    /**
     * Instance to be created for the new registered Service Provider
     */
    private ServiceProvider serviceProv;

    /**
     * Constructor
     */
    public RegisterSPController() {
        appGPSD = AppGPSD.getInstance();
        this.company = appGPSD.getCompany();
        this.applicationRecords = company.getApplicationRecords();
        this.servProvRecords = company.getServiceProviderRecords();
        this.catRecords = company.getCategoryRecords();
        this.geoAreaRecords = company.getGeographicalAreaRecords();
    }

    /**
     * Gets the instance of Application which has the TIN Number of the Service
     * Provider to be Registered
     *
     * @param txtTinNumber TIN Number of the Service Provider
     * @return boolean regarding the success
     */
    public Application getProviderInfo(int txtTinNumber) {
        return this.application = applicationRecords.getApplicationByTIN(txtTinNumber);
    }

    /**
     * returns the password of the service provider
     *
     * @return passowrd
     */
    public String getPWD() {
        return serviceProv.getPWD();
    }

    /**
     * Returns the List of GeographicalAreas
     *
     * @return list of geoAreas
     */
    public List<GeographicalArea> getGeoAreas() {
        return geoAreaRecords.getGeoAreasList();
    }

    /**
     * Returns the list of Categories
     *
     * @return list of Categories
     */
    public List<Category> getCategories() {
        return catRecords.getCategoryList();
    }

    /**
     * Returns the Full name of the service provider stored in the application
     *
     * @return full name in application
     */
    public String getFullName() {
        return this.application.getName();
    }

    /**
     * Returns the postal address associated with the application
     *
     * @return
     */
    public PostalAddress getPostalAddress() {
        return this.application.getPostalAddress();
    }

    /**
     * Returns the email of the service provider stored in the application
     *
     * @return email in application
     */
    public String getEmail() {
        return this.application.getEmail();
    }

    /**
     * Returns the Phone number of the service provider stored in the
     * application
     *
     * @return phone number in application
     */
    public String getTelephoneNumber() {
        return String.valueOf(this.application.getTel());
    }

    /**
     * Gets the Full name of the Service Provider and creates an abreviated
     * version of it using the First Letters of each word
     *
     * @return Abreviated name of service provider
     */
    public String getAbreviatedName() {
        String[] temp = application.getName().split(" ");
        StringBuilder name = new StringBuilder();
        for (String temp1 : temp) {
            name.append(temp1.charAt(0));
        }
        String abrevName = name.toString();
        return abrevName;
    }

    /**
     * returns the categories in the application
     *
     * @return
     */
    public List<Category> getCategorySP() {
        return application.getCatList();
    }

    /**
     * Creates a new validated Intance of ServiceProvider
     *
     * @param fullName full name of the service provider
     * @param abreviatedName abreviated name of the service provider
     * @param tinNumber tin number of the service provider
     * @param telephoneNumber phone number of the service provider
     * @param email email of the service provider
     * @return boolean regarding the success of the operation
     */
    public boolean updateProviderInfo(String fullName, String abreviatedName, int tinNumber, int telephoneNumber, String email) {
        try {
            this.serviceProv = servProvRecords.newServiceProvider(fullName, abreviatedName, tinNumber, telephoneNumber, email);
            servProvRecords.validateServiceProvider(serviceProv);
            return true;
        } catch (RuntimeException ex) {
            this.serviceProv = null;
            return false;
        }
    }

    /**
     * Adds the categories and geographical areas chosen to the Service Provider
     *
     * @param fullName full name of the service provider
     * @param abreviatedName abreviated name of the service provider
     * @param tinNumber tin number of the service provider
     * @param telephoneNumber phone number of the service provider
     * @param email email of the service provider
     * @param categories List of Categories
     * @param geoArea geographical area of the service provider
     * @return boolean regarding the success of the operation
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     */
    public boolean registerNewServiceProvider(String fullName, String abreviatedName, int tinNumber, int telephoneNumber, String email, Category[] categories, GeographicalArea geoArea) throws UnsupportedEncodingException, FileNotFoundException {
        try {
            this.serviceProv = servProvRecords.newServiceProvider(fullName, abreviatedName, tinNumber, telephoneNumber, email);
            servProvRecords.validateServiceProvider(serviceProv);
            if (servProvRecords.registerServiceProvider(serviceProv)) {
                for (Category category : categories) {
                    addCategory(category);
                }
                addGeoArea(geoArea);
                PostalAddress postalAddress = this.application.getPostalAddress();
                this.serviceProv.addPostalAddress(postalAddress);
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException ex) {
            this.serviceProv = null;
            return false;
        }

    }

    /**
     * Adds the category to the Service Provider
     *
     * @param cat Category to be added
     * @return boolean relative to the success of the operation
     */
    public boolean addCategory(Category cat) {
        return serviceProv.addCategory(cat);
    }

    /**
     * Adds the GeographicalArea to the Service Provider
     *
     * @param geoArea Geographical Area to be added
     * @return boolean relative to the success of the operation
     */
    public boolean addGeoArea(GeographicalArea geoArea) {
        return serviceProv.addGeographicalArea(geoArea);
    }

    /**
     * Checks if the email is already registered in the company
     *
     * @param email email
     * @return boolean regarding if it's true or not
     */
    public boolean checkEmail(String email) {
        return company.getClientRecords().getAutorizacaoFacade().getUserRecords().hasUser(email);
    }

}
