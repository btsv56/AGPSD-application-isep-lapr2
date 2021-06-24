/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lapr.project.records.AvailabilityList;

/**
 *
 * @author paulomaio
 */
public class UserRecords
{
    private Set<User> m_lstUsers = new HashSet<User>();
    
    
    public User newUser(String strName, String strEmail, String strPassword)
    {
        return new User(strName,strEmail,strPassword);
    }
    
    public boolean addUser(User utlz)
    {
        if (utlz != null)
            return this.m_lstUsers.add(utlz);
        return false;
    }
    
    public boolean removeUser(User utlz)
    {
        if (utlz != null)
            return this.m_lstUsers.remove(utlz);
        return false;
    }
    
    public User searchUser(String strId)
    {
        for(User utlz: this.m_lstUsers)
        {
            if(utlz.hasId(strId))
                return utlz;
        }
        return null;
    }
    
    public boolean hasUser(String strId)
    {
        User utlz = searchUser(strId);
        if (utlz != null)
            return this.m_lstUsers.contains(utlz);
        return false;
    }
    
    public boolean hasUser(User utlz)
    {
        return this.m_lstUsers.contains(utlz);
    }
    
    /**
     * Comparates two objects of UserRecords and
     * verify if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        UserRecords obj = (UserRecords) o;
        return (Objects.equals(this.m_lstUsers, obj.m_lstUsers));
    }
}
