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
public class AcademicHabilitation {

    /**
     * Description of the academic habilitation
     */
    private String description;

    /**
     * Constructor of the Academic Habilitation
     *
     * @param description descriptionof the academic habilitation
     */
    public AcademicHabilitation(String description) {
        this.description = description;
    }

    /**
     * Method that returns description of the academic habilitation
     *
     * @return description of the academic habilitation
     */
    public String getDescription() {
        return description;
    }
}
