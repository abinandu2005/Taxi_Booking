package com.taxibooking.util;

public class TaxiUtils {

    public static int calculateDistance(char pickup, char drop) {

        int points = Math.abs(drop - pickup);
        return points * 15;
    }

    public static int calculateFare(int distance) {

        if (distance <= 5)
            return 100;

        return 100 + (distance - 5) * 10;
    }
}