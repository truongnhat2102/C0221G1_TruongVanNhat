package electric_bill.main_controller;

import electric_bill.Bill.BillForeign;
import electric_bill.Bill.BillLocal;
import electric_bill.models.Customer;
import electric_bill.models.InternationalCustomer;
import electric_bill.models.LocalCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner sc = new Scanner(System.in);
    static List<LocalCustomer> localCustomers = new ArrayList<>();
    static List<InternationalCustomer> internationalCustomers = new ArrayList<>();
    static List<BillLocal> billLocals = new ArrayList<>();
    List<BillForeign> billForeigns = new ArrayList<>();

    public static void display() {
        while (true){
            System.out.println("1.Add new Custom\n" +
                    "2.Show custom information\n" +
                    "3.Add new BillLocal\n" +
                    "4.Edit Bill\n" +
                    "5.Show bill\n" +
                    "6.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    addNewCustom();
                    break;
                case 2:
                    showCustom();
                    break;
                case 3:
                    addNewBill();
                    break;
//            case 4:
//                editBill();
//                break;
            case 5:
                showBill();
                break;
                case 6:
                    System.exit(0);
            }
        }
    }

    public static void addNewCustom() {
        while (true){
            System.out.println("1.Add local customer\n" +
                    "2.Add international customer\n" +
                    "3.Back to menu\n" +
                    "4.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    addLocal();
                    break;
                case 2:
                    addInternational();
                    break;
                case 3:
                    display();
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void addLocal() {
        System.out.println("enter ID:");
        String id = sc.nextLine();
        System.out.println("enter name:");
        String name = sc.nextLine();
        System.out.println("enter type of customer:");
        String typeOf = sc.nextLine();
        LocalCustomer localCustomer = new LocalCustomer(id, name, typeOf);
        localCustomers.add(localCustomer);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\LocalCustomer.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(localCustomer.toString()+"\n");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            localCustomers.clear();
        }
    }

    public static void addInternational() {
        System.out.println("enter ID:");
        String id = sc.nextLine();
        System.out.println("enter name:");
        String name = sc.nextLine();
        System.out.println("enter passport:");
        String passport = sc.nextLine();
        InternationalCustomer internationalCustomer = new InternationalCustomer(id, name, passport);
        internationalCustomers.add(internationalCustomer);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\InternationalCustomer.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(internationalCustomer.toString()+"\n");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            internationalCustomers.clear();
        }
    }

    public static void showCustom() {
        while (true){
            System.out.println("what do u want to show:\n" +
                    "1.Show local custom\n" +
                    "2.Show international custom\n" +
                    "3.Show all\n" +
                    "4.Back to menu\n" +
                    "5.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    showLocalCustom();
                    break;
                case 2:
                    showInternationalCustom();
                    break;
                case 3:
                    showLocalCustom();
                    showInternationalCustom();
                    break;
                case 4:
                    display();
                case 5:
                    System.exit(0);
            }
        }
    }

    public static void showLocalCustom() {
        try {
            System.out.println("LOCAL CUSTOM");
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\LocalCustomer.csv");
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

    public static void showInternationalCustom() {
        try {
            System.out.println("INTERNATIONAL CUSTOM");
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\InternationalCustomer.csv");
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

    public static LocalCustomer findLocalCustom(String find) {
        LocalCustomer customerFind = null;
        try {
            System.out.println("LOCAL CUSTOM");
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\LocalCustomer.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;

            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                LocalCustomer localCustomer = new LocalCustomer(arr[0], arr[1], arr[2]);
                localCustomers.add(localCustomer);
            }
            for (LocalCustomer localCustomer : localCustomers) {
                if (find.equals(localCustomer.getName())) {
                    System.out.println(localCustomer.toString());
                    customerFind = localCustomer;
                }
            }
            bfr.close();
            return customerFind;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            localCustomers.clear();
        }
        return null;
    }

    public static InternationalCustomer findForeignCustomer(String find) {
        InternationalCustomer customerFind = null;
            try {
                System.out.println("INTERNATIONAL CUSTOM");
                FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\InternationalCustomer.csv");
                BufferedReader bfr = new BufferedReader(data);
                String line = null;

                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    InternationalCustomer internationalCustomer = new InternationalCustomer(arr[0], arr[1], arr[2]);
                    internationalCustomers.add(internationalCustomer);
                }
                for (InternationalCustomer internationalCustomer : internationalCustomers) {
                    if (find.equals(internationalCustomer.getId())) {
                        System.out.println(internationalCustomer.toString());
                        customerFind = internationalCustomer;
                    }
                }
                bfr.close();
                return customerFind;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                internationalCustomers.clear();
            }
        return null;
    }


    public static void addNewBill() {
        System.out.println("enter name customer to make bill:");
        String find = sc.nextLine();
        LocalCustomer customer = findLocalCustom(find);
        InternationalCustomer customer1 = findForeignCustomer(find);
        System.out.println("enter bill id:");
        String billId = sc.nextLine();
        System.out.println("enter consumption");
        String consumption = sc.nextLine();
        System.out.println("enter date of bill");
        String date = sc.nextLine();
        BillLocal billLocal = new BillLocal(customer.getId(), customer.getName(), customer.getTypeOf(), billId, date, consumption);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\Bill.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(billLocal.toString());
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            billLocals.clear();
        }
        BillForeign billForeign = new BillForeign(customer1.getId(), customer1.getName(), customer1.getPassport(), billId, date, consumption);
        try {
            FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\Bill.csv", true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(billForeign.toString());
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            billLocals.clear();
        }
    }
//    public void editBill(){
//        System.out.println("enter name customer to edit bill:");
//        String find = sc.nextLine();
//        try{
//            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\Bill.csv");
//            BufferedReader bfr = new BufferedReader(data);
//            String line = null;
//            while ((line = bfr.readLine()) != null){
//                String[] arr = line.split(",");
//                if (arr[0].contains("KHTN")){
//                    BillLocal billLocal = new BillLocal(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
//                    billLocals.add(billLocal);
//                }
//                if (arr[0].contains("KHNN")){
//                    BillForeign billForeign = new BillForeign(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
//                    billForeigns.add(billForeign);
//                }
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void showBill(){
        try {
            System.out.println("LOCAL CUSTOM");
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\Bill.csv");
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

    public static void main(String[] args) {
        MainController.display();
    }
}
