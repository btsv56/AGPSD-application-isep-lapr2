package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.GeographicalAreaRecords;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileFormatterXLS implements FileFormatter {

    /**
     * list of service orders to be exported
     */
    private List<ServiceOrder> serviceOrders;
    /**
     * format of the file
     */
    private String format;
    /**
     * name of the file
     */
    private final String FILE = "ServiceOrders.xlsx";
    /**
     * name of the columns containing the fields
     */
    private final static String[] COLUMNS = {"ServiceNumber", "ServiceProviderName", "Name", "Distance", "Category", "StartDate", "StartHoura", "ServiceType", "Street", "PostalCode", "Zone", "Latitude", "Longitude"};

    /**
     * Constructor
     *
     * @param format String
     */
    public FileFormatterXLS(String format) {
        this.serviceOrders = new ArrayList<>();
        this.format = format;
    }

    /**
     * get Service Orders
     *
     * @return service orders
     */
    public List<ServiceOrder> getServiceOrders() {
        return new ArrayList<>(serviceOrders);
    }

    /**
     * returns the format of the file
     *
     * @return format of file
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * sets the service orders of the class
     *
     * @param serviceOrders service orders
     */
    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = new ArrayList<>(serviceOrders);
    }

    /**
     * sets the format of the file
     *
     * @param format format of file
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Exports the information of the service Orders to a XLS file named
     * ServiceOrders.xls
     *
     * @param servOrders list of service orders
     * @return boolean regarding the success of the operation
     */
    @Override
    public boolean export(List<ServiceOrder> servOrders) {
        try {
            this.serviceOrders = new ArrayList<>(servOrders);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("ServiceOrders");
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < COLUMNS.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(COLUMNS[i]);
            }
            int rowNum = 1;
            int servID = 1;
            for (ServiceOrder servOrder : this.serviceOrders) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                Cell cell17 = row.createCell(colNum++);
                cell17.setCellValue(servID++);
                Cell cell1 = row.createCell(colNum++);
                String nameSP = servOrder.getProvider().getFullName();
                cell1.setCellValue(nameSP);
                Cell cell = row.createCell(colNum++);
                String name = servOrder.getCli().getName();
                cell.setCellValue(name);
                Cell cell2 = row.createCell(colNum++);
                PostalCode postalCodeClient = servOrder.getpAddress().getPostalCode();
                PostalCode postalCodeSP = servOrder.getProvider().getPostalAddress().getPostalCode();
                GeographicalAreaRecords geoAreaRecords = AppGPSD.getInstance().getCompany().getGeographicalAreaRecords();
                String distance = String.valueOf(geoAreaRecords.calculateDistance(postalCodeClient.getLatitude(), postalCodeClient.getLongitude(), postalCodeSP.getLatitude(), postalCodeSP.getLongitude()));
                cell2.setCellValue(distance);
                Cell cell3 = row.createCell(colNum++);
                String category = String.valueOf(servOrder.getDescServ().getService().getCategory());
                cell3.setCellValue(category);
                Cell cell4 = row.createCell(colNum++);
                String startDate = String.valueOf(servOrder.getServSchedule().getDate());
                cell4.setCellValue(startDate);
                Cell cell5 = row.createCell(colNum++);
                String startHour = String.valueOf(servOrder.getServSchedule().getHour());
                cell5.setCellValue(startHour);
                Cell cell6 = row.createCell(colNum++);
                String service = String.valueOf(servOrder.getDescServ().getService().getClass().getSimpleName());
                cell6.setCellValue(service);
                Cell cell7 = row.createCell(colNum++);
                String street = String.valueOf(servOrder.getpAddress().getM_address());
                cell7.setCellValue(street);
                Cell cell8 = row.createCell(colNum++);
                String postalCode = String.valueOf(servOrder.getpAddress().getPostalCode().getPostalCode());
                cell8.setCellValue(postalCode);
                Cell cell9 = row.createCell(colNum++);
                String zone = String.valueOf(servOrder.getpAddress().getM_local());
                cell9.setCellValue(zone);
                Cell cell10 = row.createCell(colNum++);
                String latitude = String.valueOf(servOrder.getpAddress().getPostalCode().getLatitude());
                cell10.setCellValue(latitude);
                Cell cell11 = row.createCell(colNum++);
                String longitude = String.valueOf(servOrder.getpAddress().getPostalCode().getLongitude());
                cell11.setCellValue(longitude);
            }

            FileOutputStream outputStream = new FileOutputStream(FILE);
            workbook.write(outputStream);
            workbook.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * sets the service execution orders list
     *
     * @param so service orders
     */
    public void setServiceExecutionOrder(ArrayList<ServiceOrder> so) {
        this.serviceOrders = new ArrayList<>(so);
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
        final FileFormatterXLS other = (FileFormatterXLS) obj;
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        if (!Objects.equals(this.serviceOrders, other.serviceOrders)) {
            return false;
        }
        return true;
    }

}
