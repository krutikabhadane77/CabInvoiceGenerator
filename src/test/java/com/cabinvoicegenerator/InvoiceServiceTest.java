package com.cabinvoicegenerator;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void init() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int timeInMins = 5;
        double fare = invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int timeInMins =1;
        double fare = invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(5, fare,0.0);
    }

//    @Test   // In case of lots of traffic
//    public void givenNoDistanceButLessTime_ShouldReturnMinFare() {
//        double distance = 0;
//        int timeInMins = 5;
//        double fare=invoiceGenerator.calculateFare(distance, timeInMins);
//        assertEquals(5, fare,0.0);
//    }
//
//    @Test  //In case of cancellation of booking
//    public void givenNoDistanceAndTime_ShouldAlsoReturnMinFare() {
//        double distance = 0;
//        int timeInMins = 0;
//        double fare=invoiceGenerator.calculateFare(distance, timeInMins);
//        assertEquals(5, fare,0.0);
//    }

    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary() {
        Rides[] rides = {new Rides(2.0,5),
                    new Rides(0.1,1)};
        InvoiceSummary actualSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary.toString(),actualSummary,0.0);
    }
}