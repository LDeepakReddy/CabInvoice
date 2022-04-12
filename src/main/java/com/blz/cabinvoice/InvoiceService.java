package com.blz.cabinvoice;

public class InvoiceService {
    RideRepository rideRepository=new RideRepository();
    private static final int COST_PER_KM = 10, COST_PER_MINUTE = 1, MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = (COST_PER_KM * distance) + (time * COST_PER_MINUTE);
//        if (totalFare < MINIMUM_FARE)
//            return MINIMUM_FARE;
//        return totalFare;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    public InvoiceSummery calculateTotalFare(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummery(rides.length, totalFare);
    }

    public void addRide(String userId, Ride[] rides) {
       rideRepository.addRide(userId,rides);
    }

    public InvoiceSummery getInvoiceSummery(String userId) {
        Ride[] rides=rideRepository.getRides(userId);
        return calculateTotalFare(rides);

    }
}
