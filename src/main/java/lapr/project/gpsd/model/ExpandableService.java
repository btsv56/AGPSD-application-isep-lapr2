/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author marta
 */
public class ExpandableService implements Service {


    /**
     * Id of the service.
     */
    private String id;

    /**
     * Brief description
     */
    private String briefDesc;

    /**
     * Complete description.
     */
    private String compDesc;

    /**
     * Cost per hour.
     */
    private double costHour;

    /**
     * Category
     */
    private Category cat;

    /**
     * Constructor.
     * 
     * @param id if of the service
     * @param briefDesc brief description
     * @param compDesc complete description
     * @param costHour cost per hour
     * @param cat category
     */
    public ExpandableService(String id, String briefDesc, String compDesc, double costHour,
            Category cat) {
        this.id = id;
        this.briefDesc = briefDesc;
        this.compDesc = compDesc;
        this.costHour = costHour;
        this.cat = cat;
    }

    /**
     * Returns the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the brief description.
     * 
     * @return the briefDesc
     */
    public String getBriefDesc() {
        return briefDesc;
    }

    /**
     * Returns the complete description.
     * 
     * @return the compDesc
     */
    public String getCompDesc() {
        return compDesc;
    }

    /**
     * Returns the cost per hour.
     * 
     * @return the costHour
     */
    public double getCostHour() {
        return costHour;
    }

    /**
     * Returns the category.
     * 
     * @return the cat
     */
    public Category getCat() {
        return cat;
    }

    /**
     * Changes the id to the one received by parameter.
     * 
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Changes the brief description to the one received by parameter.
     * 
     * @param briefDesc the briefDesc to set
     */
    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    /**
     * Changes the complete description to the one received by parameter.
     * 
     * @param compDesc the compDesc to set
     */
    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    /**
     * Changes the cost per hour to the one received by parameter.
     * 
     * @param costHour the costHour to set
     */
    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    /**
     * Changes the category to the one received by parameter.
     * 
     * @param cat the cat to set
     */
    public void setCat(Category cat) {
        this.cat = cat;
    }

    /**
     * Returns false, since this type of service doesn't have other attributes.
     * 
     * @return boolean false
     */
    @Override
    public boolean hasOtherAttributes() {
        return false;
    }

    /**
     * Returns a null because this type of service doesn't have other attributes.
     * 
     * @return null string
     */
    @Override
    public String getOtherAttributes() {
        return null;
    }

    /**
     * Doesn't set any additional data since it doesn't have one.
     * @param data int
     */
    @Override
    public void setAdditionalData(int data) {

    }

    /**
     * Returns the category of the service.
     * @return Category cat
     */
    @Override
    public Category getCategory() {
        return getCat();
    }

    /**
     * Validates the service by checking if it doesn't have any empty or null arguments.
     * @return boolean true if none of the arguments are null, false otherwise
     */
    @Override
    public boolean validates() {
        boolean result = true;
        if (this.id == null || this.id.isEmpty() || this.briefDesc == null || this.briefDesc.isEmpty()
                || this.compDesc == null || this.compDesc.isEmpty() || this.cat == null) {
            result = false;
        }
        return result;
    }

    /**
     * Returns the total cost for a duration
     *
     * @param dur duration
     * @return cost for duration
     */
    @Override
    public double getCostForDuration(int dur) {
        double durHour = dur / 60;
        return this.costHour * durHour;
    }

    /**
     * Returns the id of the service.
     *
     * @return String ID
     */
    @Override
    public String getUniqueID() {
        return getId();
    }

    /**
     * Returns the text format of the expandable service.
     *
     * @return String "Expandable Service:
     *      Id: (id)
     *      Brief Description: (briefDesc)
     *      Complete Description: (compDesc)
     *      Category: (cat)"
     */
    @Override
    public String toString() {
        return String.format("Expandable Service: %n Id: %s%n Brief Description: %s%n Complete "
                + "Description: %s%n Category: %s%n", this.id, this.briefDesc,
                this.compDesc, this.cat.toString());
    }

    /**
     *Returns the service's hash code
     * @return int hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compares an object with an object of ExpandableService and checks if 
     * they are equal.
     * 
     * @param o Object
     * @return boolean true if it's equal, false otherwise
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
        ExpandableService obj = (ExpandableService) o;
        return (Objects.equals(id, obj.id));
    }

}
