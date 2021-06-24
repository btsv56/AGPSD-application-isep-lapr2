package lapr.project.gpsd.model;

import java.time.LocalDate;

public class ServiceSchedule {

    private String state;
    private LocalDate date;
    private Time hour;

    public ServiceSchedule(String state, LocalDate date, Time hour) {
        if (!state.equals(null) && date != null && hour != null) {
            this.state = state;
            this.date = date;
            this.hour = hour;
        }
    }

    public void setStateSchedule(String stateImp) {
        this.state = stateImp;
    }

    public LocalDate getDate() {
        return this.date;
    }
    
    public Time getHour() {
        return this.hour;
    }

    @Override
    public String toString(){
        return String.format("State: %s Date: %s Hour: %s", this.state, 
                this.date.toString(), this.hour);
    }
}
