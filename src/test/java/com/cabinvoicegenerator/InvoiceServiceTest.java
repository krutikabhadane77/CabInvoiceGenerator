package com.cabinvoicegenerator;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    Map<Integer, InvoiceSummary> userID = new HashMap<>();

    @Before
    public void init() {
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        assertEquals(5.0, invoiceGenerator.calculateFare(0.1, 1), 0.0);
    }

    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary() {
        Rides[] rides = {new Rides(2.0,5, "Premium"),
                new Rides(0.1,1, "Normal"),
                new Rides(4,20,"Normal"),
                new Rides(0.1,1, "Premium")};
        InvoiceSummary actualSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(4, 125.0);
        assertEquals(expectedInvoiceSummary,actualSummary);
    }

    @Test
    public void getListOfRides_UsingId(){
        Rides[] user1Rides = {new Rides(2.0,5, "Premium"),
                new Rides(0.1,1, "Normal"),
                new Rides(4,20,"Normal"),
                new Rides(0.1,1, "Premium")};
        Rides[] user2Rides = {new Rides(2.0,5, "Normal"),
                new Rides(0.1,1, "Normal"),
                new Rides(4,20,"Normal"),};
        InvoiceSummary actualSummary1 = invoiceGenerator.calculateFare(user1Rides);
        InvoiceSummary actualSummary2 = invoiceGenerator.calculateFare(user2Rides);
        userID.put(1,actualSummary1);
        userID.put(2,actualSummary2);
        assertEquals(user1Rides.length,userID.get(1).noOfRides);
        assertEquals(31.25,userID.get(1).avgFare);
        assertEquals(125,userID.get(1).totalFare,0.0);
        assertEquals(user2Rides.length,userID.get(2).noOfRides);
    }

    @Test
    public void givesPremiumRates_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 2;
        double premiumFare = invoiceGenerator.calculatePremiumFare(distance, time);
        assertEquals(20, premiumFare,0.0);
    }

    @Test
    public void givesPremiumRates_ShouldReturnFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2;
        int time = 10;
        double premiumFare = invoiceGenerator.calculatePremiumFare(distance, time);
        assertEquals(50, premiumFare,0.0);
    }
}