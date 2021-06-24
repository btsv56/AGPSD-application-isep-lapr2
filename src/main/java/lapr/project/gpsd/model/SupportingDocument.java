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
public class SupportingDocument {

    /**
     * Document of Supporting Document
     */
    private String doc;

    /**
     * Constructor of Supporting Document
     *
     * @param doc Document of Supporting Document
     */
    public SupportingDocument(String doc) {
        this.doc = doc;
    }

    /**
     * Method taht returns document
     *
     * @return document
     */
    public String getDoc() {
        return doc;
    }

    /**
     * Method that set Document
     *
     * @param doc document
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }

}
