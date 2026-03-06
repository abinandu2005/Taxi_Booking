package com.taxibooking.service;

import java.util.ArrayList;
import java.util.List;

import com.taxibooking.model.Booking;
import com.taxibooking.model.Taxi;
import com.taxibooking.util.TaxiUtils;

public class TaxiService {

    static List<Taxi> taxis = new ArrayList<>();
    static int bookingId = 1;

    public TaxiService(int taxiCount) {

        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char pickup, char drop, int pickupTime) {

        Taxi selectedTaxi = null;
        int minimumDistance = Integer.MAX_VALUE;
        int minimumEarnings = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {

            int distance = Math.abs(taxi.currentLocation - pickup);

            if (taxi.availableTime <= pickupTime) {

                if (distance < minimumDistance ||
                        (distance == minimumDistance && taxi.totalEarnings < minimumEarnings)) {

                    selectedTaxi = taxi;
                    minimumDistance = distance;
                    minimumEarnings = taxi.totalEarnings;
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("Booking Rejected. No Taxi Available.");
            return;
        }

        int distanceKm = TaxiUtils.calculateDistance(pickup, drop);
        int fare = TaxiUtils.calculateFare(distanceKm);

        int dropTime = pickupTime + Math.abs(drop - pickup);

        Booking booking = new Booking(
                bookingId++,
                customerId,
                pickup,
                drop,
                pickupTime,
                dropTime,
                fare);

        selectedTaxi.bookingHistory.add(booking);
        selectedTaxi.totalEarnings += fare;
        selectedTaxi.currentLocation = drop;
        selectedTaxi.availableTime = dropTime;

        System.out.println("Taxi-" + selectedTaxi.taxiId + " is allotted.");
    }

    public void displayTaxiDetails() {

        for (Taxi taxi : taxis) {

            System.out.println("\nTaxi-" + taxi.taxiId +
                    " Total Earnings: Rs." + taxi.totalEarnings);

            System.out.println("BookingID CustomerID From To PickupTime DropTime Amount");

            for (Booking booking : taxi.bookingHistory) {

                System.out.println(
                        booking.bookingId + "        " +
                        booking.customerId + "        " +
                        booking.from + "     " +
                        booking.to + "     " +
                        booking.pickupTime + "        " +
                        booking.dropTime + "        " +
                        booking.amount);
            }
        }
    }
}