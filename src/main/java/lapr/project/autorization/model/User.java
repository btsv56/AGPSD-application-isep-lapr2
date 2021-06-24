/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class User
{
    private String m_strName;
    private String m_strEmail;
    private String m_strPassword; // Não deveria guardar a password em "plain text"
    private Set<UsersPaper> m_lstPapers = new HashSet<UsersPaper>();
    
    public User(String strName, String strEmail, String strPassword)
    {
    
        if ( (strName == null) || (strEmail == null) || (strPassword == null) || (strName.isEmpty()) || (strEmail.isEmpty()) || (strPassword.isEmpty()))
            throw new IllegalArgumentException("No argument should be null or empty");
        
        this.m_strName = strName;
        this.m_strEmail = strEmail;
        this.m_strPassword = strPassword;
        
    }
    
    public String getPassword() {
        return this.m_strPassword;
    }
    
    public String getId()
    {
        return this.m_strEmail;
    }
    
    public String getName()
    {
        return this.m_strName;
    }
    
    public String getEmail()
    {
        return this.m_strEmail;
    }
    
    public boolean hasId(String strId)
    {
        return this.m_strEmail.equals(strId);
    }
    
    public boolean hasPassword(String strPwd)
    {
        return this.m_strPassword.equals(strPwd);
    }
    
    public boolean addPaper(UsersPaper paper)
    {
        if (paper != null)
            return this.m_lstPapers.add(paper);
        return false;
    }
    
    
    public boolean removePaper(UsersPaper paper)
    {
        if (paper != null)
            return this.m_lstPapers.remove(paper);
        return false;
    }
    
    public boolean hasPaper(UsersPaper paper)
    {
        return this.m_lstPapers.contains(paper);
    }
    
    public boolean hasPaper(String strPapel)
    {
        for(UsersPaper paper: this.m_lstPapers)
        {
            if (paper.hasId(strPapel))
                return true;
        }
        return false;
    }
    
    public List<UsersPaper> getPapers()
    {
        List<UsersPaper> list = new ArrayList<>();
        for(UsersPaper paper: this.m_lstPapers)
            list.add(paper);
        return list;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
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
        User obj = (User) o;
        return Objects.equals(m_strEmail, obj.m_strEmail);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s", this.m_strName, this.m_strEmail);
    }
}
