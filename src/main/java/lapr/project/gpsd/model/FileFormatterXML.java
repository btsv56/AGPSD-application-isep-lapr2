package lapr.project.gpsd.model;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.GeographicalAreaRecords;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FileFormatterXML implements FileFormatter {

    /**
     * List of service orders
     */
    private List<ServiceOrder> serviceOrders;
    /**
     * format of the file
     */
    private String format;
    /**
     * name of the file
     */
    private final String FILE = "ServiceOrders.xml";

    /**
     * Constructor. Enter a format type
     *
     * @param format format of the file
     */
    public FileFormatterXML(String format) {
        this.serviceOrders = new ArrayList<>();
        this.format = format;
    }

    /**
     * Exports the information of the service Orders to a XMLx file named
     * ServiceOrders.xml
     *
     * @param servOrders list of service orders
     * @return boolean regarding the success of the operation
     */
    @Override
    public boolean export(List<ServiceOrder> servOrders) {
        this.serviceOrders = new ArrayList<>(servOrders);
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuild;
        try {
            docBuild = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuild.newDocument();
            Element mainRootElement = doc.createElement("ServiceOrders");
            doc.appendChild(mainRootElement);
            int id = 1;
            for (ServiceOrder servOrder : serviceOrders) {
                mainRootElement.appendChild(getServiceOrder(doc, String.valueOf(id), servOrder));
                id++;
            }

            OutputFormat format = new OutputFormat(doc);
            format.setIndenting(true);
            File file = new File(FILE);
            FileOutputStream fOS = new FileOutputStream(file);
            XMLSerializer serializer = new XMLSerializer(fOS, format);
            serializer.serialize(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Creates a new Node of ServiceOrder
     *
     * @param doc document
     * @param id id
     * @param servOrder service order
     * @return returns the new node of service provider
     */
    public static Node getServiceOrder(Document doc, String id, ServiceOrder servOrder) {
        Element serviceOrder = doc.createElement("ServiceOrder");
        serviceOrder.setAttribute("id", id);
        String nameSP = servOrder.getProvider().getFullName();
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "ProviderName", nameSP));
        String name = servOrder.getCli().getName();
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Name", name));
        PostalCode postalCodeClient = servOrder.getpAddress().getPostalCode();
        PostalCode postalCodeSP = servOrder.getProvider().getPostalAddress().getPostalCode();
        GeographicalAreaRecords geoAreaRecords = AppGPSD.getInstance().getCompany().getGeographicalAreaRecords();
        String distance = String.valueOf(geoAreaRecords.calculateDistance(postalCodeClient.getLatitude(), postalCodeClient.getLongitude(), postalCodeSP.getLatitude(), postalCodeSP.getLongitude()));
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Distance", distance));
        String category = String.valueOf(servOrder.getDescServ().getService().getCategory());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Category", category));
        String startDate = String.valueOf(servOrder.getServSchedule().getDate());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "StartDate", startDate));
        String startHour = String.valueOf(servOrder.getServSchedule().getHour());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "StartHour", startHour));
        String service = String.valueOf(servOrder.getDescServ().getService().getClass().getSimpleName());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "ServiceType", service));
        String street = String.valueOf(servOrder.getpAddress().getM_address());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Street", street));
        String postalCode = String.valueOf(servOrder.getpAddress().getPostalCode().getPostalCode());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "PostalCode", postalCode));
        String zone = String.valueOf(servOrder.getpAddress().getM_local());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Zone", zone));
        String latitude = String.valueOf(servOrder.getpAddress().getPostalCode().getLatitude());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Latitude", latitude));
        String longitude = String.valueOf(servOrder.getpAddress().getPostalCode().getLongitude());
        serviceOrder.appendChild(getServiceOrderElements(doc, serviceOrder, "Longitude", longitude));

        return serviceOrder;
    }

    /**
     * Returns the elements to be entered in the new Service Provider node, as a
     * new node
     *
     * @param doc document
     * @param element element
     * @param name name of the field
     * @param value value of the field
     * @return new node
     */
    public static Node getServiceOrderElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
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
        final FileFormatterXML other = (FileFormatterXML) obj;
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        if (!Objects.equals(this.serviceOrders, other.serviceOrders)) {
            return false;
        }
        return true;
    }

}
