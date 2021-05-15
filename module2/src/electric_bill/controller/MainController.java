package electric_bill.controller;

import electric_bill.common.WriterAndReader;
import electric_bill.model.ForeignCustomer;
import electric_bill.model.LocalCustomer;

import java.util.Scanner;

public class MainController {
    static Scanner sc = new Scanner(System.in);
    public void mainMenu(){
        System.out.println("APP MANAGE ELECTRIC BILL\n" +
                "Select option:\n" +
                "1. add new customer.\n" +
                "2. show customer\n" +
                "3. find customer\n" +
                "4. add new bill\n" +
                "5. edit bill\n" +
                "6. show bill\n" +
                "7. exit\n");
        int i = Integer.parseInt(sc.nextLine());
        switch (i){
            case 1:
                addNewCustomer();
                break;
            case 2:
                showCustomer();
                break;
            case 3:
                findCustomer();
                break;
//            case 4:
//                addNewBill();
//                break;
//            case 5:
//                editBill();
//                break;
//            case 6:
//                showBill();
//                break;
            case 7:
                System.exit(0);
        }
    }

    public void addNewCustomer(){
        System.out.println("1.add new local customer\n" +
                "2.add new foreign customer\n" +
                "3.show infor customer\n" +
                "4.exit");
        int i = Integer.parseInt(sc.nextLine());
        switch (i){
            case 1:
                addNewLocal();
                break;
            case 2:
                addNewForeign();
                break;
            case 3:
                mainMenu();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void addNewLocal(){
        System.out.println("enter name");
        String name = sc.nextLine();
        System.out.println("enter id");
        String id = sc.nextLine();
        System.out.println("enter type of");
        String typeOf = sc.nextLine();
        System.out.println("enter consumption");
        String consumption = sc.nextLine();
        LocalCustomer localCustomer = new LocalCustomer(name,id,typeOf,consumption);
        WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\LocalCustomer.csv",localCustomer.toString(),true);
    }

    public void addNewForeign(){
        System.out.println("enter name");
        String name = sc.nextLine();
        System.out.println("enter id");
        String id = sc.nextLine();
        System.out.println("enter passport");
        String passport = sc.nextLine();
        ForeignCustomer foreignCustomer = new ForeignCustomer(name,id,passport);
        WriterAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\ForeignCustomer.csv",foreignCustomer.toString(),true);
    }

    public void showCustomer(){
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\ForeignCustomer.csv");
        WriterAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\electric_bill\\data\\LocalCustomer.csv");
        System.out.println("LOCAL CUSTOMER");
        for (LocalCustomer localCustomer: WriterAndReader.getLocalCustomers()) {
            System.out.println(localCustomer.showInfor());
        }
        System.out.println("FOREIGN CUSTOMER");
        for (ForeignCustomer foreignCustomer: WriterAndReader.getForeignCustomers()) {
            System.out.println(foreignCustomer.showInfor());
        }

    }

    public void findCustomer(){
        System.out.println("enter customer to find:");
        String find = sc.nextLine();
    }
}
