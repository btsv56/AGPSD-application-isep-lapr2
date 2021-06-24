package lapr.project.gpsd.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.FileFormatter;
import lapr.project.gpsd.model.FormatType;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.records.FormatTypeRecords;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceProviderRecords;

public class CheckServiceOrdersController {

    private Company company;
    private FormatType formatType;
    private FileFormatter fileFormatter;
    private ServiceProvider servProv;
    private ServiceProviderRecords servProvRecords;
    private ServiceOrderRecords servOrderRecords;
    private FormatTypeRecords formatTypeRecords;

    /**
     * Constructor
     */
    public CheckServiceOrdersController() {
    }

    /**
     * Gets the necessary records, and classes for the functioning of the
     * Controller
     */
    public void initiateNewCheck() {
        AppGPSD app = AppGPSD.getInstance();
        this.company = app.getCompany();
        UserSession session = app.getCurrentSession();
        String email = session.getEmailUser();
        this.servProvRecords = this.company.getServiceProviderRecords();
        this.servProv = this.servProvRecords.getServiceProvider(email);
        this.servOrderRecords = this.company.getServiceOrderRecords();
        this.formatTypeRecords = this.company.getFormatTypeRecords();
    }

    /**
     * returns the service orders associated to the service provider of the
     * current session, within a determined date
     *
     * @param dateB date of beggining
     * @param dateE date of end
     * @return list of service orders
     */
    public List<ServiceOrder> getServOrdersByProvider(LocalDate dateB, LocalDate dateE) {
        List<ServiceOrder> servOrderList = servOrderRecords.getServOrderListByDate(this.servProv, dateB, dateE);
        return servOrderList;
    }

    /**
     * gets and returns the format types supported by the company
     *
     * @return List of format types
     */
    public List<FormatType> getFormatTypes() {
        return this.formatTypeRecords.getFormatTypes();
    }

    /**
     * Gets the data of the List of Service Orders to be exported, and sends it
     * to a new FileFormatter class, associated with the type of format
     * selected, exporting the data to a file
     *
     * @param servOrders List of Service Orders to be Exported
     * @param format format of the file
     * @return boolean regarding the success of the operation
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @throws java.io.IOException
     */
    public boolean export(List<ServiceOrder> servOrders, String format) throws InstantiationException,
            NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, IOException {
        this.formatType = this.formatTypeRecords.getFormatTypeByDesignation(format);
        this.fileFormatter = this.formatType.newFileFormatter(format);
        this.fileFormatter.export(servOrders);
        return true;
    }

}
