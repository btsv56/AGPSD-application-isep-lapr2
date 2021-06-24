package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeographicalArea {

    /**
     * Designation
     */
    private String designation;
    /**
     * Deslocation cost.
     */
    private double dislocationCost;
    /**
     * Radius of act.
     */
    private float radiusAct;
    /**
     * Postal code
     */
    private PostalCode postalCode;
    /**
     * External service.
     */
    private ExternalService api;
    /**
     * List of postal codes included in the radius of the geographical area
     */
    private List<ActsIn> act;

    public GeographicalArea() {

    }

    /**
     * Constructor.
     * @param designation String
     * @param dislocationCost double
     * @param postalCode String
     * @param radiusAct float
     * @param api external service
     * @throws FileNotFoundException fnfe
     */
    public GeographicalArea(String designation, double dislocationCost, String postalCode,
            float radiusAct, ExternalService api) throws FileNotFoundException {
        if (designation == null || designation.isEmpty() || postalCode == null || postalCode.isEmpty() || radiusAct <= 0) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }
        this.designation = designation;
        this.dislocationCost = dislocationCost;
        this.radiusAct = radiusAct;
        this.postalCode = new PostalCode(postalCode);
        this.api = api;
        this.act = api.obtainActing(this.postalCode, radiusAct);
    }

    /**
     * Returns designation
     * 
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Returns the radius act. 
     * 
     * @return the radiusAct
     */
    public float getRadiusAct() {
        return radiusAct;
    }

    /**
     * Returns dislocation cost.
     * 
     * @return the dislocationCost
     */
    public double getDislocationCost() {
        return dislocationCost;
    }

    /**
     * Returns postal.
     * 
     * @return the postalCode
     */
    public PostalCode getPostalCode() {
        return postalCode;
    }

    /**
     * Returns list of acts in.
     * 
     * @return the act
     */
    public List<ActsIn> getAct() {
        return new ArrayList<>(act);
    }

    /**
     * Changes designation to the one received by parameter.
     * 
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Changes the dislocation cost to the one received by parameter.
     * 
     * @param dislocationCost the dislocationCost to set
     */
    public void setDislocationCost(double dislocationCost) {
        this.dislocationCost = dislocationCost;
    }

    /**
     * Changes the radius act to the one received by parameter.
     * 
     * @param radiusAct the radiusAct to set
     */
    public void setRadiusAct(float radiusAct) {
        this.radiusAct = radiusAct;
    }

    /**
     * Changes the postal code to the one received by parameter.
     * 
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) throws FileNotFoundException {
        this.postalCode = new PostalCode(postalCode);
    }

    /**
     * Changes the list to the one received by parameter.
     * 
     * @param act the act to set
     */
    public void setAct(List<ActsIn> act) {
        this.act = new ArrayList<>(act);
    }

    /**
     * Checks if the geographical area has a designation equal to the one 
     * received by parameter.
     * @param designation
     * @return  boolean result of equals(designation)
     */
    public boolean hasDesignation(String designation) {
        return this.designation.equals(designation);
    }

    /**
     * Returns textual format of Geographical Area.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Geographical Area: %s%n Dislocation Cost: %.2f%n Postal Code: %s%n Radius: %.2f%n List of Postal Codes: %s%n", this.designation, this.dislocationCost,
                this.postalCode, this.radiusAct, this.act.toString());
    }

    /**
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.designation);
        return hash;
    }

    /**
     *  Checks if 2 objects are equal.
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        GeographicalArea obj = (GeographicalArea) o;
        return (Objects.equals(this.dislocationCost, obj.dislocationCost) && Objects.equals(this.postalCode, obj.postalCode)
                && Objects.equals(this.radiusAct, obj.radiusAct));
    }
}
