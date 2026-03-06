package com.taxibooking.main;

import java.util.Scanner;
import com.taxibooking.service.TaxiService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Taxi Booking System =====");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();
            TaxiService taxiService = new TaxiService(4);
            switch (userChoice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter Pickup Point (A-F): ");
                    char pickupPoint = scanner.next().toUpperCase().charAt(0);
                    System.out.print("Enter Drop Point (A-F): ");
                    char dropPoint = scanner.next().toUpperCase().charAt(0);
                    System.out.print("Enter Pickup Time: ");
                    int pickupTime = scanner.nextInt();
                    taxiService.bookTaxi(customerId, pickupPoint, dropPoint, pickupTime);
                    break;
                case 2:
                    taxiService.displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Thank you for using Taxi Booking System!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}