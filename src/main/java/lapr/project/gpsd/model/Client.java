/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.PostalCodeRecords;

/**
 *
 * @author paulomaio
 */
public class Client {

    private String m_strName;
    private String m_strTIN;
    private String m_strPhone;
    private String m_strEmail;
    private List<PostalAddress> m_lstAddresses = new ArrayList<PostalAddress>();

    public Client(String strName, String strTIN, String strPhone, String strEmail, PostalAddress oAddress) {
        if ((strName == null) || (strTIN == null) || (strPhone == null)
                || (strEmail == null) || (oAddress == null)
                || (strName.isEmpty()) || (strTIN.isEmpty()) || (strPhone.isEmpty())
                || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }

        this.m_strName = strName;
        this.m_strEmail = strEmail;
        this.m_strTIN = strTIN;
        this.m_strPhone = strPhone;
        m_lstAddresses.add(oAddress);
    }

    public Client(String strName, String strTIN, String strPhone, String strEmail) {
        if ((strName == null) || (strTIN == null) || (strPhone == null)
                || (strEmail == null)
                || (strName.isEmpty()) || (strTIN.isEmpty()) || (strPhone.isEmpty())
                || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }

        this.m_strName = strName;
        this.m_strEmail = strEmail;
        this.m_strTIN = strTIN;
        this.m_strPhone = strPhone;
    }

    public List<PostalAddress> getPostalAddresses() {
        ArrayList<PostalAddress> postalAddressList = new ArrayList<>();
        for(PostalAddress pa: this.m_lstAddresses) {
            postalAddressList.add(pa);
        }
        return postalAddressList;
    }

    public String getName() {
        return this.m_strName;
    }

    public String getEmail() {
        return this.m_strEmail;
    }

    public boolean hasEmail(String strEmail) {
       return this.m_strEmail.equalsIgnoreCase(strEmail);
    }

    public boolean addPostalAddress(PostalAddress oAddress) {
        return this.m_lstAddresses.add(oAddress);
    }

    public boolean removePostalAddress(PostalAddress oAddress) {
        return this.m_lstAddresses.remove(oAddress);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        Client obj = (Client) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail) || Objects.equals(m_strTIN, obj.m_strTIN));
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s", this.m_strName, this.m_strTIN, this.m_strPhone, this.m_strEmail);
        for (PostalAddress address : this.m_lstAddresses) {
            str += "\nAddress:\n" + address.toString();
        }
        return str;
    }

    public static PostalAddress newPostalAddress(String address, PostalCode strPostalCode, String local) {
        return new PostalAddress(address, strPostalCode, local);
    }

    public PostalAddress newPostalAddress(String address, String strPostalCode, String local) throws FileNotFoundException {
        AppGPSD app=AppGPSD.getInstance();
        Company company= app.getCompany();
        PostalCodeRecords pcr = company.getPostalCodeRecords();
        double latitude = pcr.getLatitudeByID(strPostalCode);
        double longitude = pcr.getLongitudeByID(strPostalCode);
        PostalCode postCode2 = new PostalCode(strPostalCode, latitude, longitude);
        return new PostalAddress(address, postCode2, local);
    }

    public boolean addAddress(PostalAddress ad1) {
        if (validateAdress(ad1)) {
            return addPostalAddress(ad1);
        }
        return false;
    }

    private boolean validateAdress(PostalAddress ad1) {
        boolean b = true;
        if (ad1.getM_address().isEmpty()) {
            b = false;
        }
        if (ad1.getM_local().isEmpty()) {
            b = false;
        }
        if (ad1.getM_address() == null) {
            b = false;
        }
        if (ad1.getM_local() == null) {
            b = false;
        }
        return b;
    }

}
