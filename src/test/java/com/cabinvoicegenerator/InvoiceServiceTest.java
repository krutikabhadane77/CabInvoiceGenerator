package com.cabinvoicegenerator;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void init() {
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int timeInMins = 5;
        double fare = invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(25.0, fare);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int timeInMins =1;
        double fare = invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(5.0, fare);
    }

    @Test   // In case of lots of traffic
    public void givenNoDistanceButLessTime_ShouldReturnMinFare() {
        double distance = 0;
        int timeInMins = 5;
        double fare=invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(5.0, fare);
    }

    @Test  //In case of cancellation of booking
    public void givenNoDistanceAndTime_ShouldAlsoReturnMinFare() {
        double distance = 0;
        int timeInMins = 0;
        double fare=invoiceGenerator.calculateFare(distance, timeInMins);
        assertEquals(5.0, fare);
    }
}