package lapr.project.gpsd.model;

import java.io.IOException;
import java.util.List;

public interface FileFormatter {

    boolean export(List<ServiceOrder> servOrders) throws IOException;
}
