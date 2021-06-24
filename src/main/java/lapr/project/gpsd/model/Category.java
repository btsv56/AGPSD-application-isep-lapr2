/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class Category
{
    /**
     * Category's id
     */
    private String m_strID;
    /**
     * category's description
     */
    private String m_strDescription;
            
    
    /**
     * Contructor
     * 
     * @param strCodigo category's id
     * @param strDescricao category's description
     */
    public Category(String strCodigo, String strDescricao)
    {
        if ( (strCodigo == null) || (strDescricao == null) ||
                (strCodigo.isEmpty())|| (strDescricao.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty");
        
        this.m_strID = strCodigo;
        this.m_strDescription = strDescricao;
    }
    
    /**
     * Verifies if a category has an id
     * 
     * @param strId id to be searched
     * @return 
     */
    public boolean hasId(String strId)
    {
        return this.getM_strID().equalsIgnoreCase(strId);
    }
    
    /**
     * Returns the code of a category
     * 
     * @return code of a category
     */
    public String getCode()
    {
        return this.getM_strID();
    }
   
    
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getM_strID());
        return hash;
    }
    
    /**
     * Indicates if two objects of category are equal
     * 
     * @param o other object
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
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
        Category obj = (Category) o;
        return (Objects.equals(getM_strID(), obj.getM_strID()));
    }
    
    /**
     * Method toString
     * 
     * @return description of a category
     */
    @Override
    public String toString()
    {
        return String.format("%s - %s ", this.getM_strID(), this.getM_strDescription());
    }

    /**
     * @return the m_strID
     */
    public String getM_strID() {
        return m_strID;
    }

    /**
     * @return the m_strDescription
     */
    public String getM_strDescription() {
        return m_strDescription;
    }

}
