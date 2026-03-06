package com.taxibooking.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    public int taxiId;            
    public char currentLocation;   
    public int availableTime;       
    public int totalEarnings;      
    public List<Booking> bookingHistory;  

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentLocation = 'A';
        this.availableTime = 0;
        this.totalEarnings = 0;
        this.bookingHistory = new ArrayList<>();
    }
    public int getTaxiId() {
        return taxiId;
    }
    public char getCurrentLocation() {
        return currentLocation;
    }
    public int getAvailableTime() {
        return availableTime;
    }
    public int getTotalEarnings() {
        return totalEarnings;
    }
    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }
}