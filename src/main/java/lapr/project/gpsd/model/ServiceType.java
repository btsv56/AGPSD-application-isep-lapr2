/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 *
 * @author marta
 */
public class ServiceType {


    /**
     * Designation or service class
     */
    private String designation;

    /**
     * Id of service type.
     */
    private String idType;

    /**
     * Constructor
     * @param designation
     * @param idType 
     */
    public ServiceType(String designation, String idType) {
        this.designation = designation;
        this.idType = idType;
    }

    /**
     * Creates a Service.
     * 
     * @param id unique identifier
     * @param briefDesc brief description
     * @param compDesc complete description
     * @param cost cost per hour
     * @param cat category
     * @return
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException 
     */
    public Service newService(String id, String briefDesc, String compDesc, double cost, Category cat) throws InstantiationException, 
            NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        Class<?> oClass = Class.forName(this.getDesignation().trim());
        Class[] argsClasses = new Class[]{String.class, String.class, String.class, double.class, Category.class};
        Constructor constructor = oClass.getConstructor(argsClasses);
        Object[] argsValues = new Object[]{id, briefDesc, compDesc, cost, cat};
        Service serv = (Service) constructor.newInstance(argsValues);
        return serv;
    }

    /**
     * Returns id of service type.
     * @return the idType
     */
    public String getIdType() {
        return idType;
    }
    
    /**
     * Return designation.
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Changes id of service type to the one received by parameter.
     * @param idType the idType to set
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * Changes designation of service type to the one received by parameter.
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    /**
     * Returns the textual format of service type.
     * @return 
     */
    @Override
    public String toString() {
        return String.format(" %s - %s ", this.getDesignation(), this.idType);
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
        ServiceType obj = (ServiceType) o;
        return (Objects.equals(this.designation, obj.designation) && 
                Objects.equals(this.idType, obj.idType));
    }

}
