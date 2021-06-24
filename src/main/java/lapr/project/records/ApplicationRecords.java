package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.PostalAddress;

public class ApplicationRecords {

    /**
     * List with the instances of Application.
     */
    private List<Application> applicationList = new ArrayList<>();

    /**
     * Returns the List of Applications made my Service Providers.
     *
     * @return list of Applications
     */
    public List<Application> getApplicationList() {
        ArrayList<Application> applicationList = new ArrayList<>();
        for (Application app : this.applicationList) {
            applicationList.add(app);
        }
        return applicationList;
    }

    /**
     * Method that instanciates and returns an application
     *
     * @param name name of the candidate
     * @param tin tin of the candidate
     * @param tel tel of the candidate
     * @param email email of the candidate
     * @param postAd postal Address of the candidate
     * @return Application's object
     */
    public Application newApplication(String name, int tin, int tel, String email, PostalAddress postAd) {
        return new Application(name, tin, tel, email, postAd);
    }

    /**
     * Method that validates application
     *
     * @param appl application that will be validated
     * @return true if application is valid and false if application isn't valid
     */
    public boolean validateAplication(Application appl) {
        boolean b = true;
        if (appl.getName().isEmpty()) {
            b = false;
        }
        if (appl.getName() == null) {
            b = false;
        }
        if (appl.getEmail().isEmpty()) {
            b = false;

        }
        if (appl.getEmail() == null) {
            b = false;
        }
        if (appl.getTin() <= 99999999 || appl.getTin() > 999999999) {
            b = false;
        }
        if (appl.getTel() <= 99999999 || appl.getTel() > 999999999) {
            b = false;
        }
        return b;

    }

    /**
     * Method that register Application
     *
     * @param appl application
     * @return true if application was registered and false if application
     * wasn't registered
     */
    public boolean registerApplication(Application appl) {
        if (validateAplication(appl)) {
            return addAplication(appl);
        }
        return false;
    }

    /**
     * Method that adds application to the list of applications
     *
     * @param appl Application that will be added
     * @return true if application was added, and false if application wasn't
     * added
     */
    public boolean addAplication(Application appl) {
        return this.applicationList.add(appl);
    }

    /**
     * Returns one instance of an Application which has a determined TIN number
     * associated to it.
     *
     * @param tin TIN number of the Service Provider
     * @return Application associated to the TIN number
     */
    public Application getApplicationByTIN(int tin) {
        for (Application application : this.applicationList) {
            if (application.hasTIN(tin)) {
                return application;
            }
        }
        throw new IllegalArgumentException("The TIN does not belong");
    }

}
