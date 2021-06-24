package lapr.project.gpsd.model;

public class Evaluation {

    /**
     * Evaluation of the Service Provider
     */
    private String evaluation;
    /**
     * Mean Rating of the Service Provider
     */
    private double meanRating;

    /**
     * Constructs a new instance of Evaluation, with the evaluation and mean
     * rating of a service provider
     *
     * @param evaluation evaluation of the service provider
     * @param meanRating mean rating of the service provider
     */
    public Evaluation(String evaluation, double meanRating) {
        this.evaluation = evaluation;
        this.meanRating = meanRating;
    }

    /**
     * returns the mean rating of the service Provider
     *
     * @return mean rating of service provider
     */
    public double getMeanRating() {
        return meanRating;
    }

    /**
     * Returns the evaluation of a service Provider
     *
     * @return evaluation of service provider
     */
    public String getEvaluation() {
        return evaluation;
    }

    /**
     * sets the evaluation of the service provider
     * ("Worst","Regular","Outstanding")
     *
     * @param evaluation evaluation of service provider
     * @return evaluation
     */
    public boolean setEvaluation(String evaluation) {
        this.evaluation = evaluation;
        return true;
    }

    /**
     * sets the mean rating of the service provider double(1-5)
     *
     * @param meanRating mean rating of service provider
     * @return mean rating
     */
    public boolean setMeanRating(double meanRating) {
        this.meanRating = meanRating;
        return true;
    }
}
