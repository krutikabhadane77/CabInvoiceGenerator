package com.cabinvoicegenerator;

public class InvoiceGenerator {
    public static final int normalCostPerTime = 1;
    public static final double normalCostPerKilometer = 10;
    public static final double normalMinFare = 5;
    public static final double premiumCostTime = 2;
    public static final double premiumCostPerKilometer = 15;
    public static final double premiumMinFare = 20;

    public double calculateFare(double distance, int time) {

        double totalFare=(distance*normalCostPerKilometer)+(time*normalCostPerTime);
        return Math.max(totalFare, normalMinFare);
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides)
        {
            double fare = 0 ;
            if (ride.rideType.equalsIgnoreCase("Normal"))
                fare += this.calculateFare(ride.distance, ride.time);
            else if (ride.rideType.equalsIgnoreCase("Premium")) {
                fare += this.calculatePremiumFare(ride.distance, ride.time);
            }
            totalFare += fare;
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculatePremiumFare(double distance, int time) {
        double totalFare = distance * premiumCostPerKilometer + time * premiumCostTime;
        return Math.max(totalFare, premiumMinFare);
    }
}
