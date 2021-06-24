/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorization.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class UserPapersRecords
{
    private Set<UsersPaper> m_lstPapers = new HashSet<UsersPaper>();
    
    public UsersPaper newUserPaper(String strPaper)
    {
        return new UsersPaper(strPaper);
    }
    
    public UsersPaper newUserPaper(String strPaper, String strDescricao)
    {
        return new UsersPaper(strPaper,strDescricao);
    }
    
    public boolean addPaper(UsersPaper papel)
    {
        if (papel != null)
            return this.m_lstPapers.add(papel);
        return false;
    }
    
    public boolean removePaper(UsersPaper papel)
    {
        if (papel != null)
            return this.m_lstPapers.remove(papel);
        return false;
    }
    
    public UsersPaper searchPaper(String strPaper)
    {
        for(UsersPaper p: this.m_lstPapers)
        {
            if(p.hasId(strPaper))
                return p;
        }
        return null;
    }
    
    public boolean hasPaper(String strPaper)
    {
        UsersPaper paper = searchPaper(strPaper);
        if (paper != null)
            return this.m_lstPapers.contains(paper);
        return false;
    }
    
    public boolean hasPaper(UsersPaper paper)
    {
        return this.m_lstPapers.contains(paper);
    }
}
