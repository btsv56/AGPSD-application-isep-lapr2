/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class UsersPaper
{
    private String m_strPaper;
    private String m_strDescription;
    
    public UsersPaper(String strPaper)
    {
        if ( (strPaper == null) || (strPaper.isEmpty()))
            throw new IllegalArgumentException("The argument can't be null or empty");
        
        this.m_strPaper = strPaper;
        this.m_strDescription = strPaper;
    }
    
    public UsersPaper(String strPaper, String strDescription)
    {
        if ( (strPaper == null) || (strDescription == null) || (strPaper.isEmpty())|| (strDescription.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos não pode ser nulo ou vazio.");
        
        this.m_strPaper = strPaper;
        this.m_strDescription = strDescription;
    }
    
    public String getPaper()
    {
        return this.m_strPaper;
    }
    
    public String getDescription()
    {
        return this.m_strDescription;
    }

    public boolean hasId(String strId)
    {
        return this.m_strPaper.equals(strId);
    }
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strPaper);
        return hash;
    }
    
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
        UsersPaper obj = (UsersPaper) o;
        return Objects.equals(m_strPaper, obj.m_strPaper);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.m_strPaper, this.m_strDescription);
    }
}
