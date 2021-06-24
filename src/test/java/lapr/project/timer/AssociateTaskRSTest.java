package lapr.project.timer;

import lapr.project.gpsd.controller.AppGPSD;
import lapr.project.gpsd.model.*;
import lapr.project.records.AssociationProviderRequestRecords;
import lapr.project.records.ServiceProviderRecords;
import lapr.project.records.ServiceProvidingRequestRecords;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AssociateTaskRSTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void associateSPtoRequest() throws UnsupportedEncodingException, FileNotFoundException {
        System.out.println("associateSPtoRequest");
        try {
            ServiceProvidingRequestRecords requestRcds = AppGPSD.getInstance().getCompany().getServiceProvidingRequestRecords();
            ServiceProvidingRequest request = new ServiceProvidingRequest(new Client("123", "123", "123", "123"), new PostalAddress("123", new PostalCode("123", 123, 123), "123"));
            Category cat = new Category("123", "123");
            request.addServiceProvidingRequest(new FixedService("123", "123", "123", 30, cat), "desc", 30);
            request.addTime(LocalDate.of(2020, 12, 12), "13:00");
            requestRcds.registerRequestTest(request);
            AssociationProviderRequestRecords assRcds = AppGPSD.getInstance().getCompany().getAssociationRecords();
            ServiceProviderRecords spRcds = AppGPSD.getInstance().getCompany().getServiceProviderRecords();
            ServiceProvider sp = spRcds.newServiceProvider("123", "123", 123123123, 123123123, "123");
            sp.addCategory(cat);
            sp.getAvailabilityList().addAvailabilityTime(new Availability(LocalDate.of(2020, 1, 1), new Time("12:00"), LocalDate.of(2020, 12, 29), new Time("17:00"), "Everyday"));
            spRcds.registerServiceProvider(sp);
            boolean expResult = true;
            AssociateTaskFCFS instance = new AssociateTaskFCFS(1);
            boolean result = instance.associateSPtoRequestTest(requestRcds.getRequestsList());
            assertEquals(expResult, result);
        } catch (Exception ex) {

        }
    }
}
