/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timer;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;

import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.ServiceProvidingRequest;

/**
 *
 * @author lulu
 */
public class AssociateSPtoRequestTimer {
    
    Timer timer;
    
    /**
     * Constructor that starts the timer, using the request method.
     * @param minutes int
     * @param method String (Constant)
     */
    public AssociateSPtoRequestTimer (int minutes, String method) {
        timer = new Timer();
        if (method.equals(Constants.ASS_TASK_METHOD_FCFS)) {
            timer.schedule(new AssociateSPtoRequestFCFSTask(), minutes * 1000, minutes * 1000);
        } else {
            timer.schedule(new AssociateSPtoRequestRSTask(), minutes * 1000, minutes * 1000);
        }
    }
    
    /**
     * First-Come-First-Come association method
     */
    class AssociateSPtoRequestFCFSTask extends TimerTask {
        
        //int tries=10;
        public void run() {
            List<ServiceProvidingRequest> unassList=AppGPSD.getInstance().getCompany().getAssociationRecords().getUnassociatedRequests();
            int requestNum=unassList.size();
            try {
                if (requestNum>0) {
                    AssociateTaskFCFS task=new AssociateTaskFCFS();
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Random-Scheduling association method
     */
    class AssociateSPtoRequestRSTask extends TimerTask {

        //int tries=10;
        public void run() {
            List<ServiceProvidingRequest> unassList=AppGPSD.getInstance().getCompany().getAssociationRecords().getUnassociatedRequests();
            int requestNum=unassList.size();
            try {
                if (requestNum>0) {
                    AssociateTaskRS task=new AssociateTaskRS();
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
