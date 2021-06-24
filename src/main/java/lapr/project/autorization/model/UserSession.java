/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class UserSession
{
    private User m_oUser = null;
    
    public UserSession(User oUser)
    {
        if (oUser == null)
            throw new IllegalArgumentException("The argument can't be null");
        this.m_oUser = oUser;
    }
    
    public void doLogout()
    {
        this.m_oUser = null;
    }
    
    public boolean isLoggedIn()
    {
        return this.m_oUser != null;
    }
    
    public boolean isLoggedInWithPaper(String strPaper)
    {
        if (isLoggedIn())
        {
            return this.m_oUser.hasPaper(strPaper);
        }
        return false;
    }
    
    public String getUserName()
    {
        if (isLoggedIn())
            return this.m_oUser.getName();
        return null;
    }
    
    public String getIdUser()
    {
        if (isLoggedIn())
            return this.m_oUser.getId();
        return null;
    }
    
    public String getEmailUser()
    {
        if (isLoggedIn())
            return this.m_oUser.getEmail();
        return null;
    }
    
    public List<UsersPaper> getUserPapers()
    {
        return this.m_oUser.getPapers();
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
        UserSession obj = (UserSession) o;
        return Objects.equals(this.m_oUser, obj.m_oUser);
    }
    
    @Override
    public String toString() {
        return this.m_oUser.getName()+", "+this.m_oUser.getEmail();
    }
    
}
