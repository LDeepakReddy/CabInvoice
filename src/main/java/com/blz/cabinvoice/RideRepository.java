package com.blz.cabinvoice;

import java.util.*;

public class RideRepository {
    Map<String, Ride[]> userRide = new HashMap<>();

    public void addRide(String userId, Ride[] rides) {
        userRide.put(userId, rides);

    }
    public Ride[] getRides(String userID){
        return userRide.get(userID);
    }
}
