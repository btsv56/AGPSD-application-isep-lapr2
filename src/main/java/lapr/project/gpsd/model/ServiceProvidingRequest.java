/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.GeographicalAreaRecords;

/**
 *
 * @author Utilizador
 */
public class ServiceProvidingRequest {

    /**
     * Number of the service providing request
     */
    private int number;
    /**
     * Client associated to the service providing request
     */
    private Client client;
    /**
     * Postal Address associated to the service providing request
     */
    private PostalAddress postalAddress;
    /**
     * List with the descriptions of the services that need to be executed
     */
    private ArrayList<ServiceProvidingRequestDescription> descList;
    /**
     * List with the time preferences of the client for the service providing
     * request
     */
    private ArrayList<TimePreference> timePreferenceList;
    /**
     * List with the other costs of the service providing request
     */
    private ArrayList<OtherCost> otherCostList;

    /**
     * Contructor
     *
     * @param client: client associated to the service
     * @param postalAddress: postal address asociated to the client
     */
    public ServiceProvidingRequest(Client client, PostalAddress postalAddress) {
        if ((client == null) || (postalAddress == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.client = client;
        this.postalAddress = postalAddress;
        this.descList = new ArrayList<>();
        this.otherCostList = new ArrayList<>();
        this.timePreferenceList = new ArrayList<>();
    }

    /**
     * Returns the list of descritions of the request
     *
     * @return list of descriptions
     */
    public ArrayList<ServiceProvidingRequestDescription> getDescriptionList() {
        ArrayList<ServiceProvidingRequestDescription> requestList = new ArrayList<>();
        for (ServiceProvidingRequestDescription spd : this.descList) {
            requestList.add(spd);
        }
        return requestList;
    }

    /**
     * Returns the time preference list
     *
     * @return time preference list
     */
    public ArrayList<TimePreference> getTimePreferenceList() {
        ArrayList<TimePreference> timePreferenceList = new ArrayList<>();
        for (TimePreference tm : this.timePreferenceList) {
            timePreferenceList.add(tm);
        }
        return timePreferenceList;
    }

    public void removeTimePreference(TimePreference pref) {
        this.timePreferenceList.remove(pref);
    }

    /**
     * Returns the max duration of all the services
     *
     * @return duration of the longest service
     */
    public int getMaxDuration() {
        int dur = 0;
        for (ServiceProvidingRequestDescription spd : this.descList) {
            if (spd.getDuration() > dur) {
                dur = spd.getDuration();
            }
        }
        return dur;
    }

    public Client getClient() {
        return this.client;
    }

    /**
     * Attributes a number to a service providing request
     *
     * @param number:number of the service providing request
     */
    public void setNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number can't be negative");
        }
        this.number = number;
    }

    /**
     * Adds a descritpion of the service request if its description is valid
     *
     * @param serv: service requested
     * @param desc: service description
     * @param dur: service duration
     * @return boolean that indicates if the service providing request is valida
     * or not
     */
    public boolean addServiceProvidingRequest(Service serv, String desc, int dur) {
        ServiceProvidingRequestDescription des = new ServiceProvidingRequestDescription(serv, desc, dur);
        if (validateServiceProvidingRequest(des)) {
            return addServiceProvidingRequest(des);

        }
        return false;
    }

    /**
     * Validates a description of the requested service
     *
     * @param des: description of the requested service
     * @return boolean that indicates if the description is valid or not
     */
    private boolean validateServiceProvidingRequest(ServiceProvidingRequestDescription des) {
        boolean vef = true;
        if (des == null) {
            vef = false;
        }
        if (des.getDuration() % 30 != 0) {
            throw new IllegalArgumentException("Duration must be a multiple of 30");
        }
        return vef;
    }

    /**
     * Adds a service description to the list
     *
     * @param des: description of the service requested
     * @return boolean that indicates if te description was added or not
     */
    private boolean addServiceProvidingRequest(ServiceProvidingRequestDescription des) {
        return this.descList.add(des);
    }

