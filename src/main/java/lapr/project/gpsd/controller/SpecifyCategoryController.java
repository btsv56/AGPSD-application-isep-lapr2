/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.records.CategoryRecords;


public class SpecifyCategoryController
{
    /**
     * Company
     */
    private Company m_oCompany;
    /**
     * Category
     */
    private Category m_oCategory;
    /**
     * Category Records
     */
    private CategoryRecords m_oCategoryRecords;
    /**
     * Constructor
     */
    public SpecifyCategoryController()
    {
        if(!AppGPSD.getInstance().getCurrentSession().isLoggedInWithPaper(Constants.PAPER_ADMINISTRATOR))
            throw new IllegalStateException("User not allowed");
        this.m_oCompany = AppGPSD.getInstance().getCompany();
        m_oCategoryRecords=m_oCompany.getCategoryRecords();
    }
    
    /**
     * Create a new category
     * 
     * @param strCodigo code
     * @param strDescricao descritpion
     * @return 
     */
    public boolean newCategory(String strCodigo, String strDescricao)
    {
//        try
//        {
        
            this.m_oCategory = this.m_oCategoryRecords.newCategory(strCodigo, strDescricao);
            return this.m_oCategoryRecords.validateCategory(this.m_oCategory);
            
//        }
//        catch(RuntimeException ex)
//        {
//            Logger.getLogger(SpecifyCategoryUI.class.getName()).log(Level.SEVERE, null, ex);
//            this.m_oCategory = null;
//            return false;
//        }
    }
   
    /**
     * Register category
     * 
     * @return boolean that indicates if the new category has been registered
     */
    public boolean registerCategory()
    {
        return this.m_oCategoryRecords.registerCategory(this.m_oCategory);
    }

    /**
     * Returns a description of a category
     * 
     * @return description of a category
     */
    public String getCategoryString()
    {
        return this.m_oCategory.toString();
    }
}
