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
public class Availability {
    
    /**
     * Initial date of an availability
     */
    private LocalDate initialDate;
    /**
     * Initial hour of an availability
     */
    private Time initialHour;
    /**
     * Final date of an availability
     */
    private LocalDate finalDate;
    /**
     * Final hour of an availability
     */
    private Time finalHour;
    /**
     * Period where the availability stands
     */
    private String period;

    /**
     * Constructor
     *
     * @param initialDate: initial date of an availability
     * @param initialHour: initial hour of an availability
     * @param finalDate: final date of an availability
     * @param finalHour: final hour of an availability
     * @param period: Period where the availability stands
     */
    public Availability(LocalDate initialDate, Time initialHour, LocalDate finalDate, Time finalHour, String period) {
        if ((initialDate == null) || (initialHour == null) || (finalDate == null) || (finalHour == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        }
        this.initialDate = initialDate;
        this.initialHour = initialHour;
        this.finalDate = finalDate;
        this.finalHour = finalHour;
        this.period=period;
    }

    /**
     * Creates a new availability
     * 
     * @param avail availability
     */
    public Availability(Availability avail) {
        this.initialDate = avail.initialDate;
        this.initialHour = avail.initialHour;
        this.finalDate = avail.finalDate;
        this.finalHour = avail.finalHour;
        this.period= avail.period;
    }
    
    /**
     * Returns the initial date
     *
     * @return initial date
     */
    public LocalDate getInitialDate() {
        return initialDate;
    }

    /**
     * Return the initial hour
     *
     * @return initial hour
     */
    public Time getInitialHour() {
        return initialHour;
    }

    /**
     * Return the final date
     *
     * @return final date
     */
    public LocalDate getFinalDate() {
        return finalDate;
    }

    /**
     * Return the final hour
     *
     * @return final hour
     */
    public Time getFinalHour() {
        return finalHour;
    }

    /**
     * Return the period
     *
     * @return period
     */
    public String getPeriod() {
        return this.period;
    }

    /**
     * Comparates two objects of Availability and
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
        Availability obj = (Availability) o;
        return (Objects.equals(this.finalDate, obj.finalDate) && Objects.equals(this.initialDate, obj.initialDate) && Objects.equals(this.finalHour, obj.finalHour)
                && Objects.equals(this.initialHour, obj.initialHour));
    }

    /**
     * Method toString: returns a description of an availability
     *
     * @return description of an availability
     */
    @Override
    public String toString() {
        String str = "Date (initial/final): " + initialDate.toString() + " - " + finalDate.toString() + "Time (initial/final):" + initialHour.toString() + "-" + finalHour.toString();
        return str;
    }
}
