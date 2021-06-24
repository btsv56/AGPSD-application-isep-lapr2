/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.util.List;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Issue;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.IssueRecords;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceProviderRecords;

/**
 *
 * @author marta
 */
public class CompleteServiceController {

    private Company company;
    private ServiceProviderRecords spr;
    private ServiceProvider sp;
    private ServiceOrderRecords sor;
    private List<ServiceOrder> ol ;
    private ServiceOrder or;
    private IssueRecords ir;
    private Issue i;
    
    public CompleteServiceController() throws FileNotFoundException {
        if (!AppGPSD.getInstance().getCurrentSession().isLoggedInWithPaper(Constants.PAPER_SERVICE_PROVIDER)) {
            throw new IllegalStateException("User not allowed");
        }
        this.company = AppGPSD.getInstance().getCompany();
    }
    
    public List<ServiceOrder> newCompleteService(){
        String email = AppGPSD.getInstance().getCurrentSession().getEmailUser();
        spr = company.getServiceProviderRecords();
        sp = spr.getServiceProvider(email);
        sor = company.getServiceOrderRecords();
        return ol = sor.getUnfinishedServiceOrdersBySP(sp);
    }
    
    public ServiceOrder getServiceOrderByNum(int num){
        this.or = sor.getServiceOrderByNum(num);
        return or;
    }
    
    public void setServiceOrderStatus(ServiceOrder order, String status){
        order.setExecutionState(status);
    }
    
    public Issue newIssue(ServiceOrder order, String desc, String troublest){
        ir = company.getIssueRecords();
        i = ir.newIssue(order, desc, troublest);
        return i;
    }
    
    public boolean registersIssue(Issue issue){
        return ir.registerIssue(issue);
    }
}
