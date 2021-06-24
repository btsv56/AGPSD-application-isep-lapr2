/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class ServiceProvidingRequestDescription {

    /**
     * Service that will be executed
     */
    private Service serv;
    /**
     * Description of the service that will be executed
     */
    private String desc;
    /**
     * Duration of the service that will be executed
     */
    private int dur;

    /**
     * Contructor
     *
     * @param serv:service that will be executed
     * @param desc: description of the service that will be executed
     * @param dur : duration of the service that will be executed
     */
    public ServiceProvidingRequestDescription(Service serv, String desc, int dur) {
        if ((serv == null) || (desc == null) || (desc.isEmpty())) {
            throw new IllegalArgumentException("None of the argument can be null or empty");
        }
        this.serv = serv;
        this.desc = desc;
        this.dur = dur;
    }

    /**
     * Returns the service related to the description
     *
     * @return service related to the description
     */


    public Service getService() {
        return serv;
    }

    /**
     * Returns the duration of the service
     *
     * @return duration of the service
     */
    public int getDuration() {
        return this.dur;
    }
    
    /**
     * Returns the duration of the service
     *
     * @return duration of the service
     */
    public String getDescription() {
        return this.desc;
    }
    

    /**
     * Return de duration cost of a service
     * 
     * @return cost
     */
    public double getCost() {
        double cd=serv.getCostForDuration(dur);
        return cd;
    }
    
    /**
     * Comparates two objects of service providing request description and
     * verify if they are equal
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
        ServiceProvidingRequestDescription obj = (ServiceProvidingRequestDescription) o;
        return (Objects.equals(this.desc, obj.desc) && Objects.equals(this.dur, obj.dur) && Objects.equals(this.serv, obj.serv));
    }

    /**
     * Método toString
     *
     * @return description
     */
    @Override
    public String toString() {
        String str = String.format("%s - %d - %s", this.desc, this.dur, this.serv.toString());
        return str;
    }
}
