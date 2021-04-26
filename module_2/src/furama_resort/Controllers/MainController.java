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
    final static String ID_VILLA_REGEX= "^SVVL-[0-9]{4}$";
    final static String ID_HOUSE_REGEX= "^SVHO-[0-9]{4}$";
    final static String ID_ROOM_REGEX= "^SVRO-[0-9]{4}$";
    final static String SERVICE_NAME_REGEX= "^[A-Z][a-z]{1,}$";
    final static String AREA_REGEX= "^[1-9][0-9]{2,10}|[0][3-9][0-9]$";
    final static String COST_REGEX= "^[0-9][0]{6,}$";
    final static String PEOPLE_REGEX= "^[0-1][0-9]$";
    final static String FREE_SERVICE_REGEX= "^massage||karaoke||food||drink||car$";
    final static String FLOORS_REGEX= "^[0-9]{1,10}$";
    final static String RENT_REGEX= "^day|month|year$";
    final static String DAY_REGEX= "^([0-2][0-9]|30|31)[/]([0][1-9]|11|12)[/](19[0-9][1-9]|200[0-3])$";
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
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
            }
        }
    }


    public static void addNewServices() {
        while (true) {
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to Menu\n" +
                    "5.Exit");
            switch (sc.nextLine()) {
                case "1":
                    addVilla();
                    break;
                case "2":
                    addHouse();
                    break;
                case "3":
                    addRoom();
                    break;
                case "4":
                    displayMenu();
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }

    public static void addVilla() {
        System.out.println("enter id");
        String id = sc.nextLine();
        while (!Pattern.matches(ID_VILLA_REGEX,id)){
            System.out.println("enter id SVVL-YYYY");
            id = sc.nextLine();
        }
        System.out.println("enter name");
        String name = sc.nextLine();
        while (!Pattern.matches(SERVICE_NAME_REGEX,name)){
            System.out.println("enter name FIRST IS UPPERCASE");
            name = sc.nextLine();
        }
        System.out.println("enter area use");
        String area = sc.nextLine();
        while (!Pattern.matches(AREA_REGEX,area)){
            System.out.println("enter area >30");
            area = sc.nextLine();
        }
        System.out.println("enter cost");
        String cost = sc.nextLine();
        while (!Pattern.matches(COST_REGEX,cost)){
            System.out.println("enter cost just number");
            cost = sc.nextLine();
        }
        System.out.println("enter people");
        String people = sc.nextLine();
        while (!Pattern.matches(PEOPLE_REGEX,people)){
            System.out.println("enter area 0< && <30");
            people = sc.nextLine();
        }
        System.out.println("enter rent type");
        String rentType = sc.nextLine();
        while (!Pattern.matches(RENT_REGEX,rentType)){
            System.out.println("enter rent type: day || month || year");
            rentType = sc.nextLine();
        }
        System.out.println("enter standard room");
        String standardRoom = sc.nextLine();
        System.out.println("enter description");
        String description = sc.nextLine();
        System.out.println("enter floors");
        String floors = sc.nextLine();
        while (!Pattern.matches(FLOORS_REGEX,floors)){
            System.out.println("enter floors just number");
            floors = sc.nextLine();
        }
        System.out.println("enter poor areas");
        String poorArea = sc.nextLine();
        while (!Pattern.matches(AREA_REGEX,poorArea)){
            System.out.println("enter area 0< && <30");
            poorArea = sc.nextLine();
        }
        Villa villa = new Villa(id, name, area, cost, people, rentType, standardRoom, description, floors, poorArea);
        villas.add(villa);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\Villa.csv");
            BufferedWriter bfw = new BufferedWriter(data);
            for (Villa villa1 : villas) {
                bfw.write(villa1.toString());
            }
            //data.close();
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHouse() {
        System.out.println("enter id");
        String id = sc.nextLine();
        while (!Pattern.matches(ID_VILLA_REGEX,id)){
            System.out.println("enter id SVVL-YYYY");
            id = sc.nextLine();
        }
        System.out.println("enter name");
        String name = sc.nextLine();
        while (!Pattern.matches(SERVICE_NAME_REGEX,name)){
            System.out.println("enter name FIRST IS UPPERCASE");
            name = sc.nextLine();
        }
        System.out.println("enter area use");
        String area = sc.nextLine();
        while (!Pattern.matches(AREA_REGEX,area)){
            System.out.println("enter area >30");
            area = sc.nextLine();
        }
        System.out.println("enter cost");
        String cost = sc.nextLine();
        while (!Pattern.matches(COST_REGEX,cost)){
            System.out.println("enter cost just number");
            cost = sc.nextLine();
        }
        System.out.println("enter people");
        String people = sc.nextLine();
        while (!Pattern.matches(PEOPLE_REGEX,people)){
            System.out.println("enter area 0< && <30");
            people = sc.nextLine();
        }
        System.out.println("enter rent type");
        String rentType = sc.nextLine();
        while (!Pattern.matches(RENT_REGEX,rentType)){
            System.out.println("enter rent type: day || month || year");
            rentType = sc.nextLine();
        }
        System.out.println("enter standard room");
        String standardRoom = sc.nextLine();
        System.out.println("enter description");
        String description = sc.nextLine();
        System.out.println("enter floors");
        String floors = sc.nextLine();
        while (!Pattern.matches(FLOORS_REGEX,floors)){
            System.out.println("enter floors just number");
            floors = sc.nextLine();
        }
        House house = new House(id, name, area, cost, people, rentType, standardRoom, description, floors);
        houses.add(house);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\House.csv");
            BufferedWriter bfw = new BufferedWriter(data);
            for (House house1 : houses) {
                bfw.write(house1.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addRoom() {
        System.out.println("enter id");
        String id = sc.nextLine();
        while (!Pattern.matches(ID_VILLA_REGEX,id)){
            System.out.println("enter id SVVL-YYYY");
            id = sc.nextLine();
        }
        System.out.println("enter name");
        String name = sc.nextLine();
        while (!Pattern.matches(SERVICE_NAME_REGEX,name)){
            System.out.println("enter name FIRST IS UPPERCASE");
            name = sc.nextLine();
        }
        System.out.println("enter area use");
        String area = sc.nextLine();
        while (!Pattern.matches(AREA_REGEX,area)){
            System.out.println("enter area >30");
            area = sc.nextLine();
        }
        System.out.println("enter cost");
        String cost = sc.nextLine();
        while (!Pattern.matches(COST_REGEX,cost)){
            System.out.println("enter cost just number");
            cost = sc.nextLine();
        }
        System.out.println("enter people");
        String people = sc.nextLine();
        while (!Pattern.matches(PEOPLE_REGEX,people)){
            System.out.println("enter area 0< && <30");
            people = sc.nextLine();
        }
        System.out.println("enter rent type");
        String rentType = sc.nextLine();
        while (!Pattern.matches(RENT_REGEX,rentType)){
            System.out.println("enter rent type: day || month || year");
            rentType = sc.nextLine();
        }
        System.out.println("enter free service");
        String freeService = sc.nextLine();
        while (!Pattern.matches(FREE_SERVICE_REGEX,freeService)){
            System.out.println("enter area 0< && <30");
            freeService = sc.nextLine();
        }
        Room room = new Room(id, name, area, cost, people, rentType, freeService);
        rooms.add(room);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\Room.csv");
            BufferedWriter bfw = new BufferedWriter(data);
            for (Room room1 : rooms) {
                bfw.write(room1.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                    displayMenu();
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


    public static void main(String[] args) {
        MainController.displayMenu();
    }
}
