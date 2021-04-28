package furama_resort.Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Show {
    static Scanner sc = new Scanner(System.in);
    public static void showServices() {
        while (true) {
            System.out.println("" +
                    "1.Show all Villa\n" +
                    "2.Show all House\n" +
                    "3.Show all Room\n" +
                    "4.Show all Name Villa not Duplicate\n" +
                    "5.Show all Name House not Duplicate\n" +
                    "6.Show all Name Room not Duplicate\n" +
                    "7.Back to Menu\n" +
                    "8.Exit");
            switch (sc.nextLine()) {
                case "1":
                    showAllVilla();
                    break;
                case "2":
                    showAllHouse();
                    break;
                case "3":
                    showAllRoom();
                    break;
                case "4":
                case "5":
                case "6":
                case "7":
                    MainController.displayMenu();
                    break;
                case "8":
                    System.exit(0);
            }
        }
    }

    public static void showAllVilla() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\Villa.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllHouse() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\House.csv");
            BufferedReader bfr = new BufferedReader(data);
            while (bfr.readLine() != null) {
                System.out.println(bfr.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllRoom() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\Room.csv");
            BufferedReader bfr = new BufferedReader(data);
            while (bfr.readLine() != null) {
                System.out.println(bfr.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
