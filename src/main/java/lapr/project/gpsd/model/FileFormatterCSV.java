package lapr.project.gpsd.model;

import java.util.List;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.GeographicalAreaRecords;

public class FileFormatterCSV implements FileFormatter {

    /**
     * List of Service Orders to be exported
     */
    private List<ServiceOrder> serviceOrders;
    /**
     * Format of the file
     */
    private String format;
    /**
     * name of the file
     */
    private final String FILE = "ServiceOrders.csv";

    /**
     * Constrcutor
     *
     * @param format format of the file to be created
     * @throws IOException ioe
     */
    public FileFormatterCSV(String format) throws IOException {
        this.serviceOrders = new ArrayList<>();
        this.format = format;
    }

    /**
     * returns a list of service orders
     *
     * @return returns list
     */
    public List<ServiceOrder> getServiceOrders() {
        return new ArrayList<>(serviceOrders);
    }

    /**
     * sets the list of service orders
     *
     * @param serviceOrders service orders
     */
    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = new ArrayList<>(serviceOrders);
    }

    /**
     * get the format of the file
     *
     * @return file format
     */
    public String getFormat() {
        return format;
    }

    /**
     * sets the format of the file
     *
     * @param format file format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Exports the information of the service Orders to a csv file named
     * ServiceOrders.csv
     *
     * @param servOrders list of service orders
     * @return boolean regarding the success of the operation
     * @throws IOException ioe
     */
    @Override
    public boolean export(List<ServiceOrder> servOrders) throws IOException {

        try (FileWriter writer = new FileWriter(FILE)) {
            this.serviceOrders = new ArrayList<>(servOrders);
            writer.append("ServiceNumber");
            writer.append(',');
            writer.append("ServiceProviderName");
            writer.append(',');
            writer.append("ClientName");
            writer.append(',');
            writer.append("Distance");
            writer.append(',');
            writer.append("Category");
            writer.append(',');
            writer.append("StartDate");
            writer.append(',');
            writer.append("StartHour");
            writer.append(',');
            writer.append("ServiceType");
            writer.append(',');
            writer.append("Street");
            writer.append(',');
            writer.append("PostalCode");
            writer.append(',');
            writer.append("Zone");
            writer.append(',');
            writer.append("Latitude");
            writer.append(',');
            writer.append("Longitude");
            writer.append('\n');
            int num = 1;
            for (ServiceOrder servOrder : this.serviceOrders) {

                writer.append(String.valueOf(num));
                num++;
                writer.append(',');
                String nameSP = servOrder.getProvider().getFullName();
                writer.append(nameSP);
                writer.append(',');
                String name = servOrder.getCli().getName();
                writer.append(name);
                writer.append(',');
                PostalCode postalCodeClient = servOrder.getpAddress().getPostalCode();
                PostalCode postalCodeSP = servOrder.getProvider().getPostalAddress().getPostalCode();
                GeographicalAreaRecords geoAreaRecords = AppGPSD.getInstance().getCompany().getGeographicalAreaRecords();
                String distance = String.valueOf(geoAreaRecords.calculateDistance(postalCodeClient.getLatitude(), postalCodeClient.getLongitude(), postalCodeSP.getLatitude(), postalCodeSP.getLongitude()));
                writer.append(distance);
                writer.append(',');
                String category = String.valueOf(servOrder.getDescServ().getService().getCategory());
                writer.append(category);
                writer.append(',');
                String startDate = String.valueOf(servOrder.getServSchedule().getDate());
                writer.append(startDate);
                writer.append(',');
                String startHour = String.valueOf(servOrder.getServSchedule().getHour());
                writer.append(startHour);
                writer.append(',');
                String service = String.valueOf(servOrder.getDescServ().getService().getClass().getSimpleName());
                writer.append(service);
                writer.append(',');
                String street = String.valueOf(servOrder.getpAddress().getM_address());
                writer.append(street);
                writer.append(',');
                String postalCode = String.valueOf(servOrder.getpAddress().getPostalCode().getPostalCode());
                writer.append(postalCode);
                writer.append(',');
                String zone = String.valueOf(servOrder.getpAddress().getM_local());
                writer.append(zone);
                writer.append(',');
                String latitude = String.valueOf(servOrder.getpAddress().getPostalCode().getLatitude());
                writer.append(latitude);
                writer.append(',');
                String longitude = String.valueOf(servOrder.getpAddress().getPostalCode().getLongitude());
                writer.append(longitude);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
            return true;
        }

    }

    /**
     * Checks if an object is equal to this insance
     *
     * @param obj other object
     * @return boolean regarding the truth of the affirmation
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileFormatterCSV other = (FileFormatterCSV) obj;
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        if (!Objects.equals(this.serviceOrders, other.serviceOrders)) {
            return false;
        }
        return true;
    }

}
