/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.util.List;
import lapr.project.autorization.model.UsersPaper;

/**
 *
 * @author paulomaio
 */
public class AutenticationController
{
    private AppGPSD m_oApp;
    
    public AutenticationController() 
    {
        this.m_oApp = AppGPSD.getInstance();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
        return this.m_oApp.doLogin(strId, strPwd);
    }
    
    public List<UsersPaper> getUserPapers()
    {
        if (this.m_oApp.getCurrentSession().isLoggedIn())
        {
            return this.m_oApp.getCurrentSession().getUserPapers();
        }
        return null;
    }

    public void doLogout()
    {
        this.m_oApp.doLogout();
    }
}
