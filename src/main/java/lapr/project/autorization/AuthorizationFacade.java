/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization;

import java.util.Objects;
import lapr.project.autorization.model.UsersPaper;
import lapr.project.autorization.model.UserPapersRecords;
import lapr.project.autorization.model.UserRecords;
import lapr.project.autorization.model.UserSession;
import lapr.project.autorization.model.User;
import lapr.project.gpsd.model.OtherCost;

/**
 *
 * @author paulomaio
 */
public class AuthorizationFacade
{
    private UserSession m_oSession = null;
    
    private final UserPapersRecords m_pPapers = new UserPapersRecords();
    private final UserRecords m_oUsers = new UserRecords();
    
    public boolean registerUserPaper(String strPaper)
    {
        UsersPaper paper = this.m_pPapers.newUserPaper(strPaper);
        return this.m_pPapers.addPaper(paper);
    }
    
    public boolean registerUserPaper(String strPaper, String strDescription)
    {
        UsersPaper paper = this.m_pPapers.newUserPaper(strPaper,strDescription);
        return this.m_pPapers.addPaper(paper);
    }
    
    public boolean registerUser(String strName, String strEmail, String strPassword)
    {
        User user = this.m_oUsers.newUser(strName,strEmail,strPassword);
        return this.m_oUsers.addUser(user);
    }
    
    public boolean registerUserWithPaper(String strName, String strEmail, String strPassword, String strPaper)
    {
        UsersPaper paper = this.m_pPapers.searchPaper(strPaper);
        User user = this.m_oUsers.newUser(strName,strEmail,strPassword);
        user.addPaper(paper);
        return this.m_oUsers.addUser(user);
    }
    
    public boolean registerUserWithPapers(String strName, String strEmail, String strPassword, String[] papers)
    {
        User user = this.m_oUsers.newUser(strName,strEmail,strPassword);
        for (String strPaper: papers)
        {
            UsersPaper paper = this.m_pPapers.searchPaper(strPaper);
            user.addPaper(paper);
        }
        
        return this.m_oUsers.addUser(user);
    }
    
    public boolean existUser(String strId)
    {
        return this.m_oUsers.hasUser(strId);
    }
    
    
    public UserSession doLogin(String strId, String strPwd)
    {
        User user = this.m_oUsers.searchUser(strId);
        if (user != null)
        {
            if (user.hasPassword(strPwd)){
                this.m_oSession = new UserSession(user);
            }
        }
        return getCurrentSession();
    }
    
    public UserSession getCurrentSession()
    {
        return this.m_oSession;
    }
    
    public UserRecords getUserRecords() {
        return this.m_oUsers;
    }
    
    public void doLogout()
    {
        if (this.m_oSession != null)
            this.m_oSession.doLogout();
        this.m_oSession = null;
    }
    
    /**
     * Comparates two objects of AuthorizationFacade description and
     * verify if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
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
        AuthorizationFacade obj = (AuthorizationFacade) o;
        return (Objects.equals(this.m_oSession, obj.m_oSession) && Objects.equals(this.m_oUsers, obj.m_oUsers) && (Objects.equals(this.m_pPapers, obj.m_pPapers)));
    }
}
