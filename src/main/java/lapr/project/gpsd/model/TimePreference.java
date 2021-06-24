/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class TimePreference implements Comparable<Availability> {
    
    /**
     * Order of the time preference
     */
    private int order;
    /**
     * Day of the time preference
     */
    private LocalDate date;
    /**
     * Hour of the time preference
     */
    private Time hour;

    /**
     * Constructor
     * 
     * @param order: Order of the time preference
     * @param date: day of the time preference
     * @param hour : Hour of the time preference
     */
    public TimePreference(int order, LocalDate date, Time hour) {
        if ((date == null) || (hour == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }
        this.order=order;
        this.date=date;
        this.hour=hour;
    }
    
    /**
     * Returns the date
     * 
     * @return date
     */
    public LocalDate getDate() {
        return this.date;
    }
    
    /**
     * Returns the time
     * 
     * @return time
     */
    public Time getHour() {
        return this.hour;
    }
    
     /**
     * Compares two objects of TimePreference and
     * verify if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        TimePreference obj = (TimePreference) o;
        return (Objects.equals(this.date, obj.date) && Objects.equals(this.hour, obj.hour) && Objects.equals(this.order, obj.order));
    }
    
    /**
     * Compares an instance of TimePreference to an instance of Availability, to see if the latter includes the former
     * 
     * @param avail
     * @return 1, if the TimePreference is included, 0 if it's not
     */
    @Override
    public int compareTo(Availability avail) {
        LocalDate dateI=avail.getInitialDate();
        LocalDate dateF=avail.getFinalDate();
        Time hourI=avail.getInitialHour();
        Time hourF=avail.getFinalHour();
        
        int compDateI=dateI.compareTo(this.date);
        int compDateF=dateF.compareTo(this.date);
        int compHourI=hourI.compareTo(this.hour);
        int compHourF=hourF.compareTo(this.hour);

        if ((compDateI<0 || compDateI==0) && (compDateF>0 || compDateF==0) && (compHourI==-1 || compHourI==0) && (compHourF==1 || compHourF==0)) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * Method toString: description of a time preference
     * 
     * @return description of a time preference
     */
    @Override
    public String toString() {
        String str = String.format("%d - %s - %s" ,this.order, this.date, this.hour.toString());
        return str;
    }
    
}
