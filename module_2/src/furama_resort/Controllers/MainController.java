package furama_resort.Controllers;

import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    private static Scanner sc = new Scanner(System.in);
    private static Pattern pattern;
    private Matcher matcher;

    static ArrayList<Villa> villas = new ArrayList();
    static ArrayList<House> houses = new ArrayList();
    static ArrayList<Room> rooms = new ArrayList();

    public static void displayMenu() {
        while (true) {
            System.out.println("" +
                    "1.Add New Services\n" +
                    "2.Show Services\n" +
                    "3.Show Information of Customer\n" +
                    "4.Show information of Customer\n" +
                    "5.Add New Booking\n" +
                    "6.Show Information of Employee\n" +
                    "7.Exit");
            switch (sc.nextLine()) {
                case "1":
                    Add.addNewServices();
                    break;
                case "2":
                    Show.showServices();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MainController.displayMenu();
    }
}
