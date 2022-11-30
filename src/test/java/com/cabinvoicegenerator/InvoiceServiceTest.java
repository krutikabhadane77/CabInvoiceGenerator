package com.cabinvoicegenerator;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void init() {
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        assertEquals(5.0, invoiceGenerator.calculateFare(0.1, 1), 0.0);
    }

  /*  @Test
    public void givenNoDistanceButLessTime_ShouldReturnMinFare() {
        double distance = 0;
        int timeInMins = 5;
        double fare=invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(5.0, fare);
    }

    @Test
    public void givenNoDistanceAndTime_ShouldAlsoReturnMinFare() {
        double distance = 0;
        int timeInMins = 0;
        double fare=invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(5.0, fare);
    }*/

    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary() {
        Rides[] rides = {new Rides(2.0,5),
                new Rides(0.1,1)};
        InvoiceSummary actualSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary,actualSummary);
    }

    @Test
    public void getListofRides_UsingId(){
        Rides[] rides = {new Rides(2.0,5),
                new Rides(0.1,1)};
        InvoiceSummary actualSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary id=new InvoiceSummary(2,30.0);
        id.setUserId(1,actualSummary);
        Map<Integer,InvoiceSummary>userId=new HashMap<>();
        for (Map.Entry<Integer,InvoiceSummary>integerInvoiceSummaryEntry:userId.entrySet()){
            integerInvoiceSummaryEntry.getValue();
        }
        assertEquals(userId,id.getUserId());
    }


}