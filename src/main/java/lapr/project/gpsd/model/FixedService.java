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
public class FixedService implements Service {

    
    /**
     * Id of the service.
     */
    private String id;

    /**
     * Brief description.
     */
    private String briefDesc;

    /**
     * Complete description
     */
    private String compDesc;
    
    /**
     * Cost per hour.
     */
    private double costHour;

    /**
     * Pre-determined duration.
     */
    private int preDeterminedDuration;

    /**
     * Category
     */
    private Category cat;

    /**
     * Constructor.
     * @param id 
     * @param briefDesc brief description
     * @param compDesc complete description
     * @param costHour cost per hour
     * @param cat category
     */
    public FixedService(String id, String briefDesc, String compDesc, double costHour,
            Category cat) {
        this.id = id;
        this.briefDesc = briefDesc;
        this.compDesc = compDesc;
        this.costHour = costHour;
        this.cat = cat;
    }

    /**
     * Return the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Return the brief description.
     * 
     * @return the briefDesc
     */
    public String getBriefDesc() {
        return briefDesc;
    }

    /**
     * Return complete description.
     * 
     * @return the compDesc
     */
    public String getCompDesc() {
        return compDesc;
    }

    /**
     * Return cost per hour.
     * 
     * @return the costHour
     */
    public double getCostHour() {
        return costHour;
    }

    /**
     * Return the pre-determined duration.
     * 
     * @return the preDeterminedDuration
     */
    public int getPreDeterminedDuration() {
        return preDeterminedDuration;
    }

    /**
     * Return the category.
     * 
     * @return the cat
     */
    public Category getCat() {
        return cat;
    }

    /**
     * Return true since this type of service has other attributes.
     * @return boolean true
     */
    @Override
    public boolean hasOtherAttributes() {
        return true;
    }

    /**
     * Return the name of the other attribute of this type of service.
     * @return String "Pre-Determined Duration"
     */
    @Override
    public String getOtherAttributes() {
        return "Pre-Determined Duration";
    }

    /**
     * Changes the value of the predetermined duration to the value of the parameter.
     * @param data int
     */
    @Override
    public void setAdditionalData(int data) {
        this.preDeterminedDuration = data;
    }

    /**
     * Returns the category.
     * @return Category cat
     */
    @Override
    public Category getCategory() {
        return getCat();
    }

    /**
     * Validates the service, checking if the arguments aren't null or empty.
     * @return false if any of the arguments are null or empty and true if 
     * none of them are null or empty
     */
    @Override
    public boolean validates() {
        boolean result = true;
        if (this.id == null || this.id.isEmpty() || this.briefDesc == null || this.briefDesc.isEmpty() || this.compDesc == null || this.compDesc.isEmpty()
                || this.cat == null) {
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
     * @return String id
     */
    @Override
    public String getUniqueID() {
        return getId();
    }

    /**
     * Returns the text format of the fixed service.
     *
     * @return String "Fixed Service:
     *      Id: (id)
     *      Brief Description: (briefDesc)
     *      Complete Description: (compDesc)
     *      Category: (cat)
     *      Pre-Determined Duration: (dur)"
     */
    @Override
    public String toString() {
        return String.format("Fixed Service: %n Id: %s%n Brief Description: %s%n Complete "
                + "Description: %s%n Category: %s%n Pre-Determined Duration: %d%n", this.id, this.briefDesc,
                this.compDesc, this.cat.toString(), this.getPreDeterminedDuration());
    }

    /**
     *
     * @return int hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compares an object and other object of FixedService to see if they are equal.
     * 
     * @param o Object
     * @return boolean true if they're equal, false otherwise
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
        FixedService obj = (FixedService) o;
        return (Objects.equals(id, obj.id));
    }

}
