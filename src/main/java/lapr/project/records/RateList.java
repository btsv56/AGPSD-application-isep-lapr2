/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceProvider;

/**
 *
 * @author Utilizador
 */
public class RateList {

    /**
     * List of rates
     */
    private List<Rate> rateList = new ArrayList<>();

    public List<Rate> getRateList() {
        return new ArrayList<>(rateList);
    }

    /**
     * Creates and returns a new rate
     *
     * @param rate rate of the service provider
     * @return new rate
     */
    public Rate addNewRate(int rate) {
        return new Rate(rate);
    }

    /**
     * Validates and registers a rate
     *
     * @param r rate
     * @return boolean that indicates if the rate was registered or not
     */
    public boolean registerRate(Rate r) {
        if (validateRate(r)) {
            return addRate(r);
        }
        return false;
    }

    /**
     * Validates a rate
     *
     * @param r rate
     * @return boolean that indicates if the rate is valid or not
     */
    private boolean validateRate(Rate r) {
        boolean vef = true;
        if (r == null) {
            vef = false;
        }
        return vef;
    }

    /**
     * Adds a rate to the list of rates
     *
     * @param r rate
     * @return boolean that indicates if the rate was added t the list or not
     */
    private boolean addRate(Rate r) {
        return this.rateList.add(r);
    }

    public double getMeanRate() {
        double total = 0;
        double meanRate = 0;
        for (Rate rate : this.rateList) {
            total += rate.getRate();
        }
        meanRate = total / rateList.size();
//        System.out.println(meanRate);
        return meanRate;
    }

}
