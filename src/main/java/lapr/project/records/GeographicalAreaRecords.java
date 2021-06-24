/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.ExternalService;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalCode;

/**
 *
 * @author Utilizador
 */
public class GeographicalAreaRecords {

    /**
     * List of geographical areas.
     */
    List<GeographicalArea> geographicalArea = new ArrayList<>();

    /**
     * Returns a new Geographical Area created with data received by parameters.
     *
     * @param desig designation
     * @param cost cost
     * @param postalCod postal code
     * @param radius
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws FileNotFoundException
     */
    public GeographicalArea newGeographicalArea(String desig, double cost, String postalCod, float radius) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        ExternalService extService = AppGPSD.getInstance().getCompany().getExternalService();
        GeographicalArea ga = new GeographicalArea(desig, cost, postalCod, radius, extService);
        return ga;
    }

    /**
     * Returns the closest geographical area to a postal code received by
     * parameter.
     *
     * @param pc postal code
     * @return
     */
    public GeographicalArea getClosestGeographicalArea(PostalCode pc) {
        double min = Double.MAX_VALUE;
        GeographicalArea closestGA = null;
        for (GeographicalArea ag : this.geographicalArea) {
            double lat1 = pc.getLatitude();
            double lon1 = pc.getLongitude();
            double lat2 = ag.getPostalCode().getLatitude();
            double lon2 = ag.getPostalCode().getLongitude();
            double dist = calculateDistance(lat1, lon1, lat2, lon2);
            if (dist < min) {
                closestGA = ag;
                min = dist;
            }
        }
        return closestGA;
    }

    /**
     * Calculates distance between 2 latitudes and longitudes.
     *
     * @param lat1 latitude1
     * @param lon1 longitude1
     * @param lat2 latitude2
     * @param lon2 longitude2
     * @return
     */
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // shortest distance over the earth’s surface
        // https://www.movable-type.co.uk/scripts/latlong.html
        final double R = 6371e3;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2) + Math.cos(theta1) * Math.cos(theta2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // distance in meters
        return d;
    }

    /**
     * Returns list of geographical areas.
     *
     * @return
     */
    public List<GeographicalArea> getGeoAreasList() {
        return this.geographicalArea;
    }

    /**
     * Returns the geographical area from the list that has the designation
     * received by parameter.
     *
     * @param designation
     * @return geographical area if exists an area with that designation or null if it doesn't
     */
    public GeographicalArea getGeoAreaByDesignation(String designation) {
        for (GeographicalArea geoArea : this.geographicalArea) {
            if (geoArea.hasDesignation(designation)) {
                return geoArea;
            }
        }

        return null;
    }

    /**
     * Registers geographical area received by parameter, if the geographical
     * area is valid, it will be added to the list.
     *
     * @param ga geographical area
     * @return true if the area is valid and added to the list, false if it isnt' 
     * valid or added to the list
     */
    public boolean registersGeographicalArea(GeographicalArea ga) {
        boolean result = false;
        if (validatesGeographicalArea(ga)) {
            result = addGeographicalArea(ga);
        }
        return result;
    }

    /**
     * Validates geographical area received by parameter, checking if it already
     * exists on the list.
     *
     * @param ga geographical area
     * @return false if the area doesn't have a list of act or if the area is 
     * already in the list.
     */
    public boolean validatesGeographicalArea(GeographicalArea ga) {
        boolean result = true;
        if (ga.getAct() == null || ga.getAct().isEmpty()) {
            result = false;
        }
        for (GeographicalArea x : geographicalArea) {
            if (x.equals(ga) || x.getDesignation().equalsIgnoreCase(ga.getDesignation())) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Adds geographical area to the list of areas.
     * 
     * @param ga geographical area
     * @return true if it can add the geographical area, false if it's not possible to add it
     */
    public boolean addGeographicalArea(GeographicalArea ga) {
        return this.geographicalArea.add(ga);
    }
}
