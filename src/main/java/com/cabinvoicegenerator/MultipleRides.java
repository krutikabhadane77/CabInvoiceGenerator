package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleRides {
    List<Rides> rideList = new ArrayList<>();
    double totalFare = 0;
    static Scanner scan = new Scanner(System.in);

    public void addRides() {
        System.out.println("Enter how many rides that an user has taken");
        int rideCount = scan.nextInt();
        for (int i = 1; i <= rideCount; i++)
        {
            double distance = scan.nextDouble();
            int timeInMins = scan.nextInt();
            Rides rides = new Rides(distance, timeInMins);
            rideList.add(rides);
            InvoiceGenerator obj = new InvoiceGenerator();
            double fare = obj.calculateFare(distance, timeInMins);
            totalFare += fare;
        }
    }

    public double getTotalFare() {
        return totalFare;
    }
}
