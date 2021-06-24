/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Issue;
import lapr.project.gpsd.model.ServiceOrder;

/**
 *
 * @author marta
 */
public class IssueRecords {
   
    /**
     * List of issues.
     */
    private List<Issue> irl = new ArrayList<>();
    
    /**
     * Creates a new issue.
     * @param or
     * @param desc
     * @param troublest
     * @return 
     */
    public Issue newIssue(ServiceOrder or, String desc, String troublest){
        Issue i = new Issue(or, desc, troublest);
        return i;
    }
    
    /**
     * Registers an issue received by parameter. First it validates the issue 
     * and if the issue is valid, it adds the issue to the list of issues.
     * 
     * @param issue
     * @return 
     */
    public boolean registerIssue(Issue issue){
        if(validatesIssue(issue)){
            return addIssue(issue);
        }
        return false;
    }
    
    /**
     * Checks if the issue received by parameter already exists on the list of issues.
     * @param i
     * @return 
     */ 
    public boolean validatesIssue(Issue i){
        for( Issue is : this.irl){
            if(i.equals(is)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Adds issue received by parameter to the list of issues.
     * @param i
     * @return true if it adds the issue to the list, false if it doesn't add
     */
    public boolean addIssue(Issue i){
        return this.irl.add(i);
    }
}
