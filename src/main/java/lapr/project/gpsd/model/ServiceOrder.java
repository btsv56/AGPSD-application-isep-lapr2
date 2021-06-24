/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Andre
 */
public class ServiceOrder {

    /**
     * Service provider of the service order.
     */
    private ServiceProvider provider;
    /**
     * Service providing request description of the service order.
     */
    private ServiceProvidingRequestDescription descServ;
    /**
     * Schedule of the service order.
     */
    private ServiceSchedule servSchedule;
    /**
     * Postal address.
     */
    private PostalAddress pAddress;
    /**
     * Client associated to the service order.
     */
    private Client cli;
    /**
     * Emission date
     */
    private LocalDate emissionDate;
    /**
     * Number of the service order.
     */
    private int number;
    /**
     * State of execution for the service order.
     */
    private String executionState = "Not Executed";
    /**
     * Rating state of the provider of the service order.
     */
    private String rateState = "Not Rated";


    /**
     * Constructor
     * @param number
     * @param prov provider
     * @param descServ service providing request description
     * @param ss service schedule
     * @param end postal address
     * @param cli client
     */
    public ServiceOrder(int number, ServiceProvider prov, ServiceProvidingRequestDescription descServ, ServiceSchedule ss, PostalAddress end, Client cli) {
        this.number = number;
        this.provider = prov;
        this.descServ = descServ;
        this.servSchedule = ss;
        this.pAddress = end;
        this.cli = cli;
    }

    
    // gets-----------------------------------
    
    /**
     * Return service provider.
     * 
     * @return the provider
     */
    public ServiceProvider getProvider() {
        return provider;
    }

    /**
     * Return service providing request description.
     * 
     * @return the descServ
     */
    public ServiceProvidingRequestDescription getDescServ() {
        return descServ;
    }

    /**
     * Return service schedule.
     * 
     * @return the servSchedule
     */
    public ServiceSchedule getServSchedule() {
        return servSchedule;
    }

    /**
     * Return postal address.
     * 
     * @return the pAddress
     */
    public PostalAddress getpAddress() {
        return pAddress;
    }

    /**
     * Return client.
     * 
     * @return the cli
     */
    public Client getCli() {
        return cli;
    }

    /**
     * Return emission date.
     * 
     * @return the emissionDate
     */
    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    /**
     * Return the rating state of the provider of the service order.
     * 
     * @return the rateState
     */
    public String getRateState() {
        return rateState;
    }
    
    /**
     * Return execution state.
     * 
     * @return the executionState
     */
    public String getExecutionState() {
        return executionState;
    }

    /**
     * Return number of the order.
     * 
     * @return 
     */
    public int getNumber() {
        return number;
    }

    
 // sets--------------------------------------------------------------------------
    
    /**
     * Changes the provider to the one received by parameter.
     * 
     * @param provider the provider to set
     */
    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    /**
     * Changes the service providing request description to the one received by parameter.
     * 
     * @param descServ the descServ to set
     */
    public void setDescServ(ServiceProvidingRequestDescription descServ) {
        this.descServ = descServ;
    }

    /**
     * Changes the service schedule to the one received by parameter.
     * 
     * @param servSchedule the servSchedule to set
     */
    public void setServSchedule(ServiceSchedule servSchedule) {
        this.servSchedule = servSchedule;
    }

    /**
     * Changes the postal address to the one received by parameter.
     * 
     * @param pAddress the pAddress to set
     */
    public void setpAddress(PostalAddress pAddress) {
        this.pAddress = pAddress;
    }

    /**
     * Changes the client to the one received by parameter.
     * 
     * @param cli the cli to set
     */
    public void setCli(Client cli) {
        this.cli = cli;
    }

    /**
     * Changes the emission date to the one received by parameter.
     * 
     * @param emissionDate the emissionDate to set
     */
    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    /**
     * Changes the number to the one received by parameter.
     * 
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Changes the execution state to the one received by parameter.
     * 
     * @param executionState the executionState to set
     */
    public void setExecutionState(String executionState) {
        this.executionState = executionState;
    }

    /**
     * Changes the rate state of the provider of the service order to the one
     * received by parameter.
     * 
     * @param rateState the rateState to set
     */
    public void setRateState(String rateState) {
        this.rateState = rateState;
    }
    


    /**
     * Checks if the service order has the service provider received by parameter.
     * 
     * @param servProv service provider
     * @return 
     */
    public boolean hasServProv(ServiceProvider servProv) {
        return servProv.equals(this.getProvider());
    }

    /**
     * Checks if the service order has the client received by parameter.
     * @param cli client
     * @return 
     */
    public boolean hasClient(Client cli) {
        return cli.equals(this.getCli());
    }
    
    /**
     * Checks if the service order was executed.
     * @return 
     */
    public boolean isExecuted() {
        return this.executionState.equalsIgnoreCase("Executed");
    }
    
    /**
     * Checks if the service provider of that orser is rated.
     * @return 
     */
    public boolean isNotRated() {
        return this.rateState.equalsIgnoreCase("Not Rated");
    }

    /**
     * Returns textual format of the service order.
     * @return 
     */
    public String toString(){
        return String.format("Service order number: %d%n Service Provider: %s%n "
                + "Description of the service: %s%n Schedule of the Service: %s%n "
                + "Postal Address: %s%n Client: %s%n", this.number, this.provider.getAbrevName(), 
                this.descServ.getService(), this.servSchedule.getDate().toString(), this.pAddress.toString(), this.cli.toString());
    }

    /**
     * Compares 2 objects and checks if they are equal.
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        ServiceOrder obj = (ServiceOrder) o;
        return (Objects.equals(this.cli, obj.cli) &&
                Objects.equals(this.descServ, obj.descServ) && Objects.equals(this.emissionDate, obj.emissionDate)
                && Objects.equals(this.executionState, obj.executionState) && Objects.equals(this.number, obj.number)
                && Objects.equals(this.pAddress, obj.pAddress) && Objects.equals(this.provider, obj.provider) &&
                Objects.equals(this.rateState, obj.rateState) && Objects.equals(this.servSchedule, obj.servSchedule));
    }
    
     /**
     * Returns the information related to the invoice
     * 
     * @return information of the invoice
     */
    public String showInvoice() {
        double costServ= this.descServ.getService().getCostForDuration(descServ.getDuration());
        double costDesl= this.provider.getGeoArea().getDislocationCost();
        double total= costServ+costDesl;
        return "Service realization cost: "+costServ+" €\n"+
                "Deslocation cost: "+ costDesl+" €\n"+
                "Total: "+total+" €";
        
    }
}
