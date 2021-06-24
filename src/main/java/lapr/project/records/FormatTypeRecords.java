package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.FormatType;

public class FormatTypeRecords {

    List<FormatType> availableFormats;

    /**
     * Constructor
     */
    public FormatTypeRecords() {
        availableFormats = new ArrayList<>();
    }

    /**
     * Returns the format types available in the company
     *
     * @return he list of format types
     */
    public List<FormatType> getFormatTypes() {
        return (this.availableFormats);
    }

    /**
     * Creates the Format Types supported by the company, by getting the
     * properties associated with the company, and instantiates the classes
     * using reflection
     *
     * @param props company properties
     * @return boolean regarding the success of the operation
     */
    public boolean createsFormatTypesSupported(Properties props) {
        boolean result = false;
        String qtdTypes = props.getProperty(Constants.QUANTITY_TYPE_FORMATS);
        int qtd = Integer.parseInt(qtdTypes);
        for (int i = 1; i <= 3; i++) {
            String idType = props.getProperty("Company.FormatType." + i + ".IdType");
            String designation = props.getProperty("Company.FormatType." + i + ".Designation");
            FormatType formatType = new FormatType(designation, idType);
            this.availableFormats.add(formatType);
        }
        if (availableFormats.size() == qtd) {
            result = true;
        }
        return result;
    }

    /**
     * Returns the desired format type, acquired by comparing the format list
     * available in this class, with a determined designation
     *
     * @param designation designation of the format type
     * @return FormatType class associated with the designation
     */
    public FormatType getFormatTypeByDesignation(String designation) {
        for (FormatType sv : this.availableFormats) {
            if (sv.getDesignation().equals(designation)) {
                return sv;
            }
        }
        return null;
    }

}