    /**
     * Adds a time preference to the list depending if the time preference is
     * valid or not
     *
     * @param date: date of the realization of the service
     * @param hour: hour of the realization of the service
     * @return boolean that indicates if the time preference is valid or not
     */
    public boolean addTime(LocalDate date, String hour) {
        Time time = new Time(hour);
        int ordem = countSchedules();
        TimePreference h = new TimePreference(ordem, date, time);
        if (validateSchedule(h)) {
            return addTime(h);
        }
        return false;
    }

    /**
     * Counts the number of time preferences that exist in the list related to a
     * service providing request
     *
     * @return number of time preferences
     */
    private int countSchedules() {
        return timePreferenceList.size();
    }

    /**
     * validates a time preference
     *
     * @param tm: time preference
     * @return boolean that indicates if the time preference is valid or not
     */
    private boolean validateSchedule(TimePreference tm) {
        boolean vef = true;
        if (tm == null) {
            vef = false;
        }
        if (tm.getDate().compareTo(LocalDate.now()) < 0 || tm.getDate().compareTo(LocalDate.now()) == 0 && tm.getHour().compareTo(Time.currentTime()) < 0) {
            throw new IllegalArgumentException("Time preference can't before this exact moment");
        }
        if (tm.getDate().getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0) {
            throw new IllegalArgumentException("Sunday is not a valid day to make the request");
        }
        int t= tm.getHour().toSeconds() + getMaxDuration()*60;
        Time finalHour = Time.fromSecondsToTime(t);
        if (tm.getHour().compareTo(new Time(6, 0)) < 0 || tm.getHour().compareTo(new Time(18, 0)) > 0 || finalHour.compareTo(new Time(18, 0)) > 0) {
            throw new IllegalArgumentException("The time selected is not valid for a request");
        }
        return vef;
    }

    /**
     * Adds a time preference to the list
     *
     * @param h:time preference
     * @return boolean that indicate if the time is added or not
     */
    public boolean addTime(TimePreference h) {
        return this.timePreferenceList.add(h);
    }

    /**
     * Calculates the cost of a service providing request
     *
     * @return double cost
     */
    public double calculateCost() {
        double c = 0;
        for (ServiceProvidingRequestDescription dsp : descList) {
            c += dsp.getCost();
        }
        otherCostList.clear();
        PostalCode cp = postalAddress.getPostalCode();
        AppGPSD app = AppGPSD.getInstance();
        Company company = app.getCompany();
        GeographicalAreaRecords gar = company.getGeographicalAreaRecords();
        GeographicalArea ga = gar.getClosestGeographicalArea(cp);
        double deslocationCost = ga.getDislocationCost();
        OtherCost oc = new OtherCost("Deslocation", deslocationCost);
        otherCostList.add(oc);
        c += deslocationCost;
        return c;
    }

    /**
     * Calculates the cost of a service providing request (for testing purposes)
     *
     * @return double cost
     */
    public double calculateCostTest() {
        return 2;
    }

    /**
     * Comparates two objects of ServiceProvidingRequest and verify if they are
     * equal
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
        ServiceProvidingRequest obj = (ServiceProvidingRequest) o;
        return (Objects.equals(this.client, obj.client) && Objects.equals(this.descList, obj.descList) && Objects.equals(this.postalAddress, obj.postalAddress)
                && Objects.equals(this.number, obj.number) && Objects.equals(this.otherCostList, obj.otherCostList)
                && Objects.equals(this.timePreferenceList, obj.timePreferenceList));
    }

    /**
     * Método toString: Returns a description of service providing request
     *
     * @return description of service providing request
     */
    @Override
    public String toString() {
        String str = String.format("Client: %s | Postal Code: %s | Services: ", this.client.getName(), this.postalAddress.getPostalCode().getPostalCode());
        for (int i = 0; i < this.descList.size(); i++) {
            str += descList.get(i).getService() + " - ";
        }
        return str;
    }
    
    public PostalAddress getPostalAddress() {
        return this.postalAddress;
    }

}
