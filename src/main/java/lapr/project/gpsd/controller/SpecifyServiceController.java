/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ServiceRecords;
import lapr.project.records.ServiceTypesRecords;
import lapr.project.gpsd.model.Service;

/**
 *
 * @author paulomaio
 */
public class SpecifyServiceController {

    private Company m_oCompany;
    private Service m_oService;
    private ServiceType servType;
    private ServiceTypesRecords str;
    private CategoryRecords catr;
    private ServiceRecords sr;

    public SpecifyServiceController() {
        if (!AppGPSD.getInstance().getCurrentSession().isLoggedInWithPaper(Constants.PAPER_ADMINISTRATOR)) {
            throw new IllegalStateException("User not allowed");
        }
        this.m_oCompany = AppGPSD.getInstance().getCompany();
    }

    public List<ServiceType> getServiceTypes() {
        this.str = m_oCompany.getServiceTypesRecords();
        return str.getServiceTypes();
    }

    public void setServiceType(String idType) {
        this.servType = str.getServiceTypeByID(idType);
    }

    /**
     * Returns the list of the existing categories.
     *
     * @return
     */
    public List<Category> getCategories() {
        this.catr = m_oCompany.getCategoryRecords();
        return catr.getCategories();
    }

    /**
     * Creates a new service.
     *
     * @param strId
     * @param strBriefDescription
     * @param strCompleteDescription
     * @param costHour
     * @param categoriaId
     * @return true if the service has other attributes or false if it doesn't
     * have other attributes
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     */
    public boolean newService(String strId, String strBriefDescription, String strCompleteDescription, double costHour, String categoriaId) throws InstantiationException,
            NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        boolean bAtrbs = false;
        Category cat = this.catr.getCategoryById(categoriaId);
        this.m_oService = this.servType.newService(strId, strBriefDescription, strCompleteDescription, costHour, cat);
        if (m_oService.validates() == true) {
            bAtrbs = m_oService.hasOtherAttributes();
        }
        return bAtrbs;
    }

    public String getOtherAttributes() {
        return m_oService.getOtherAttributes();
    }

    public void setAdditionalData(int data) {
       m_oService.setAdditionalData(data);  
    }

    /**
     * Validates the service and shows the information about it.
     */
    public String validates() {
        this.sr = this.m_oCompany.getServiceRecords();
        if(this.sr.validatesService(this.m_oService)){
            return String.format(m_oService.toString());
        }
        return String.format("Invalid service.");
    }

    /**
     * Registers the service in service records.
     *
     * @return
     */
    public boolean registersService() {
        return this.sr.registersService(this.m_oService);
    }

}
