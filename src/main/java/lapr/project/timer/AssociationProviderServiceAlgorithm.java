/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.timer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.ActsIn;
import lapr.project.gpsd.model.AssociationSPtoRequest;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequest;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;
import lapr.project.gpsd.model.Time;
import lapr.project.gpsd.model.TimePreference;
import lapr.project.records.AvailabilityList;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.ServiceScheduleRecords;

/**
 *
 * @author lulu
 */
public class AssociationProviderServiceAlgorithm {

    private AppGPSD app=AppGPSD.getInstance();
    private AssociationProviderRequestRecords assRcds=app.getCompany().getAssociationRecords();
    private List<ServiceSchedule> ssList= new ArrayList<>();
    private Company company;
    private ServiceScheduleRecords ssr;
        
    /**
     * Constructor
     */
    public AssociationProviderServiceAlgorithm() {
        company = app.getCompany();
        ssr = company.getServiceScheduleRecords();
    }

    /**
     * Associates a request to an available Service Provider (Area of operations, categories provided, availability,
     * evaluation, distance and alphabetical order are taken into account when associating)
     * 
     * @param request ServiceProvidingRequest
     * @return the result of assRcds.addAssociation, or false if there's no Service Provider available
     */
    public boolean associate(ServiceProvidingRequest request) {
        ssr = this.company.getServiceScheduleRecords();
        List<ServiceProvider> spList=new ArrayList<>();
        List<ServiceProvidingRequestDescription> descs = request.getDescriptionList();
        List<ServiceProvider> spTotalList = app.getCompany().getServiceProviderRecords().getServiceProviderList();
        TimePreference prefFin=null;
        for (ServiceProvider sp1 : spTotalList) {
            List<Category> spCats = sp1.getCategoryList();
            for (ServiceProvidingRequestDescription desc : descs) {
                Category cat = desc.getService().getCategory();
                if (spCats.contains(cat)) {
                    spList.add(sp1);
                }
            }
        }
        
        List<ServiceProvider> spArea=new ArrayList<>();
        if (!spList.isEmpty()) {
            PostalCode pcode=request.getPostalAddress().getPostalCode();
            for (ServiceProvider sp : spList) {
                List<ActsIn> acts = sp.getGeoArea().getAct();
                for (ActsIn act : acts) {
                    PostalCode actCode=act.getPostalCode();
                    if (actCode.equals(pcode)) {
                        spArea.add(sp);
                    }
                }
            }
        }
        
        List<ServiceProvider> spAvail=new ArrayList<>();
        if (!spArea.isEmpty()) {
            for (ServiceProvider sp : spList) {
                for (TimePreference pref : request.getTimePreferenceList()) {
                    for (Availability avail : sp.getAvailabilityList().getAvailabilityList()) {
                        if (pref.compareTo(avail) == 1) {
                            if (pref.getHour().addTime(request.getMaxDuration()).compareTo(avail.getFinalHour())!=1) {
                                String period=avail.getPeriod();
                                if (!period.equals("Everyday|")) {
                                    boolean flag=false;
                                    String[] days = period.split("\\|");
                                    String prefDay=pref.getDate().getDayOfWeek().toString();
                                    for (int i=0;i<days.length;i++) {
                                        if (days[i].trim().equalsIgnoreCase(prefDay)) {
                                            flag=true;
                                        }
                                    }
                                    if (flag) {
                                        prefFin=pref;
                                        spAvail.add(sp);
                                    }
                                } else {
                                    prefFin=pref;
                                    spAvail.add(sp);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if (spAvail.size()>1) {
            orderSPList(spAvail, request);
            LocalDate date = prefFin.getDate();
            Time hour = prefFin.getHour();
            ServiceSchedule ss = new ServiceSchedule("Not Defined", date, hour);
            ssr.addSStolist(ss);
            request.removeTimePreference(prefFin);
            System.out.println(ss.toString());
            return assRcds.addAssociation(spAvail.get(0), request);
        } else if (spAvail.size() == 1) {
            LocalDate date = prefFin.getDate();
            Time hour = prefFin.getHour();
            ServiceSchedule ss = new ServiceSchedule("Not Defined", date, hour);
            ssr.addSStolist(ss);
            request.removeTimePreference(prefFin);
            return assRcds.addAssociation(spAvail.get(0), request);
        }
        return false;
    }
    
    /**
     * Orders the list of available providers by evaluation, distance and finally alphabetical order
     * 
     * @param spAvail List of available providers
     * @param request ServiceProvidingRequest
     */
    public void orderSPList(List<ServiceProvider> spAvail, ServiceProvidingRequest request) {
        for (int i=0; i<spAvail.size()-1; i++) {
            ServiceProvider sp1=spAvail.get(i);
            for (int j=i+1; j<spAvail.size(); j++) {
                ServiceProvider sp2=spAvail.get(j);
                if (sp1.compareToEval(sp2)==-1) {
                    ServiceProvider temp = sp2;
                    spAvail.set(j,sp1);
                    spAvail.set(i,temp);
                } else if (sp1.compareToEval(sp2)==0) {
                    if (sp1.compareToDist(sp2, request.getPostalAddress().getPostalCode().getLatitude(), request.getPostalAddress().getPostalCode().getLongitude())==-1) {
                        ServiceProvider temp = sp2;
                        spAvail.set(j,sp1);
                        spAvail.set(i,temp);
                    } else if (sp1.compareToEval(sp2)==0) {
                        if (sp1.compareToName(sp2)==0) {
                            ServiceProvider temp = sp2;
                            spAvail.set(j,sp1);
                            spAvail.set(i,temp);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Returns the ssList
     * 
     * @return new ArrayList (ssList) 
     */
    public List<ServiceSchedule> getListServiceSchedule () {
        return new ArrayList<>(ssList);
    }
}
