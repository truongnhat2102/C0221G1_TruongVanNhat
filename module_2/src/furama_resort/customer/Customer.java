package furama_resort.customer;

import furama_resort.models.Services;
import furama_resort.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {
    private String name;
    final static String NAME_REGEX = "([A-Z][a-z]+)([ ]([A-Z][a-z]+))+";
    private String dayOfBirth;
    final static String DAYOFBIRTH_REGEX = "^([0-2][0-9]|30|31)[/]([0][1-9]|11|12)[/](19[0-9][1-9]|200[0-3])$";
    private String gender;
    final static String GENDER_REGEX = "male|female";
    private String id;
    final static String ID_REGEX = "^[0-9]{3}-[0-9]{3}-[0-9]{3}$";
    private String phoneNumber;
    final static String PHONENUMBER_REGEX = "09[0-9]{8}";
    private String email;
    final static String EMAIL_REGEX = "^[A-Za-z0-9]{6,}@[a-z]{3,4}.[a-z]{2,3}$";
    private String typeOfCustomer;
    final static String TYPEOFCUSTOMER_REGEX = "Diamond|Platinium|Gold|Silver|Member";
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String dayOfBirth, String id, String gender, String phoneNumber, String email, String typeOfCustomer) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.id = id;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public void showInfor() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return getName() +
                "," + getDayOfBirth() +
                "," + getGender() +
                "," + getId() +
                "," + getPhoneNumber() +
                "," + getEmail() +
                "," + getTypeOfCustomer();
    }


    public static void addNewCustomer() {
        while (true) {
            System.out.println("enter name:");
            String name = sc.nextLine();
            while (!Pattern.matches(NAME_REGEX, name)) {
                System.out.println("enter name again example: Nguyen Kien");
                name = sc.nextLine();
            }
            System.out.println("enter day of birth:");
            String dayOfBirth = sc.nextLine();
            while (!Pattern.matches(DAYOFBIRTH_REGEX, dayOfBirth)) {
                System.out.println("enter day of birth example: 01/01/2000");
                dayOfBirth = sc.nextLine();
            }
            System.out.println("enter gender:");
            String gender = sc.nextLine().toLowerCase();
            while (!Pattern.matches(GENDER_REGEX, gender)) {
                System.out.println("enter gender again example: male || female");
                gender = sc.nextLine().toLowerCase();
            }
            System.out.println("enter id:");
            String id = sc.nextLine();
            while (!Pattern.matches(ID_REGEX, id)) {
                System.out.println("enter id again example: 100000001");
                id = sc.nextLine();
            }
            System.out.println("enter phone number:");
            String phoneNumber = sc.nextLine();
            while (!Pattern.matches(PHONENUMBER_REGEX, phoneNumber)) {
                System.out.println("enter phone number again example: 0900000000");
                phoneNumber = sc.nextLine();
            }
            System.out.println("enter email:");
            String email = sc.nextLine();
            while (!Pattern.matches(EMAIL_REGEX, email)) {
                System.out.println("enter email again example: abc123@gmail.com");
                email = sc.nextLine();
            }
            System.out.println("enter type of customer:");
            String typeOfCustomer = sc.nextLine();
            while (!Pattern.matches(TYPEOFCUSTOMER_REGEX, typeOfCustomer)) {
                System.out.println("enter type of customer again example: Diamond|Platinium|Gold|Silver|Member");
                typeOfCustomer = sc.nextLine();
            }
            customers.add(new Customer(name, dayOfBirth, id, gender, phoneNumber, email, typeOfCustomer));
            try {
                FileWriter data = new FileWriter("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\Customer.csv", true);
                BufferedWriter bfw = new BufferedWriter(data);
                for (Customer customer1 : customers) {
                    bfw.write(customer1.toString() + "\n");
                }
                //customers.clear();
                bfw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public static void showInforCustomer() {
        List<Customer> customerArrayList = new ArrayList<>();
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\data\\Customer.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] customer = line.split(",");
                Customer customer1 = new Customer(customer[0],customer[1],customer[2],customer[3],customer[4],customer[5],customer[6]);
                customerArrayList.add(customer1);
            }
            customerArrayList.sort(Comparator.comparing(Customer::getName));
            for (Customer customer: customerArrayList) {
                System.out.println(customer);
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewBooking() {
        showInforCustomer();
        System.out.println("enter customer for booking");
        String search = sc.nextLine();
    }

    public static void main(String[] args) {
        while (true) {
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    showInforCustomer();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
