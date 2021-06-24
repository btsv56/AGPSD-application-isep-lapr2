package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Evaluation;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.RateList;
import lapr.project.records.ServiceProviderRecords;

public class EvaluateServiceProviderController {

    /**
     * Record of the service providers in the company
     */
    private final ServiceProviderRecords servProvRecords;
    /**
     * list containing all service providers
     */
    private List<ServiceProvider> servProvList;
    /**
     * Service provider gotten by email
     */
    private ServiceProvider servProvider;
    /**
     * array containing the mean rates of all service providers
     */
    private double[] meanRateList;
    /**
     * mean rate of the population
     */
    private double meanRatePopulation;

    /**
     * constrcutor
     *
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     */
    public EvaluateServiceProviderController() throws UnsupportedEncodingException, UnsupportedEncodingException, FileNotFoundException {
        this.servProvRecords = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
    }

    /**
     * accesses service provider records and returns a list of the service
     * providers in the company
     *
     * @return list of service provider
     */
    public List<ServiceProvider> getServiceProviders() {
        this.servProvList = servProvRecords.getServiceProviderList();
        return new ArrayList<>(this.servProvList);
    }

    /**
     * sets the service provider to be worked with
     *
     * @param servProvider Service Provider
     * @return boolean regarding the success
     */
    public boolean setServProv(ServiceProvider servProvider) {
        this.servProvider = servProvider;
        return true;
    }

    /**
     * calculates the mean rate of the population
     *
     * @return mean rate of the population
     */
    public double calculateMeanRate() {
        int j = 0;
        double total = 0;
        for (ServiceProvider servProv : this.servProvList) {
            RateList rateList = servProv.getRateList();
            total += rateList.getMeanRate();
            j++;
        }
        if (j != 0) {
            this.meanRatePopulation = (double) total / j;
        }
        return meanRatePopulation;
    }

    /**
     * calculates the standard deviation of the population of service providers
     * by using the general formula to calculate the standard deiviation
     *
     * @return the standard deviation of the population
     */
    public double calculateStandardDeviationAll() {
        double sum = 0;
        double[] newArray = new double[this.servProvList.size()];
        this.meanRateList = new double[this.servProvList.size()];
        int j = 0;
        for (ServiceProvider servProv : this.servProvList) {
            RateList rateList = servProv.getRateList();
            meanRateList[j] += rateList.getMeanRate();
            j++;
        }
        for (int k = 0; k < meanRateList.length; k++) {
            newArray[k] = (Math.pow(meanRateList[k] - this.meanRatePopulation, 2));
            sum = sum + newArray[k];
        }
        double squaredDiffMean = (sum) / (meanRateList.length);
        double standardDev = (Math.sqrt(squaredDiffMean));
        return standardDev;
    }

    /**
     * calculates the standard deviation of a single service provider by making
     * the absolute value of the difference between the provider's mean rate and
     * the population's mean reate
     *
     * @return the standard deviation of a single service provider
     */
    public double calculateStandardDeviationSP() {
        double deviation = Math.abs(servProvider.getRateList().getMeanRate() - this.meanRatePopulation);
        return deviation;
    }

    /**
     * labels the service provide according to it's Mean Rate. this value is
     * compared with the arithmetic sum or subtraction between the mean rate of
     * the population and the standard deviation
     *
     * @return string with the label attributed
     */
    public String labelSP() {
        String evaluation = "";
        double standardDeviation = calculateStandardDeviationAll();
        double meanRate = this.servProvider.getRateList().getMeanRate();

        if (meanRate < (this.meanRatePopulation - standardDeviation)) {
            System.out.println(this.meanRatePopulation - standardDeviation);
            System.out.println(meanRate);
            evaluation = Constants.WORST;
        } else {
            if ((this.meanRatePopulation - standardDeviation) <= meanRate && (this.meanRatePopulation + standardDeviation) >= meanRate) {
                evaluation = Constants.REGULAR;
            } else {
                if ((this.meanRatePopulation + standardDeviation) < meanRate) {
                    evaluation = Constants.OUTSANDING;
                }
            }
        }
        return evaluation;
    }

    /**
     * registers the evaluation of the service provider
     *
     * @param evaluation evaluation
     * @param providerMeanRating mean rating
     * @return boolean regarding the success of the operation
     */
    public boolean registerEvaluation(String evaluation, double providerMeanRating) {
        Evaluation eva = new Evaluation(evaluation, providerMeanRating);
        if (this.servProvider.registerEvaluation(eva)) {
            return true;
        } else {
            return false;
        }
    }

}
