/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.records.ApplicationRecords;
import lapr.project.records.AvailabilityList;
import lapr.project.records.CategoryRecords;
import lapr.project.records.ClientRecords;
import lapr.project.records.GeographicalAreaRecords;
import lapr.project.records.IssueRecords;
import lapr.project.records.PostalCodeRecords;
import lapr.project.records.ServiceOrderRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import lapr.project.records.ServiceRecords;
import lapr.project.gpsd.model.Time;
import lapr.project.records.RateList;

/**
 *
 * @author User
 */
public class Instanciate {

    /**
     * Method that create and add one Postal Code from a file
     *
     * @param code Postal code which will be searched in the file
     * @return true if Postal Code was found and false if Postal code wasn't
     * found
     */
    public static boolean readPostalCodes(String code) {
        try {
            Scanner fInput = new Scanner(new File("codigopostal_alt_long.csv"));
            try {
                int cont = 0;
                fInput.nextLine();
                while (fInput.hasNextLine()) {
                    String linha = fInput.nextLine();
                    if ((linha.trim()).length() > 0) {
                        String[] temp = linha.split(";");
                        String cd4 = temp[7];
                        String cd3 = temp[8];
                        String[] temp0 = code.split("-");
                        if (cd4.equals(temp0[0]) && (cd3.equals(temp0[1]))) {
                            String[] temp2 = temp[10].split(",");
                            String[] temp3 = temp[11].split(",");
                            double latitude = Double.parseDouble(temp2[0] + "." + temp2[1]);
                            double longitude = Double.parseDouble(temp3[0] + "." + temp3[1]);
                            PostalCode pc = new PostalCode(cd4 + "-" + cd3, latitude, longitude);
                            AppGPSD.getInstance().getCompany().getPostalCodeRecords().addPostalCode(pc);
                            return true;
                        }
                    }
                }
            } finally {
                fInput.close();
            }
        } catch (IOException ex) {
            System.out.println("O ficheiro de Códigos postais, não existe, o programa não consegue inicializar.");
            System.exit(0);
        }
        return false;
    }

    /**
     * Method that instanciate clients
     */
    public static void createClients() {
        readPostalCodes("4420-1");
        readPostalCodes("4415-999");
        readPostalCodes("4250-100");
        readPostalCodes("4470-528");
        Client cli = new Client("Maria Santos", "100542369", "936565651", "msantos@gmail.com", new PostalAddress("Rua D. João de França, nº 1", new PostalCode("4420-1"), "Gondomar"));
        Client cli1 = new Client("António Lage", "200542669", "916535661", "aLage@gmail.com", new PostalAddress("R. Gonçalves de Castro, nº 8", new PostalCode("4415-999"), "Pedroso"));
        Client cli2 = new Client("Ana Santos", "110542349", "966535661", "aSantos23@isep.ipp.pt", new PostalAddress("R. do Carvalhido, nº 9", new PostalCode("4250-100"), "Porto"));
        Client cli3 = new Client("Joana Santos", "210975020", "966545644", "jSantos@isep.ipp.pt", new PostalAddress("R. Cegonheira, nº 3", new PostalCode("4470-528"), "Maia"));
        ClientRecords pr = AppGPSD.getInstance().getCompany().getClientRecords();
        pr.registerClient(cli, "prosdbsts190");
        pr.registerClient(cli1, "aLage1234");
        pr.registerClient(cli2, "aSantini456");
        pr.registerClient(cli3, "jjSantos23");
    }

    /**
     * Method that instanciate Categories
     */
    public static void createCategories() {
        Category cat = new Category("1", "Plumber");
        Category cat1 = new Category("2", "Locksmith");
        Category cat2 = new Category("3", "Automotive mechanic");
        Category cat3 = new Category("4", "Cook");
        Category cat4 = new Category("5", "Painter");
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        cr.registerCategory(cat);
        cr.registerCategory(cat1);
        cr.registerCategory(cat2);
        cr.registerCategory(cat3);
        cr.registerCategory(cat4);
    }

