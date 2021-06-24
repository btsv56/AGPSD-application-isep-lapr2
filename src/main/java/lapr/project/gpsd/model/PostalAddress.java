/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class PostalAddress {

    /**
     * Address of Postal Address
     */
    private String m_address;
    /**
     * PostalCode of Postal Address
     */
    private PostalCode m_strPostalCode;
    /**
     * Location of Postal Address
     */
    private String m_local;

    /**
     * Constructor of PostalAddress
     *
     * @param strAdress Address of Postal Address
     * @param strPostalCode PostalCode of Postal Address
     * @param strLocal Location of Postal Address
     */
    public PostalAddress(String strAdress, PostalCode strPostalCode, String strLocal) {
        if ((strAdress == null) || (strPostalCode == null) || (strLocal == null)
                || (strAdress.isEmpty()) || (strLocal.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }

        this.m_address = strAdress;
        this.m_strPostalCode = strPostalCode;
        this.m_local = strLocal;
    }

    /**
     * Method that returns Address of Postal Address
     *
     * @return Address of Postal Address
     */
    public String getM_address() {
        return m_address;
    }

    /**
     * Method that returns location of Postal Address
     *
     * @return location of Postal Address
     */
    public String getM_local() {
        return m_local;
    }

    /**
     * Method that returns postal code of Postal Address
     *
     * @return postal code of Postal Address
     */
    public PostalCode getPostalCode() {
        return this.m_strPostalCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hash(this.m_address, this.m_strPostalCode, this.m_local);
        return hash;
    }

    /**
     * Comparates two objects of Application and verify if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
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
        PostalAddress obj = (PostalAddress) o;
        return (Objects.equals(m_address, obj.m_address)
                && Objects.equals(m_strPostalCode, obj.m_strPostalCode)
                && Objects.equals(m_local, obj.m_local));
    }

    /**
     * Method that returns a string that characterizing the postal address
     *
     * @return String that characterizing the postal address
     */
    @Override
    public String toString() {
        return String.format("%s \n %s - %s", this.m_address, this.m_strPostalCode, this.m_local);
    }

}
