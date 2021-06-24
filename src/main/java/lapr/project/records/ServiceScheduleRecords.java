package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.ServiceSchedule;

/**
 *
 * @author Andre
 */
public class ServiceScheduleRecords {
    
    List<ServiceSchedule> ssList= new ArrayList<>();
    
    /**
     * 
     * Constructor
     * 
     */
    public ServiceScheduleRecords() {
        List<ServiceSchedule> ssList = new ArrayList<>();
    }
    
    
    
    /**
     * 
     * Adds service schedule to records list
     * @param ss
     * @return boolean
     */
    public boolean addSStolist (ServiceSchedule ss) {
        return this.ssList.add(ss);
    }
    
    
    /**
     * 
     * @return  List of Service Schedules
     */
    public List<ServiceSchedule> getServiceScheduleList () {
        return ssList;
    }
    
    /**
     * Returns ServiceSchedule of the slot num
     * 
     * @param num 
     * @return ServiceSchedule
     * 
     */
    public ServiceSchedule getSSfromServiceScheduleList (int num) {
        return ssList.get(num);
    }
    
    public void removeSSfromList (int i) {
        ssList.remove(i);
    }
    
    
    
    
}
