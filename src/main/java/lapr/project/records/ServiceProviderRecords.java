package lapr.project.records;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceProvider;

public class ServiceProviderRecords {

    /**
     * List containing the Service Providers
     */
    List<ServiceProvider> serviceProviderList;

    public ServiceProviderRecords() {
        this.serviceProviderList = new ArrayList<>();
    }

    /**
     * Returns a servider provider by his email
     *
     * @param email email
     * @return service provider with that email
     */
    public ServiceProvider getServiceProvider(String email) {
        for (ServiceProvider sp : this.serviceProviderList) {
            if (sp.hasEmail(email)) {
                return sp;
            }
        }
        return null;
    }

    /**
     * Returns the List of Service Providers
     *
     * @return list of Service Providers
     */
    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    /**
     * Creates and returns a new Service Provider
     *
     * @param fullName Service Provider's Full Name
     * @param abrevName Service Provider's Abreviated Name
     * @param tinNumber Service Provider's TIN Number
     * @param phoneNumber Service Provider's Phone Number
     * @param email Service Provider's Email
     * @return new instance of ServiceProvider
     */
    public ServiceProvider newServiceProvider(String fullName, String abrevName, int tinNumber, int phoneNumber, String email) {
        return new ServiceProvider(fullName, abrevName, tinNumber, phoneNumber, email);
    }

    /**
     * Validates and adds a service provider to the list
     *
     * @param servProv Service Provider to be registered
     * @return boolean relative to the succes of the operation
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     */
    public boolean registerServiceProvider(ServiceProvider servProv) throws UnsupportedEncodingException, FileNotFoundException {
        if (validateServiceProvider(servProv)) {
            String pwd = generatePWD();
            AuthorizationFacade authorization = AppGPSD.getInstance().getCompany().getClientRecords().getAutorizacaoFacade();
            if (authorization.registerUserWithPaper(servProv.getFullName(), servProv.getEmail(), pwd, Constants.PAPER_SERVICE_PROVIDER)) {
                addServiceProvider(servProv);
            }
            int mechaNumber = generateMechaNumber();
            servProv.setMechaNumber(mechaNumber);
            servProv.setPWD(pwd);
            return true;
        }
        return false;
    }

    /**
     * Adds a service provider to the list
     *
     * @param servProv Service Provider to be added
     * @return boolean relative to the success of the operation
     */
    public boolean addServiceProvider(ServiceProvider servProv) {
        return this.serviceProviderList.add(servProv);
    }

    /**
     * Checks if all the parameters are valid
     *
     * @param servProv Service Provider to be validated
     * @return boolean relative to the validation
     */
    public boolean validateServiceProvider(ServiceProvider servProv) {
        boolean b = true;
        if (servProv.getFullName().isEmpty()) {
            b = false;
        }
        if (servProv.getFullName() == null) {
            b = false;
        }
        if (servProv.getAbrevName().isEmpty()) {
            b = false;
        }
        if (servProv.getAbrevName() == null) {
            b = false;
        }
        if (servProv.getEmail().isEmpty()) {
            b = false;
        }
        if (servProv.getEmail() == null) {
            b = false;
        }
        if (servProv.getTinNumber() <= 99999999 && servProv.getTinNumber() > 999999999) {
            b = false;
        }
        if (servProv.getPhoneNumber() <= 999999999 && servProv.getPhoneNumber() > 999999999) {
            b = false;
        }
        if (servProv.getMechaNumber() <= 9999 && servProv.getMechaNumber() > 9999) {
            b = false;
        }
        return b;
    }

    /**
     * Generates the Mechanographic Number of the Service Provider
     *
     * @return service provider's mechanographic number
     */
    private int generateMechaNumber() {
        int num = serviceProviderList.size();
        return Integer.valueOf(Constants.COMPANY_ID + String.valueOf(num));
    }

    /**
     * Generates a Random Password Using an alphabet dictionary
     *
     * @return Service Provider's Password
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public String generatePWD() throws FileNotFoundException, UnsupportedEncodingException {
        SecureRandom random = new SecureRandom();
        StringBuilder pwdB = new StringBuilder();
        for (int i = 0; i < Constants.PASSWORD_LENGTH; i++) {
            int index = random.nextInt(Constants.ALPHA.length());
            pwdB.append(Constants.ALPHA.charAt(index));
        }
        String pwd = pwdB.toString();
        PrintWriter writer = new PrintWriter("spPass.txt", "UTF-8");
        writer.println(pwd);
        writer.close();
        return pwd;
    }

    /**
     * Hashes the information of this class
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.serviceProviderList);
        return hash;
    }

    /**
     * checks if an object is equals to this one
     *
     * @param obj object to be compared
     * @return boolean regarding if it's true or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServiceProviderRecords other = (ServiceProviderRecords) obj;
        if (!Objects.equals(this.serviceProviderList, other.serviceProviderList)) {
            return false;
        }
        return true;
    }

    /**
     * Registers a new Service Provider with password in the authorization
     *
     * @param servProv Service provider to be registered
     * @param pwd Password generated for the service provider
     * @return boolean regarding the success of the operation
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     */
    public boolean registerServiceProviderWithPass(ServiceProvider servProv, String pwd) throws UnsupportedEncodingException, FileNotFoundException {
        if (validateServiceProvider(servProv)) {
            AuthorizationFacade authorization = AppGPSD.getInstance().getCompany().getClientRecords().getAutorizacaoFacade();
            if (authorization.registerUserWithPaper(servProv.getFullName(), servProv.getEmail(), pwd, Constants.PAPER_SERVICE_PROVIDER)) {
                addServiceProvider(servProv);
            }
            int mechaNumber = generateMechaNumber();
            servProv.setMechaNumber(mechaNumber);
            servProv.setPWD(pwd);
            return true;
        }
        return false;
    }

}
