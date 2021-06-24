/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.records.ApplicationRecords;
import lapr.project.records.CategoryRecords;
import lapr.project.records.PostalCodeRecords;

/**
 *
 * @author User
 */
public class SubmitApplicationController {

    private Company company;
    private Application appl;
    private AppGPSD app;
    private PostalCodeRecords pcr;
    private ApplicationRecords appRec;

    public SubmitApplicationController() {
        this.app = AppGPSD.getInstance();
        this.company = AppGPSD.getInstance().getCompany();
        this.pcr = company.getPostalCodeRecords();
        this.appRec = company.getApplicationRecords();
    }

    /**
     *
     * @param name name of candidate
     * @param tin Tax Identification Number of candidate
     * @param tel Telephone of candidate
     * @param email Email of candidate
     * @param postAd Postal Address of candidate
     * @param s_postCode Postal Code of Candidate
     * @param local Location of Candidate
     * @return true if Application was instanciated, false if Application
     * wasnt't instanciated
     */
    public boolean newApplication(String name, int tin, int tel, String email, String postAd, String s_postCode, String local) {

        try {
            double latitude = pcr.getLatitudeByID(s_postCode);
            double longitude = pcr.getLongitudeByID(s_postCode);
            PostalCode postCode = new PostalCode(s_postCode, latitude, longitude);
            PostalAddress postAdr = Application.newPostalAddress(postAd, postCode, local);
            this.appl = appRec.newApplication(name, tin, tel, email, postAdr);
            return true;
        } catch (RuntimeException ex) {
            this.appl = null;
            return false;
        }
    }

    /**
     * Method that adds an academic habilitation
     *
     * @param description description of academic habilitation
     * @return
     */
    public boolean addAcadHabilitation(String description) {
        return appl.addAcadHabilitation(description);
    }

    /**
     * Method that adds an professional habilitation
     *
     * @param designation Designation of Professional Habilitation
     * @param degree Degree of Professional Habilitation
     * @param classification Classification of Professional Habilitation
     * @return true if professional habilitation was added, false if
     * professional habilitation wasn't added
     */
    public boolean addProfHabilitation(String designation, int degree, String classification) {
        return appl.addProfHabilitation(designation, degree, classification);
    }

    /**
     * Method that adds an Supporting Document
     *
     * @param doc Supporting Document of Habiliations of Candidate
     * @return true if Supporting Document was added, false if Supporting
     * Document wasn't added
     */
    public boolean addSupportingDoc(String doc) {
        return appl.addSupportingDoc(doc);
    }

    /**
     * Method that adds Categories
     *
     * @param cat Category of Application
     * @return true if Category was added, false if Category wasn't added
     */
    public boolean addCategory(Category cat) {
        return appl.addCategory(cat);
    }

    /**
     * Method that validates Application
     *
     * @return true if application is valid and false if application isn't valid
     */
    public boolean validateApplication() {
        return company.getApplicationRecords().validateAplication(appl);
    }

    /**
     * Method that register application
     *
     * @return true if application was registered and false if application isn't
     * registered
     */
    public boolean registerApplication() {
        return company.getApplicationRecords().registerApplication(appl);
    }

    /**
     * Method that returns List of Categories
     *
     * @return List of Categories
     */
    public List<Category> getCategories() {
        CategoryRecords cr = company.getCategoryRecords();
        List<Category> catList = cr.getCategories();
        return catList;
    }

    /**
     *    /**
     * Checks if already exists an instance with the same email
     *
     * @param email email to compare
     * @return boolean relative to the operation
     */
    public boolean checkEmail(String email) {
        return company.getClientRecords().getAutorizacaoFacade().getUserRecords().hasUser(email);
    }
}
