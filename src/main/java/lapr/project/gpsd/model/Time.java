/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class Time implements Comparable<Time> {

    /**
     * hour of time
     */
    private int hour;

    /**
     * minutes of time
     */
    private int minutes;

    /**
     * Constructor
     *
     * @param time: string of time
     */
    public Time(String time) {
        String[] temp = time.split(":");
        if (temp.length != 2) {
            throw new IllegalArgumentException("The schedule is invalid");
        }
        int hour = Integer.parseInt(temp[0].trim());
        int minute = Integer.parseInt(temp[1].trim());
        setTime(hour, minute);
    }
    
    
    /**
     * Construcotr
     *
     * @param horas hour of time
     * @param minutos minute of time
     */
    public Time(int horas, int minutos) {
        setTime(horas, minutos);
    }

    /**
     * Change the hour and the minutes of time
     *
     * @param hour new hour of time
     * @param minutes new minutes of time
     */
    public void setTime(int hour, int minutes) {
        if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("The schedule is invalid");
        }
        this.hour = hour;
        this.minutes = minutes;
    }

    /**
     * Returns time
     *
     * @return time
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }

    /**
     * Comparate the time received with the other time received
     *
     * @param otherTime time to be compared
     * @return value 0 if otherTime received is equal to the time; value -1 if the other
     * time is after the time; value 1 if the ohter time is before the time
     * ao tempo.
     */
    @Override
    public int compareTo(Time otherTime) {
        return (otherTime.isAfter(this)) ? -1 : (isAfter(otherTime)) ? 1 : 0;
    }

    /**
     * Returns true if the time is after the other time received 
     *
     * @param otherTime other time to be compared
     * @return true if the time is after the other time received 
     */
    public boolean isAfter(Time otherTime) {
        return toSeconds() > otherTime.toSeconds();
    }

    /**
     * Returns the time in seconds
     *
     * @return time in seconds
     */
    public int toSeconds() {
        return hour * 3600 + minutes * 60;
    }
    
    /**
     * Returns a time from seconds
     * 
     * @param seconds seconds
     * @return the time from the seconds
     */
    public static Time fromSecondsToTime(int seconds) {
        int h= seconds/3600;
        int m= (seconds-h*3600)/60;
        return new Time(h,m);
    }
    
    /**
     * Return the current time
     *
     * @return current time
     */
    public static Time currentTime() {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        return new Time(hour, minute);
    }

    public Time addTime(int dur) {
        int newHour=this.hour;
        int newMinute=this.minutes+dur;
        if (newMinute>59) {
            newHour+=newMinute/60;
            newMinute%=60;
            if (newHour>23) {
                newHour%=24;
            }
        }
        return new Time(newHour, newMinute);
    }

    /**
     * Comparates two objects of Time and
     * verify if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
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
        Time obj = (Time) o;
        return (Objects.equals(this.hour, obj.hour) && Objects.equals(this.minutes, obj.minutes));
    }


}
