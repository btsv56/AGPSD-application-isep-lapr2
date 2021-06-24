/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProvidingRequestDescription;
import lapr.project.gpsd.model.ServiceSchedule;

/**
 *
 * @author Andre
 */
public class ServiceOrderRecords {

    //List of all service orders.
    List<ServiceOrder> serviceOrderList = new ArrayList<>();


    /**
     * Constructor
     */
    public ServiceOrderRecords() {

    }

    /**
     * Returns the list of Service Orders with the flag "Not Executed" of a
     * Service Provider
     *
     * @param sp Service Provider
     * @return List of ServiceOrder
     */
    public List<ServiceOrder> getUnfinishedServiceOrdersBySP(ServiceProvider sp) {
        List<ServiceOrder> serviceOrderBySp = getServiceOrderByServProv(sp);
        List<ServiceOrder> unfinishedOrders = new ArrayList<>();
        for (ServiceOrder servOrder : serviceOrderBySp) {
            if (servOrder.getExecutionState().equalsIgnoreCase("Not Executed")) {
                unfinishedOrders.add(servOrder);
            }
        }
        return unfinishedOrders;
    }

    /**
     * Registers a Service Order after being validated. Also sets the emission
     * date, and number
     *
     * @param so Service ORder to be registered
     * @return Integer regarding the success of the operation. -1 if successfull
     */
    public int registerServiceOrder(ServiceOrder so) {
        if (validateServiceOrder(so)) {
            int num = generateNumber(so);
            LocalDate date = generateIssueDate();
            so.setEmissionDate(date);
            so.setNumber(num);
            addServiceOrder(so);
            return num;
        }
        return -1;
    }

    /**
     * Returns the list of orders
     *
     * @return list of ServiceOrder
     */
    public List<ServiceOrder> getOrdersList() {
        return serviceOrderList;
    }

    /**
     * Returns the List of Service Orders, of a determined service provider,
     * within a determined set of time
     *
     * @param servProv Service Provider
     * @param dateB date of Begining
     * @param dateE date of end
     * @return List of Service Orders
     */
    public List<ServiceOrder> getServOrderListByDate(ServiceProvider servProv, LocalDate dateB, LocalDate dateE) {
        List<ServiceOrder> servOrderByDate = new ArrayList<>();
        for (ServiceOrder servOrder : getServiceOrderByServProv(servProv)) {
            ServiceSchedule servSchedule = servOrder.getServSchedule();
            if (servSchedule.getDate().compareTo(dateB) > 0 && servSchedule.getDate().compareTo(dateE) < 0) {
                servOrderByDate.add(servOrder);
            }
        }
        return servOrderByDate;
    }

    /**
     * Returns the Service Orders associated with a ServProvider
     *
     * @param servProv Service Provider to be compared
     * @return List of ServiceOrder
     */
    public List<ServiceOrder> getServiceOrderByServProv(ServiceProvider servProv) {
        List<ServiceOrder> servOrderServProv = new ArrayList<>();
        for (ServiceOrder servOrder : this.serviceOrderList) {
            if (servOrder.hasServProv(servProv)) {
                servOrderServProv.add(servOrder);
            }
        }
        return servOrderServProv;

    }

    /**
     * Validates a Service Order
     *
     * @param so ServiceOrder
     * 
     * @return boolean regarding the success of the operation
     */
    public boolean validateServiceOrder(ServiceOrder so) {
        for(ServiceOrder o : serviceOrderList){
            if(o.equals(so)){
                return false;
            }
        }
        return true;
    }

    /**
     * adds a service Order to the list of service orders
     *
     * @param so service order
     * @return boolean regarding the success of the operation
     */
    public boolean addServiceOrder(ServiceOrder so) {
        return this.serviceOrderList.add(so);
    }

    /**
     * Creates a new Instance of ServiceOrder with the parameters received
     *
     * @param prov ServicePRovider
     * @param descServ ServiceProvidingRequest
     * @param ss ServiceSchedule
     * @param end Postal address
     * @param cli Client
     * @return new Instance of serviceOrder
     */
    public ServiceOrder generateOrderServiceExecution(int j, ServiceProvider prov, ServiceProvidingRequestDescription descServ, ServiceSchedule ss, PostalAddress end, Client cli) {
        return new ServiceOrder(j, prov, descServ, ss, end, cli);
    }

    /**
     * Generates a number to be associated to an order
     *
     * @param so ServiceOrder to be associated to the number
     * @return number
     */
    private int generateNumber(ServiceOrder so) {
        return (serviceOrderList.size() + 1);
    }

    /**
     * Gets the current date and returns it
     *
     * @return current LocalDate
     */
    private LocalDate generateIssueDate() {
        return LocalDate.now();
    }

    /**
     * Returns the service orders associated to a client
     *
     * @param cli client
     * @return list of service orders
     */
    public List<ServiceOrder> getServiceOrdersByClient(Client cli) {
        List<ServiceOrder> list = new ArrayList<>();
        for (ServiceOrder so : this.serviceOrderList) {
            if (so.hasClient(cli) && so.isExecuted() && so.isNotRated()) {
                list.add(so);
            }
        }
        return list;
    }

    /**
     * Returns the service order associated the the number
     *
     * @param num number
     * @return service order
     */
    public ServiceOrder getServiceOrderByNum(int num) {
        for (ServiceOrder o : this.serviceOrderList) {
            if (o.getNumber() == num) {
                return o;
            }
        }
        return null;
    }

}
