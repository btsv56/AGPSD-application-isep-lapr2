package lapr.project.gpsd.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class FormatType {

    /**
     * Designation of the Format Type
     */
    private String designation;
    /**
     * id of the Format Type
     */
    private String idType;

    /**
     * Constructor
     *
     * @param designation Designation of the Format Type
     * @param idType ID of the Format Type
     */
    public FormatType(String designation, String idType) {
        this.designation = designation;
        this.idType = idType;
    }

    /**
     * Creates a new FileFormatter according to the format received as a
     * Parameter
     *
     * @param format Format ( CSV, XLS, XML )
     * @return new FileFormatter
     * @throws InstantiationException ie
     * @throws NoSuchMethodException nsme
     * @throws IllegalAccessException iae
     * @throws InvocationTargetException ite
     * @throws ClassNotFoundException cne
     */
    public FileFormatter newFileFormatter(String format) throws InstantiationException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Class<?> oClass = Class.forName(this.getDesignation().trim());
        Class[] argsClasses = new Class[]{String.class};
        Constructor constructor = oClass.getConstructor(argsClasses);
        Object[] argsValues = new Object[]{format};
        FileFormatter fFormatter = (FileFormatter) constructor.newInstance(argsValues);
        return fFormatter;
    }

    /**
     * Returns the Designation of the Format
     *
     * @return the designation of the format
     */
    public String getDesignation() {
        return this.designation;
    }

    /**
     * Returns the type of the Format
     *
     * @return the type of the format
     */
    public String getIdType() {
        return idType;
    }

    /**
     * sets the Designation of the Format
     *
     * @param designation designation
     * @return boolean true
     */
    public boolean setDesignation(String designation) {
        this.designation = designation;
        return true;
    }

    /**
     * sets the type of the Format
     *
     * @param idType type
     * @return boolean true
     */
    public boolean setIdType(String idType) {
        this.idType = idType;
        return true;
    }

    /**
     * hashes the parameters of this class
     *
     * @return the hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.designation);
        hash = 71 * hash + Objects.hashCode(this.idType);
        return hash;
    }

    /**
     * Compares this object to another received as a parameter
     *
     * @param obj object to be compared
     * @return boolean regarding if it's true or not
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
        final FormatType other = (FormatType) obj;
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        if (!Objects.equals(this.idType, other.idType)) {
            return false;
        }
        return true;
    }

    /**
     * Returns the information of this class
     *
     * @return String "FormatType{designation=(designation), idType=(idType)}"
     */
    @Override
    public String toString() {
        return "FormatType{" + "designation=" + designation + ", idType=" + idType + '}';
    }

}
