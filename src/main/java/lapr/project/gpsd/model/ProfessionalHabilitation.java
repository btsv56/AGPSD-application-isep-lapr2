/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

/**
 *
 * @author User
 */
public class ProfessionalHabilitation {

    /**
     * Designation of Professional Habilitation
     */
    private String designation;
    /**
     * Degree of Professional Habilitation
     */
    private int degree;
    /**
     * Classification of Professional Habilitation
     */
    private String classification;

    /**
     * Constructor of Professional Habilitation
     *
     * @param designation designation of Professional Habilitation
     * @param degree degree of Professional Habilitation
     * @param classification classification of Professional Habilitation
     */
    public ProfessionalHabilitation(String designation, int degree, String classification) {
        this.designation = designation;
        this.degree = degree;
        this.classification = classification;
    }

    /**
     * Method that returns designation of professional habilitation
     *
     * @return designation of professional habilitation
     */

    public String getDesignation() {
        return designation;
    }

    /**
     * Method that returns degree of professional habilitation
     *
     * @return degree of professional habilitation
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Method that returns classification of professional habilitation
     *
     * @return classification of professional habilitation
     */
    public String getClassification() {
        return classification;
    }
}
