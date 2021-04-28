package manage_vehicles.main_controller;

import manage_vehicles.vehicle.Motorbike;
import manage_vehicles.vehicle.Oto;
import manage_vehicles.vehicle.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainController {
    static Scanner sc = new Scanner(System.in);
    final static String NUMBER_TRUCK_REGEX = "[0-9]{2}C-[0-9]{5}";
    final static String NUMBER_OTO_REGEX = "[0-9]{2}[AB]-[0-9]{5}";
    final static String NUMBER_MOTORBIKE_REGEX = "[0-9]{2}-[A-Z][0-9A-Z]-[0-9]{5}";
    final static String PPRODUCTOF_REGEX = "[A-Z][a-z]+";
    final static String YEAR_REGEX = "19[5-9][0-9]|20[0-1][0-9]|2020";
    final static String NAME_OWNER_REGEX = "[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+(([ ][A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+)|([ ][A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ]))+";
    final static String JUSTNUMBER_REGEX = "[0-9]+";
    static ArrayList<Oto> otos = new ArrayList<>();
    static ArrayList<Truck> trucks = new ArrayList<>();
    static ArrayList<Motorbike> motorbikes = new ArrayList<>();

    public static void displayMethod() {
        while (true) {
            System.out.println("APP OF MANAGE VEHICLES:\n" +
                    "select method\n" +
                    "1.Add vehicle:\n" +
                    "2.Show vehicles\n" +
                    "3.Delete vehicles\n" +
                    "4.Exit");
            String i = sc.nextLine();
            while (!Pattern.matches(JUSTNUMBER_REGEX, i)) {
                System.out.println("enter just number:");
                i = sc.nextLine();
            }
            int a = Integer.parseInt(i);
            switch (a) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    showAllVehicle();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void addNewVehicle() {
        while (true) {
            System.out.println("1.Add new Oto\n" +
                    "2.Add new Truck\n" +
                    "3.Add new Motorbike\n" +
                    "4.Back to menu\n" +
                    "5.Exit");
            String i = sc.nextLine();
            while (!Pattern.matches(JUSTNUMBER_REGEX, i)) {
                System.out.println("enter just number:");
                i = sc.nextLine();
            }
            int a = Integer.parseInt(i);
            switch (a) {
                case 1:
                    addNewOto();
                    break;
                case 2:
                    addNewTruck();
                    break;
                case 3:
                    addNewMotorbike();
                    break;
                case 4:
                    displayMethod();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    public static void addNewOto() {
        System.out.println("enter number of vehicle");
        String number = sc.nextLine();
        while (!Pattern.matches(NUMBER_OTO_REGEX, number)) {
            System.out.println("enter number of oto again:");
            number = sc.nextLine();
        }
        System.out.println("enter product of:");
        String productOf = sc.nextLine();
        while (!Pattern.matches(PPRODUCTOF_REGEX, productOf)) {
            System.out.println("enter product of again:");
            productOf = sc.nextLine();
        }
        System.out.println("enter year of manufacture:");
        String yearFrom = sc.nextLine();
        while (!Pattern.matches(YEAR_REGEX, yearFrom)) {
            System.out.println("enter year of manufacture again:");
            yearFrom = sc.nextLine();
        }
        System.out.println("enter name of owner:");
        String owner = sc.nextLine();
        while (!Pattern.matches(NAME_OWNER_REGEX, owner)) {
            System.out.println("enter name of owner again:");
            owner = sc.nextLine();
        }
        System.out.println("enter number of seats:");
        String seats = sc.nextLine();
        while (!Pattern.matches(JUSTNUMBER_REGEX, seats)) {
            System.out.println("enter number of seats again:");
            seats = sc.nextLine();
        }
        String typeOf = checkTypeOfOto(number);
        Oto oto = new Oto(number, productOf, yearFrom, owner, seats, typeOf);
        otos.add(oto);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Oto.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(oto.toString() + "\n");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String checkTypeOfOto(String number) {
        String[] arr = number.split("");
        if (arr[2].equals("A")) {
            return "vacation oto";
        } else if (arr[2].equals("B")) {
            return "bus";
        }
        return null;
    }

    public static void addNewTruck() {
        System.out.println("enter number of vehicle");
        String number = sc.nextLine();
        while (!Pattern.matches(NUMBER_TRUCK_REGEX, number)) {
            System.out.println("enter number of truck again:");
            number = sc.nextLine();
        }
        System.out.println("enter product of:");
        String productOf = sc.nextLine();
        while (!Pattern.matches(PPRODUCTOF_REGEX, productOf)) {
            System.out.println("enter product of again:");
            productOf = sc.nextLine();
        }
        System.out.println("enter year of manufacture:");
        String yearFrom = sc.nextLine();
        while (!Pattern.matches(YEAR_REGEX, yearFrom)) {
            System.out.println("enter year of manufacture again:");
            yearFrom = sc.nextLine();
        }
        System.out.println("enter name of owner:");
        String owner = sc.nextLine();
        while (!Pattern.matches(NAME_OWNER_REGEX, owner)) {
            System.out.println("enter name of owner again:");
            owner = sc.nextLine();
        }
        System.out.println("enter number of payload:");
        String payload = sc.nextLine();
        while (!Pattern.matches(JUSTNUMBER_REGEX, payload)) {
            System.out.println("enter number of payload again:");
            payload = sc.nextLine();
        }
        Truck truck = new Truck(number, productOf, yearFrom, owner, payload);
        trucks.add(truck);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Truck.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(truck.toString() + "\n");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewMotorbike() {
        System.out.println("enter number of vehicle");
        String number = sc.nextLine();
        while (!Pattern.matches(NUMBER_MOTORBIKE_REGEX, number)) {
            System.out.println("enter number of motorbike again:");
            number = sc.nextLine();
        }
        System.out.println("enter product of:");
        String productOf = sc.nextLine();
        while (!Pattern.matches(PPRODUCTOF_REGEX, productOf)) {
            System.out.println("enter product of again:");
            productOf = sc.nextLine();
        }
        System.out.println("enter year of manufacture:");
        String yearFrom = sc.nextLine();
        while (!Pattern.matches(YEAR_REGEX, yearFrom)) {
            System.out.println("enter year of manufacture again:");
            yearFrom = sc.nextLine();
        }
        System.out.println("enter name of owner:");
        String owner = sc.nextLine();
        while (!Pattern.matches(NAME_OWNER_REGEX, owner)) {
            System.out.println("enter name of owner again:");
            owner = sc.nextLine();
        }
        System.out.println("enter number of payload:");
        String wattage = sc.nextLine();
        while (!Pattern.matches(JUSTNUMBER_REGEX, wattage)) {
            System.out.println("enter number of payload again:");
            wattage = sc.nextLine();
        }
        Motorbike motorbike = new Motorbike(number, productOf, yearFrom, owner, wattage);
        motorbikes.add(motorbike);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Motorbike.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(motorbike.toString() + "\n");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllVehicle() {
        System.out.println("1.Show All Oto\n" +
                "2.Show All Truck\n" +
                "3.Show All Motorbike\n" +
                "4.Back to menu\n" +
                "5.Exit");
        int i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1:
                showAllOto();
                break;
            case 2:
                showAllTruck();
                break;
            case 3:
                showAllMotorbike();
                break;
            case 4:
                displayMethod();
                break;
            case 5:
                System.exit(0);
        }
    }

    public static void showAllOto() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Oto.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllTruck() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Truck.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllMotorbike() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Motorbike.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        System.out.println("1.Delete Oto\n" +
                "2.Delete Truck\n" +
                "3.Delete Motorbike\n" +
                "4.Back to menu\n" +
                "5.Exit");
        int i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1:
                deleteOto();
                break;
            case 2:
                deleteTruck();
                break;
            case 3:
                deleteMotorbike();
                break;
            case 4:
                displayMethod();
                break;
            case 5:
                System.exit(0);
        }
    }

    private static void deleteMotorbike() {
        List<Motorbike> motorbikes = new ArrayList<>();
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Motorbike.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] str = line.split(",");
                Motorbike motorbike = new Motorbike(str[0], str[1], str[2], str[3], str[4]);
                motorbikes.add(motorbike);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter number of Motorbike to delete:");
        for (Motorbike motorbike : motorbikes) {
            if (sc.nextLine() == motorbike.getNumber()) {
                motorbikes.remove(motorbike.getNumber());
            }
        }
        try {
            FileWriter rewrite = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Motobike.csv");
            BufferedWriter bfw = new BufferedWriter(rewrite);
            for (Motorbike motorbike : motorbikes) {
                bfw.write(motorbike.toString());
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void deleteTruck() {
        List<Truck> trucks = new ArrayList<>();
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Truck.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] str = line.split(",");
                Truck truck = new Truck(str[0], str[1], str[2], str[3], str[4]);
                trucks.add(truck);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter number of Motorbike to delete:");
        for (Truck truck : trucks) {
            if (sc.nextLine() == truck.getNumber()) {
                trucks.remove(truck);
            }
        }
        try {
            FileWriter rewrite = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Truck.csv");
            BufferedWriter bfw = new BufferedWriter(rewrite);
            for (Truck truck : trucks) {
                bfw.write(truck.toString());
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteOto() {
        List<Oto> otos = new ArrayList<>();
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Oto.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] str = line.split(",");
                Oto oto = new Oto(str[0], str[1], str[2], str[3], str[4], str[5]);
                otos.add(oto);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter number of oto to delete:");
        String find = sc.nextLine();
        for (Oto oto : otos) {
            if (find.equals(oto.getNumber())) {
                System.out.println("do you want to delete?");
                String confirm = sc.nextLine();
                if (confirm.toLowerCase().equals("yes")) {
                    otos.remove(oto);
                }
            }
        }
        try {
            FileWriter rewrite = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicles\\data\\Oto.csv");
            BufferedWriter bfw = new BufferedWriter(rewrite);
            for (Oto oto : otos) {
                bfw.write(oto.toString() + "\n");
            }
            System.out.println("done");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        displayMethod();
    }


}
