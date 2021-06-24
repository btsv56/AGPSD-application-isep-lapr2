/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Time;
import lapr.project.gpsd.model.TimePreference;

/**
 *
 * @author Utilizador
 */
public class AvailabilityList {
    /**
     * List of all availabilities from a service provider
     */
    private ArrayList<Availability> availabilityList=new ArrayList<>();

    /**
     * Creates a returns a new availability of a service provider
     *
     * @param initialDate initial date of the availability
     * @param initialHour final hour of the availability
     * @param finalDate final date of the availability
     * @param finalHour final hour of the availability
     * @param period period of the availability
     * 
     * @return new availability
     */
    public Availability newAvailabilityTime(LocalDate initialDate, String initialHour, LocalDate finalDate, String finalHour, String period) {
        Time hourI = new Time(initialHour);
        Time hourF= new Time(finalHour);
        return new Availability(initialDate, hourI, finalDate, hourF, period);
    }

    /**
     * Validates and registers an availability
     *
     * @param aval: availability
     * @return boolean that indicates if the availability is added or not
     */
    public boolean registerAvailabiityTime(Availability aval) {
        if (validateAvailabilityTime(aval)) {
            return addAvailabilityTime(aval);
        }
        return false;
    }

    /**
     * Validates the availability
     *
     * @param aval availability
     * @return boolean that indicates if the availability is valid or not
     */
    private boolean validateAvailabilityTime(Availability aval) {
        boolean vef = true;
        if (aval == null) {
            vef = false;
        }
        //Compares the initial and final data
        if (aval.getInitialDate().compareTo(aval.getFinalDate()) > 0) {
            throw new IllegalArgumentException("The final date of the availability must be after the initial date");
        }
        //Comparates the initial and final times
        if (aval.getInitialHour().compareTo(aval.getFinalHour()) > 0) {
            throw new IllegalArgumentException("The final time of the availabity must be after the initial time");
        }
        //Comparates if the date is before e today and is the date corresponds to the present day comparates if it time is before the system time
        if (aval.getInitialDate().compareTo(LocalDate.now()) < 0 || aval.getInitialDate().compareTo(LocalDate.now()) == 0 && aval.getInitialHour().compareTo(Time.currentTime()) < 0) {
            throw new IllegalArgumentException("The availability is before the current time");
        }
        //Verifies if the time is between 06:00 and 18:00
        if(aval.getInitialHour().compareTo(new Time(6,0)) <0 || aval.getFinalHour().compareTo(new Time(18,0)) > 0 ) {
            throw new IllegalArgumentException("The service provider can't work at the specified hours");
        }
        for(Availability a: availabilityList) {
            if( (aval.getInitialDate().compareTo(a.getInitialDate()) >=0  && aval.getInitialDate().compareTo(a.getFinalDate())<=0 ) 
                  || (aval.getFinalDate().compareTo(a.getInitialDate())>=0 && aval.getFinalDate().compareTo(a.getFinalDate()) <=0 )
                  || (aval.getInitialDate().compareTo(a.getInitialDate())) <=0 && (aval.getFinalDate().compareTo(a.getFinalDate())) >=0 ) {
                throw new IllegalArgumentException("The availability has already been definied for that date");
            }
        }
        return vef;
    }

    /**
     * Returns de availability list
     * 
     * @return availability list
     */
    public ArrayList<Availability> getAvailabilityList() {
        ArrayList<Availability> avaList = new ArrayList<>();
        for(Availability aval: this.availabilityList) {
            avaList.add(aval);
        }
        return avaList;
    }

    /**
     * Adds a availability to the list of availabilities
     *
     * @param aval availability
     * @return boolean that indicates if the availability was added or not
     */
    public boolean addAvailabilityTime(Availability aval) {
            return this.availabilityList.add(aval);
    }

    /**
     * Removes the time period wherein the Service Provider is supposed to be busy doing a service
     * (Adds 4 new availabilities, removes the affected availability)
     *
     * @param avail
     * @param pref
     * @param dur
     */
    public void removeTimePeriod(Availability avail, TimePreference pref, int dur) {
        Availability availRmv=null;
        for (Availability availL: availabilityList) {
            if (avail.equals(availL)) {
                availRmv= new Availability(avail);
                break;
            }
        }
        Availability availNew1=new Availability(availRmv.getInitialDate(), availRmv.getInitialHour(), pref.getDate().minusDays(1), availRmv.getFinalHour(), availRmv.getPeriod());
        Availability availNew2=new Availability(pref.getDate(), availRmv.getInitialHour(), pref.getDate(), pref.getHour(), String.valueOf(pref.getDate().getDayOfWeek()));
        Availability availNew3=new Availability(pref.getDate(), pref.getHour().addTime(dur), pref.getDate(), availRmv.getFinalHour(), String.valueOf(pref.getDate().getDayOfWeek()));
        Availability availNew4=new Availability(pref.getDate().plusDays(1), availRmv.getInitialHour(), availRmv.getFinalDate(), availRmv.getFinalHour(), availRmv.getPeriod());
        availabilityList.remove(availRmv);
        availabilityList.add(availNew1);
        availabilityList.add(availNew2);
        availabilityList.add(availNew3);
        availabilityList.add(availNew4);
    }

    /**
     * Compares two objects of AvailabilityList and
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
        AvailabilityList obj = (AvailabilityList) o;
        return (Objects.equals(this.availabilityList, obj.availabilityList));
    }

    /**
     * Method toString
     *
     * @return description of one availability list
     */
    @Override
    public String toString() {
        String str = "Availabilities: ";
        for (Availability disp : this.availabilityList) {
            str += disp.toString() + " | ";
        }
        return str;
    }
}
