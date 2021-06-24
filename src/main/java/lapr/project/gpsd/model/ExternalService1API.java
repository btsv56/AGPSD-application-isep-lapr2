/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AppGPSD;

/**
 *
 * @author marta
 */
public class ExternalService1API {

    /**
     * Returns a list of objects ActsIn that has postal code and the respective distance 
     * within the radius received by parameter.
     * 
     * @param pc postal code
     * @param radius
     * @return List of ActsIn
     * @throws FileNotFoundException fnfe
     */
    public List<ActsIn> obtainActing(PostalCode pc, float radius) throws FileNotFoundException {
        List<ActsIn> act = new ArrayList<>();
        double lat1 = pc.getLatitude();
        double lon1 = pc.getLongitude();
        Company company = AppGPSD.getInstance().getCompany();
        List<PostalCode> allpc = company.getPostalCodeRecords().getLst();
        for (PostalCode post : allpc) {
            double lat2 = post.getLatitude();
            double lon2 = post.getLongitude();
            double distance = calculateDistance(lat1, lon1, lat2, lon2);
            if (distance <= radius) {
                ActsIn e = new ActsIn(post, distance);
                act.add(e);
            }
        }
        return act;
    }

    /**
     * Calculates the distance between latitudes and longitudes
     * 
     * @param lat1 double
     * @param lon1 double
     * @param lat2 double
     * @param lon2 double
     * @return double d
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
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

}
