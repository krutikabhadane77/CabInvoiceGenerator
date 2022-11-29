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
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        assertEquals(5.0, invoiceGenerator.calculateFare(0.1, 1), 0.0);
    }

    @Test
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
    }
}