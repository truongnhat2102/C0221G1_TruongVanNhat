package manage_vehicle.Controller;

import manage_vehicle.Common.WriterAndReader;
import manage_vehicle.Model.Motorbike;
import manage_vehicle.Model.Oto;
import manage_vehicle.Model.Truck;

import java.util.Scanner;

public class MainController {
    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        while (true) {
            System.out.println("Select function:\n" +
                    "1.Add new vehicle\n" +
                    "2.Show vehicle\n" +
                    "3.Delete vehicle\n" +
                    "4.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    showVehicle();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void addNewVehicle() {
        System.out.println("Select vehicle to add:\n" +
                "1.Add new truck\n" +
                "2.Add new oto\n" +
                "3.Add new motorbike\n" +
                "4.Back to menu\n" +
                "5.Exit");
        int i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1:
                addNewTruck();
                break;
            case 2:
                addNewOto();
                break;
            case 3:
                addNewMotorbike();
                break;
            case 4:
                mainMenu();
                break;
            case 5:
                System.exit(0);
        }
    }

    public static void addNewTruck() {
        System.out.println("enter license number:");
        String idNumber = sc.nextLine();
        System.out.println("enter manufacturer ");
        String productOf = sc.nextLine();
        System.out.println("enter year of manufacture");
        String yearOf = sc.nextLine();
        System.out.println("enter name of owner:");
        String owner = sc.nextLine();
        System.out.println("enter payload:");
        String payload = sc.nextLine();
        Truck truck = new Truck(idNumber, productOf, yearOf, owner, payload);
        WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Truck.csv", truck.toString(), true);
    }

    public static void addNewOto() {
        System.out.println("enter license number:");
        String idNumber = sc.nextLine();
        System.out.println("enter manufacturer ");
        String productOf = sc.nextLine();
        System.out.println("enter year of manufacture");
        String yearOf = sc.nextLine();
        System.out.println("enter name of owner:");
        String owner = sc.nextLine();
        System.out.println("enter seats:");
        String seats = sc.nextLine();
        String typeOf = " ";
        if (idNumber.contains("A")) {
            typeOf = "travel";
        } else if (idNumber.contains("B")) {
            typeOf = "coach";
        }
        Oto oto = new Oto(idNumber, productOf, yearOf, owner, seats, typeOf);
        WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Oto.csv", oto.toString(), true);
    }

    public static void addNewMotorbike() {
        System.out.println("enter license number:");
        String idNumber = sc.nextLine();
        System.out.println("enter manufacturer ");
        String productOf = sc.nextLine();
        System.out.println("enter year of manufacture");
        String yearOf = sc.nextLine();
        System.out.println("enter name of owner:");
        String owner = sc.nextLine();
        System.out.println("enter wattage:");
        String wattage = sc.nextLine();
        Motorbike motorbike = new Motorbike(idNumber, productOf, yearOf, owner, wattage);
        WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Motorbike.csv", motorbike.toString(), true);
    }

    public static void showVehicle() {
        System.out.println("select vehicle u want to see\n" +
                "1.Show oto\n" +
                "2.Show truck\n" +
                "3.Show motorbike\n" +
                "4.Back to menu\n");
        int i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1:
                showOto();
                break;
            case 2:
                showTruck();
                break;
            case 3:
                showMotorbike();
                break;
            case 4:
                mainMenu();
        }
    }

    public static void showOto() {
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Oto.csv");
        for (Oto oto : WriterAndReader.getOtos()) {
            System.out.println(oto.showInfor() + "\n");
        }
    }

    public static void showTruck() {
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Truck.csv");
        for (Truck truck : WriterAndReader.getTrucks()) {
            System.out.println(truck.showInfor() + "\n");
        }
    }

    public static void showMotorbike() {
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Motorbike.csv");
        for (Motorbike motorbike : WriterAndReader.getMotorbikes()) {
            System.out.println(motorbike.showInfor() + "\n");
        }
    }

    public static void deleteVehicle() {
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Motorbike.csv");
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Oto.csv");
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Truck.csv");
        System.out.println("enter license number of vehicle:");
        String find = sc.nextLine();
        deleteOto(find);
        deleteTruck(find);
        deleteMotorbike(find);
    }

    public static void deleteOto(String find) {
        for (int i = 0; i < WriterAndReader.getOtos().size(); i++) {
            if (find.equals(WriterAndReader.getOtos().get(i).getIdNumber())) {
                System.out.println(WriterAndReader.getOtos().get(i).showInfor() + "\n" +
                        "do you want to delete this vehicle?\n" +
                        "1.Yes\n" +
                        "2.No");
                int j = Integer.parseInt(sc.nextLine());
                if (j == 1) {
                    WriterAndReader.getOtos().remove(i);
                    System.out.println("done");
                }
            }
        }
        for (int i = 0; i < WriterAndReader.getOtos().size(); i++) {
            if (i == 0) {
                WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Oto.csv", WriterAndReader.getOtos().get(i).toString(), false);
            } else {
                WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Oto.csv", WriterAndReader.getOtos().get(i).toString(), true);
            }
        }
    }

    public static void deleteTruck(String find) {
        for (int i = 0; i < WriterAndReader.getTrucks().size(); i++) {
            if (find.equals(WriterAndReader.getTrucks().get(i).getIdNumber())) {
                System.out.println(WriterAndReader.getTrucks().get(i).showInfor() + "\n" +
                        "do you want to delete this vehicle?\n" +
                        "1.Yes\n" +
                        "2.No");
                int j = Integer.parseInt(sc.nextLine());
                if (j == 1) {
                    WriterAndReader.getTrucks().remove(i);
                    System.out.println("done");
                }
            }
        }
        for (int i = 0; i < WriterAndReader.getTrucks().size(); i++) {
            if (i == 0) {
                WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Truck.csv", WriterAndReader.getTrucks().get(i).toString(), false);
            } else {
                WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Truck.csv", WriterAndReader.getTrucks().get(i).toString(), true);
            }
        }
    }

    public static void deleteMotorbike(String find) {
        for (int i = 0; i < WriterAndReader.getMotorbikes().size(); i++) {
            if (find.equals(WriterAndReader.getMotorbikes().get(i).getIdNumber())) {
                System.out.println(WriterAndReader.getMotorbikes().get(i).showInfor() + "\n" +
                        "do you want to delete this vehicle?\n" +
                        "1.Yes\n" +
                        "2.No");
                int j = Integer.parseInt(sc.nextLine());
                if (j == 1) {
                    WriterAndReader.getMotorbikes().remove(i);
                    System.out.println("done");
                }
            }
        }
        for (int i = 0; i < WriterAndReader.getMotorbikes().size(); i++) {
            if (i == 0) {
                WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Motorbike.csv", WriterAndReader.getMotorbikes().get(i).toString(), false);
            } else {
                WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_vehicle\\Data\\Motorbike.csv", WriterAndReader.getMotorbikes().get(i).toString(), true);
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