    /**
     * Method that instanciate Geographiical Areas
     *
     * @throws ClassNotFoundException Exception
     * @throws InstantiationException Exception
     * @throws IllegalAccessException Exception
     * @throws FileNotFoundException Exception
     */
    public static void createGeographicalAreas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        Company comp= AppGPSD.getInstance().getCompany();
        ExternalService api = comp.getExternalService();
        readPostalCodes("4420-2");
        readPostalCodes("4420-570");
        readPostalCodes("4435-685");
        readPostalCodes("4250-108");
        readPostalCodes("4470-526");
        GeographicalArea ga = new GeographicalArea("Gondomar-1", 50, "4420-2", 10000, api);
        GeographicalArea ga1 = new GeographicalArea("Gondomar-2", 10, "4420-570", 5000, api);
        GeographicalArea ga2 = new GeographicalArea("Gondomar-3", 20, "4435-685", 8000, api);
        GeographicalArea ga3 = new GeographicalArea("Porto-1", 30, "4250-108", 10000, api);
        GeographicalArea ga4 = new GeographicalArea("Maia-1", 40, "4470-526", 5000, api);
        GeographicalAreaRecords gar = comp.getGeographicalAreaRecords();
        gar.addGeographicalArea(ga);
        gar.addGeographicalArea(ga1);
        gar.addGeographicalArea(ga2);
        gar.addGeographicalArea(ga3);
        gar.addGeographicalArea(ga4);
    }

    /**
     * Method that instanciate Services
     */
    public static void createService() {
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        Category cat1 = cr.getCategoryById("1");
        Category cat3 = cr.getCategoryById("3");
        Category cat4 = cr.getCategoryById("4");
        Category cat5 = cr.getCategoryById("5");
        FixedService serv1 = new FixedService("1", "Light Plumbing", "Install water tap", 100, cat1);
        serv1.setAdditionalData(60);
        LimitedService serv2 = new LimitedService("2", "Heavy Plumbing", "Pipeline Repair", 40, cat1);
        LimitedService serv3 = new LimitedService("3", "Gate Painting", "Gate Painting", 60, cat5);
        ExpandableService serv4 = new ExpandableService("4", "Prepare dinner", "Prepare dinner and clean the kitchen", 80, cat4);
        LimitedService serv5 = new LimitedService("5", "Repair Vehicle", "Repair vehicle engine", 80, cat3);
        FixedService serv6 = new FixedService("6", "Gate Painting", "Gate Painting", 90, cat5);
        serv6.setAdditionalData(60);
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        sr.registersService(serv1);
        sr.registersService(serv2);
        sr.registersService(serv3);
        sr.registersService(serv4);
        sr.registersService(serv5);
        sr.registersService(serv6);
    }

    /**
     * Method that instanciate service providers
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     */
    public static void createServiceProvider() throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedEncodingException, FileNotFoundException {
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        GeographicalAreaRecords gar = AppGPSD.getInstance().getCompany().getGeographicalAreaRecords();
        readPostalCodes("4415-995");
        readPostalCodes("4420-2");
        readPostalCodes("4470-526");
        readPostalCodes("4430-601");
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvider sp = new ServiceProvider("António Padrão", "António Dos Santos Padrão", 500324896, 123456789, "aPadrao@gmail.com");
        sp.addCategory(cr.getCategoryById("1"));
        sp.addCategory(cr.getCategoryById("3"));
        sp.addGeographicalArea(gar.getGeoAreaByDesignation("Gondomar-1"));
        sp.addGeographicalArea(gar.getGeoAreaByDesignation("Gondomar-2"));
        sp.addPostalAddress(new PostalAddress("Rua do outeiro, 197", new PostalCode("4415-995"), "Paredes"));
        spr.registerServiceProviderWithPass(sp, "1234");
        ServiceProvider sp1 = new ServiceProvider("Maria Silva", "Maria Das Neves Silva", 510324896, 123123123, "mSilva@hotmail.com");
        sp1.addCategory(cr.getCategoryById("2"));
        sp1.addCategory(cr.getCategoryById("4"));
        sp1.addGeographicalArea(gar.getGeoAreaByDesignation("Porto-1"));
        sp1.addPostalAddress(new PostalAddress("Rua de Miragaia, 261", new PostalCode("4420-002"), "Paredes"));
        spr.registerServiceProviderWithPass(sp1, "1234");
        ServiceProvider sp2 = new ServiceProvider("Joaquina Dos Santos", "Joaquina Dos Santos", 510324877, 456456456, "jaquina@hotmail.com");
        sp2.addCategory(cr.getCategoryById("1"));
        sp2.addCategory(cr.getCategoryById("2"));
        sp2.addCategory(cr.getCategoryById("3"));
        sp2.addGeographicalArea(gar.getGeoAreaByDesignation("Maia-1"));
        sp2.addPostalAddress(new PostalAddress("Rua Afonso Paço, 12", new PostalCode("4470-526"), "Paços de Ferreira"));
        spr.registerServiceProviderWithPass(sp2, "1234");
        ServiceProvider sp3 = new ServiceProvider("Serafim Santos", "Serafim Santos", 230324822, 897897897, "sSantos@gmail.com");
        sp3.addCategory(cr.getCategoryById("5"));
        sp3.addCategory(cr.getCategoryById("1"));
        sp3.addGeographicalArea(gar.getGeoAreaByDesignation("Maia-1"));
        sp3.addGeographicalArea(gar.getGeoAreaByDesignation("Gondomar-2"));
        sp3.addPostalAddress(new PostalAddress("Rua Afonso Paço, 12", new PostalCode("4430-601"), "Paços de Ferreira"));
        spr.registerServiceProviderWithPass(sp3, "1234");
    }

    /**
     * Method that instanciates applications
     */
    public static void createApplication() {
        CategoryRecords cr = AppGPSD.getInstance().getCompany().getCategoryRecords();
        readPostalCodes("4415-995");
        readPostalCodes("4420-2");
        readPostalCodes("4470-526");
        readPostalCodes("4430-601");
        ApplicationRecords apr = AppGPSD.getInstance().getCompany().getApplicationRecords();
        Application ap1 = new Application("António Patrão", 500324896, 968795236, "aPatrao@gmail.com", new PostalAddress("R. Central", new PostalCode("4415-995"), "Crestuma"));
        ap1.addProfHabilitation("Bachelor", 3, "Bachelor");
        ap1.addAcadHabilitation("Professional Training Course of Automotive Mechanic of the Center of Professional Training of Automotive Repair");
        ap1.addAcadHabilitation("Professional license for light and heavy vehicles");
        ap1.addAcadHabilitation("Advanced Course in Automotive Mechanics");
        ap1.addSupportingDoc("doc");
        ap1.addCategory(cr.getCategoryById("1"));
        ap1.addCategory(cr.getCategoryById("3"));
        apr.registerApplication(ap1);
        Application ap2 = new Application("Maria Silva", 510324896, 928735537, "mSilva@hotmail.com", new PostalAddress("R. Central", new PostalCode("4420-2"), "Paredes"));
        ap2.addProfHabilitation("Bachelor", 3, "Bachelor");
        ap2.addProfHabilitation("Master", 5, "Master");
        ap2.addProfHabilitation("PhD", 7, "PhD");
        ap2.addAcadHabilitation("Advanced Course of plumbing and locksmithing");
        ap2.addAcadHabilitation("Professional license for light and heavy vehicles");
        ap2.addAcadHabilitation("Cooking Course");
        ap2.addCategory(cr.getCategoryById("1"));
        ap2.addCategory(cr.getCategoryById("2"));
        ap2.addCategory(cr.getCategoryById("4"));
        ap2.addSupportingDoc("doc");
        apr.registerApplication(ap2);
        Application ap3 = new Application("Joaquina Dos Santos", 510324877, 934735567, "jaquina@hotmail", new PostalAddress("Rua Altino Silva Gomes", new PostalCode("4470-526"), "Maia"));
        ap3.addProfHabilitation("Bachelor", 3, "Bachelor");
        ap3.addAcadHabilitation("Advanced Course of plumbing and locksmithing");
        ap3.addAcadHabilitation("Advanced Course in Automotive Mechanics");
        ap3.addCategory(cr.getCategoryById("3"));
        ap3.addCategory(cr.getCategoryById("1"));
        ap3.addCategory(cr.getCategoryById("2"));
        ap3.addSupportingDoc("doc");
        apr.registerApplication(ap3);
        Application ap4 = new Application("Serafim Santos", 230324822, 223654987, "sSantos@gmail.com", new PostalAddress("R. Alberto Alves Tavares", new PostalCode("4430-601"), "Vila Nova De Gaia"));
        ap4.addProfHabilitation("High School", 12, "High School");
        ap4.addAcadHabilitation("Painter Course");
        ap4.addCategory(cr.getCategoryById("1"));
        ap4.addCategory(cr.getCategoryById("5"));
        ap4.addSupportingDoc("doc");
        apr.registerApplication(ap4);

    }

    /**
     * Method that instanciates disponibilities
     */

    public static void createDisponibilities() {
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvider sp1 = spr.getServiceProvider("aPadrao@gmail.com");
        AvailabilityList a1 = sp1.getAvailabilityList();
//        Availability aval1 = a1.newAvailabilityTime(LocalDate.of(2019, 6, 3), "09:00", LocalDate.of(2019, 6, 5), "18:00", "Everyday");
        Availability aval2 = a1.newAvailabilityTime(LocalDate.of(2019, 6, 23), "09:00", LocalDate.of(2019, 6, 25), "13:00", "Everyday");
//        a1.addAvailabilityTime(aval1);
        a1.registerAvailabiityTime(aval2);
        ServiceProvider sp2 = spr.getServiceProvider("mSilva@hotmail.com");
        AvailabilityList a2 = sp2.getAvailabilityList();
//        Availability aval3 = a2.newAvailabilityTime(LocalDate.of(2019, 6, 6), "09:00", LocalDate.of(2018, 6, 7), "18:00", "Everyday");
        Availability aval4 = a2.newAvailabilityTime(LocalDate.of(2019, 6, 23), "09:00", LocalDate.of(2019, 6, 25), "18:00", "Everyday");
        Availability aval5 = a2.newAvailabilityTime(LocalDate.of(2019, 6, 28), "09:00", LocalDate.of(2019, 6, 30), "18:00", "Everyday");
//        a2.addAvailabilityTime(aval3);
        a2.registerAvailabiityTime(aval4);
        a2.registerAvailabiityTime(aval5);
        ServiceProvider sp3 = spr.getServiceProvider("jaquina@hotmail.com");
        AvailabilityList a3 = sp3.getAvailabilityList();
//        Availability aval6 = a3.newAvailabilityTime(LocalDate.of(2019, 6, 7), "09:00", LocalDate.of(2019, 6, 10), "18:00", "Everyday");
        Availability aval7 = a3.newAvailabilityTime(LocalDate.of(2019, 6, 28), "09:00", LocalDate.of(2019, 6, 30), "18:00", "Everyday");
//        a3.addAvailabilityTime(aval6);
        a3.registerAvailabiityTime(aval7);
        ServiceProvider sp4 = spr.getServiceProvider("sSantos@gmail.com");
        AvailabilityList a4 = sp4.getAvailabilityList();
        Availability aval8 = a4.newAvailabilityTime(LocalDate.of(2019, 6, 28), "09:00", LocalDate.of(2019, 6, 30), "18:00", "Everyday");
        a4.registerAvailabiityTime(aval8);
    }

    /**
     * Method that instanciates Service Providing Requests
     */

    public static void createServiceProvidingRequest() {
        ServiceProvidingRequestRecords sprr = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
        ClientRecords cr = AppGPSD.getInstance().getCompany().getClientRecords();
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        readPostalCodes("4420-1");
        readPostalCodes("4250-100");
        readPostalCodes("4470-528");
//        ServiceProvidingRequest s1 = new ServiceProvidingRequest(cr.getClientByEmail("msantos@gmail.com"), new PostalAddress("Rua D. João de França, nº 1", new PostalCode("4420-1"), "Gondomar"));
//        s1.addServiceProvidingRequest(sr.getServiceByID("1"), "Close water tap", 60);
//        s1.addTime(LocalDate.of(2019, 6, 3), "09:00");
//        s1.addTime(LocalDate.of(2019, 6, 3), "18:00");
//        sprr.registerRequest(s1);
        ServiceProvidingRequest s2 = new ServiceProvidingRequest(cr.getClientByEmail("msantos@gmail.com"), new PostalAddress("Rua D. João de França, nº 1", new PostalCode("4420-1"), "Gondomar"));
        s2.addServiceProvidingRequest(sr.getServiceByID("2"), "Pipeline Repair", 60);
        s2.addTime(LocalDate.of(2019, 6, 24), "9:00");
        s2.addTime(LocalDate.of(2019, 6, 25), "17:00");
        sprr.registerRequest(s2);
        ServiceProvidingRequest s3 = new ServiceProvidingRequest(cr.getClientByEmail("aSantos23@isep.ipp.pt"), new PostalAddress("R. do Carvalhido, nº 9", new PostalCode("4250-100"), "Porto"));
        s3.addServiceProvidingRequest(sr.getServiceByID("3"), "Iron gate painting", 120);
        s3.addTime(LocalDate.of(2019, 6, 24), "10:00");
        s3.addTime(LocalDate.of(2019, 6, 25), "14:30");
        sprr.registerRequest(s3);
//        ServiceProvidingRequest s4 = new ServiceProvidingRequest(cr.getClientByEmail("aSantos23@isep.ipp.pt"), new PostalAddress("R. do Carvalhido, nº 9", new PostalCode("4250-100"), "Porto"));
//        s4.addServiceProvidingRequest(sr.getServiceByID("4"), "Prepare dinner and clean kitchen", 120);
//        s4.addTime(LocalDate.of(2019, 6, 6), "18:00");
//        sprr.registerRequest(s4);
//        ServiceProvidingRequest s5 = new ServiceProvidingRequest(cr.getClientByEmail("jSantos@isep.ipp.pt"), new PostalAddress("R. Cegonheira, nº 3", new PostalCode("4470-528"), "Maia"));
//        s5.addServiceProvidingRequest(sr.getServiceByID("1"), "Water tap repair", 60);
//        s5.addTime(LocalDate.of(2019, 6, 7), "18:00");
//        sprr.registerRequest(s5);
//        ServiceProvidingRequest s6 = new ServiceProvidingRequest(cr.getClientByEmail("jSantos@isep.ipp.pt"), new PostalAddress("R. Cegonheira, nº 3", new PostalCode("4470-528"), "Maia"));
//        s6.addServiceProvidingRequest(sr.getServiceByID("5"), "Repair vehicle engine and change oil", 60);
//        s6.addTime(LocalDate.of(2019, 6, 8), "09:00");
//        sprr.registerRequest(s6);
        ServiceProvidingRequest s7 = new ServiceProvidingRequest(cr.getClientByEmail("jSantos@isep.ipp.pt"), new PostalAddress("R. Cegonheira, nº 3", new PostalCode("4470-528"), "Maia"));
        s7.addServiceProvidingRequest(sr.getServiceByID("6"), "Gate paiting", 60);
        s7.addTime(LocalDate.of(2019, 6, 29), "17:00");
        sprr.registerRequest(s7);
    }

    /**
     * Method that instanciates Service Orders
     */

    public static void createServiceOrders() {
        ServiceOrderRecords sor = AppGPSD.getInstance().getCompany().getServiceOrderRecords();
        ClientRecords cr = AppGPSD.getInstance().getCompany().getClientRecords();
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceRecords sr = AppGPSD.getInstance().getCompany().getServiceRecords();
        readPostalCodes("4420-1");
        readPostalCodes("4250-100");
        readPostalCodes("4470-528");
        Client cli1 = cr.getClientByEmail("msantos@gmail.com");
        ServiceProvider spr1 = spr.getServiceProvider("aPadrao@gmail.com");
        ServiceProvidingRequestDescription sd1 = new ServiceProvidingRequestDescription(sr.getServiceByID("1"), "desc", 60);
        PostalAddress pa1 = new PostalAddress("Rua D. João de França, nº 1", new PostalCode("4420-1"), "Gondomar");
        Time t1 = new Time("18:00");
        ServiceSchedule sc1 = new ServiceSchedule("Executed", LocalDate.of(2019, 6, 5), t1);
        ServiceOrder s1 = new ServiceOrder(1, spr1, sd1, sc1, pa1, cli1);
        sor.registerServiceOrder(s1);
        Client cli2 = cr.getClientByEmail("aSantos23@isep.ipp.pt");
        ServiceProvider spr2 = spr.getServiceProvider("mSilva@hotmail.com");
        ServiceProvidingRequestDescription sd2 = new ServiceProvidingRequestDescription(sr.getServiceByID("4"), "desc", 60);
        PostalAddress pa2 = new PostalAddress("R. do Carvalhido, nº 9", new PostalCode("4250-100"), "Porto");
        Time t2 = new Time("18:00");
        ServiceSchedule sc2 = new ServiceSchedule("Executed", LocalDate.of(2019, 6, 6), t2);
        ServiceOrder s2 = new ServiceOrder(2, spr2, sd2, sc2, pa2, cli2);
        sor.registerServiceOrder(s2);
        Client cli3 = cr.getClientByEmail("jSantos@isep.ipp.pt");
        ServiceProvider spr3 = spr.getServiceProvider("jaquina@hotmail.com");
        ServiceProvidingRequestDescription sd3 = new ServiceProvidingRequestDescription(sr.getServiceByID("1"), "desc", 60);
        PostalAddress pa3 = new PostalAddress("R. Cegonheira, nº 3", new PostalCode("4470-528"), "Maia");
        Time t3 = new Time("18:00");
        ServiceSchedule sc3 = new ServiceSchedule("Executed", LocalDate.of(2019, 6, 7), t3);
        ServiceOrder s3 = new ServiceOrder(3, spr3, sd3, sc3, pa3, cli3);
        sor.registerServiceOrder(s3);
        ServiceProvidingRequestDescription sd4 = new ServiceProvidingRequestDescription(sr.getServiceByID("5"), "desc", 60);
        Time t4 = new Time("09:00");
        ServiceSchedule sc4 = new ServiceSchedule("Executed", LocalDate.of(2019, 6, 8), t4);
        ServiceOrder s4 = new ServiceOrder(4, spr3, sd4, sc4, pa3, cli3);
        sor.registerServiceOrder(s4);

    }

    /**
     * Method that instanciates Complete Services
     */

    public static void createCompleteServices() {
        ServiceOrderRecords sor = AppGPSD.getInstance().getCompany().getServiceOrderRecords();
        IssueRecords ir = AppGPSD.getInstance().getCompany().getIssueRecords();
        ServiceOrder so1 = sor.getServiceOrderByNum(1);
        so1.setExecutionState("As expected");
        ServiceOrder so2 = sor.getServiceOrderByNum(2);
        so2.setExecutionState("As expected");
        ServiceOrder so3 = sor.getServiceOrderByNum(3);
        so3.setExecutionState("As expected");
        ServiceOrder so4 = sor.getServiceOrderByNum(4);
        so4.setExecutionState("Not as expected");
        Issue is1 = ir.newIssue(so4, "customer complained about the delay", "work performed without the presence of the client");
        ir.registerIssue(is1);
    }

    /**
     * Method that instanciates Rates
     */

    public static void createRate() {
        ServiceProviderRecords spr = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
        ServiceProvider spr1 = spr.getServiceProvider("aPadrao@gmail.com");
        ServiceProvider spr2 = spr.getServiceProvider("mSilva@hotmail.com");
        ServiceProvider spr3 = spr.getServiceProvider("jaquina@hotmail.com");
        Rate rate1 = spr1.getRateList().addNewRate(4);
        Rate rate2 = spr2.getRateList().addNewRate(5);
        Rate rate3 = spr3.getRateList().addNewRate(2);
        Rate rate4 = spr3.getRateList().addNewRate(2);
        RateList rr = spr1.getRateList();
        RateList rr2 = spr2.getRateList();
        RateList rr3 = spr3.getRateList();
        rr.registerRate(rate1);
        rr2.registerRate(rate2);
        rr3.registerRate(rate3);
        rr3.registerRate(rate4);
    }
}
