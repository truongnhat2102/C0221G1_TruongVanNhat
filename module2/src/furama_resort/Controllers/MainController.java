package furama_resort.Controllers;

import furama_resort.Commons.Regex;
import furama_resort.Commons.WriterAndReader;
import furama_resort.Models.Customer.Customer;
import furama_resort.Models.Employee.Employee;
import furama_resort.Models.Service.House;
import furama_resort.Models.Service.Room;
import furama_resort.Models.Service.Villa;
import java.util.Scanner;
import java.util.TreeSet;

public class MainController {
    static Scanner sc = new Scanner(System.in);

    public static void display(){
        while (true){
            System.out.println("1.Add New Service\n" +
                    "2.Show Services\n" +
                    "3.Add New Customer\n" +
                    "4.Show Information of Customer\n" +
                    "5.Add New Booking\n" +
                    "6.Show Information of Employee\n" +
                    "7.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i){
                case 1:
                    addNewService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    showInformationOfCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    public static void addNewService(){
        while (true){
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu\n" +
                    "5.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i){
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    public static void addNewVilla(){
        System.out.println("enter id of service:");
        String id = sc.nextLine();
        while (!Regex.check(Regex.IDVILLA_REGEX,id)){
            System.out.println("enter id of service:");
            id = sc.nextLine();
        }
        String name = "Villa";
        System.out.println("enter area to use:");
        String area = sc.nextLine();
        while (!Regex.check(Regex.AREA_REGEX,area)){
            System.out.println("enter area to use again:");
            area = sc.nextLine();
        }
        System.out.println("enter price:");
        String price = sc.nextLine();
        while (!Regex.check(Regex.PRICE_REGEX,price)){
            System.out.println("enter price:");
            price = sc.nextLine();
        }
        System.out.println("enter max people:");
        String maxPeople = sc.nextLine();
        while (!Regex.check(Regex.PEOPLE_REGEX,maxPeople)){
            System.out.println("enter max people:");
            maxPeople = sc.nextLine();
        }
        System.out.println("enter type of rent");
        String typeOf = sc.nextLine();
        while (!Regex.check(Regex.TYPEOFRENT_REGEX,typeOf)){
            System.out.println("enter type of rent");
            typeOf = sc.nextLine();
        }
        System.out.println("enter standard villa:");
        String standardVilla = sc.nextLine();
        while (!Regex.check(Regex.STANDARD_REGEX,standardVilla)){
            System.out.println("enter type of rent");
            typeOf = sc.nextLine();
        }
        System.out.println("enter description");
        String description = sc.nextLine();
        System.out.println("enter pool area:");
        String poolArea = sc.nextLine();
        while (!Regex.check(Regex.AREA_REGEX,poolArea)){
            System.out.println("enter pool area:");
            poolArea = sc.nextLine();
        }
        System.out.println("enter floor:");
        String floor = sc.nextLine();
        while (!Regex.check(Regex.FLOOR_REGEX,floor)){
            System.out.println("enter floor:");
            floor = sc.nextLine();
        }
        Villa villa = new Villa(id,name,area,price,maxPeople,typeOf,standardVilla,description,poolArea,floor);
        WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Villa.csv",villa.toString(),true);
    }

    public static void addNewHouse(){
        System.out.println("enter id of service:");
        String id = sc.nextLine();
        while (!Regex.check(Regex.IDHOUSE_REGEX,id)){
            System.out.println("enter id of service:");
            id = sc.nextLine();
        }
        String name = "House";
        System.out.println("enter area to use:");
        String area = sc.nextLine();
        while (!Regex.check(Regex.AREA_REGEX,area)){
            System.out.println("enter area to use again:");
            area = sc.nextLine();
        }
        System.out.println("enter price:");
        String price = sc.nextLine();
        while (!Regex.check(Regex.PRICE_REGEX,price)){
            System.out.println("enter price:");
            price = sc.nextLine();
        }
        System.out.println("enter max people:");
        String maxPeople = sc.nextLine();
        while (!Regex.check(Regex.PEOPLE_REGEX,maxPeople)){
            System.out.println("enter max people:");
            maxPeople = sc.nextLine();
        }
        System.out.println("enter type of rent");
        String typeOf = sc.nextLine();
        while (!Regex.check(Regex.TYPEOFRENT_REGEX,typeOf)){
            System.out.println("enter type of rent");
            typeOf = sc.nextLine();
        }
        System.out.println("enter standard house:");
        String standardVilla = sc.nextLine();
        while (!Regex.check(Regex.STANDARD_REGEX,standardVilla)){
            System.out.println("enter type of rent");
            typeOf = sc.nextLine();
        }
        System.out.println("enter description");
        String description = sc.nextLine();
        System.out.println("enter floor:");
        String floor = sc.nextLine();
        while (!Regex.check(Regex.FLOOR_REGEX,floor)){
            System.out.println("enter floor:");
            floor = sc.nextLine();
        }
        House house = new House(id,name,area,price,maxPeople,typeOf,standardVilla,description,floor);
        WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\House.csv",house.toString(),true);
    }

    public static void addNewRoom(){
        System.out.println("enter id of service:");
        String id = sc.nextLine();
        while (!Regex.check(Regex.IDROOMREGEX,id)){
            System.out.println("enter id of service:");
            id = sc.nextLine();
        }
        String name = "Room";
        System.out.println("enter area to use:");
        String area = sc.nextLine();
        while (!Regex.check(Regex.AREA_REGEX,area)){
            System.out.println("enter area to use again:");
            area = sc.nextLine();
        }
        System.out.println("enter price:");
        String price = sc.nextLine();
        while (!Regex.check(Regex.PRICE_REGEX,price)){
            System.out.println("enter price:");
            price = sc.nextLine();
        }
        System.out.println("enter max people:");
        String maxPeople = sc.nextLine();
        while (!Regex.check(Regex.PEOPLE_REGEX,maxPeople)){
            System.out.println("enter max people:");
            maxPeople = sc.nextLine();
        }
        System.out.println("enter type of rent");
        String typeOf = sc.nextLine();
        while (!Regex.check(Regex.TYPEOFRENT_REGEX,typeOf)){
            System.out.println("enter type of rent");
            typeOf = sc.nextLine();
        }
        System.out.println("enter free service:");
        String freeService = sc.nextLine();
        while (!Regex.check(Regex.SERVICE_REGEX,freeService)){
            System.out.println("enter floor:");
            freeService = sc.nextLine();
        }
        Room room = new Room(id,name,area,price,maxPeople,typeOf,freeService);
        WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Room.csv",room.toString(),true);
    }

    public static void showServices(){
        while (true){
            System.out.println("1.Show all Villa\n" +
                    "2.Show all House\n" +
                    "3.Show all Room\n" +
                    "4.Show All Name Villa Not Duplicate\n" +
                    "5.Show All Name House Not Duplicate\n" +
                    "6.Show All Name Name Not Duplicate\n" +
                    "7.Back to menu\n" +
                    "8.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i){
                case 1:
                    showAllVilla();
                    break;
                case 2:
                    showAllHouse();
                    break;
                case 3:
                    showAllRoom();
                    break;
                case 4:
                    showAllNameVillaNotDuplicate();
                    break;
                case 5:
                    showAllNameHouseNotDuplicate();
                    break;
                case 6:
                    showAllNameRoomNotDuplicate();
                    break;
                case 7:
                    display();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void showAllVilla(){
        WriterAndReader.readerService("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Villa.csv");
        for (Villa villa:WriterAndReader.getVillas()) {
            System.out.println(villa.showInfor());
        }
    }

    public static void showAllHouse(){
        WriterAndReader.readerService("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\House.csv");
        for (House house:WriterAndReader.getHouses()) {
            System.out.println(house.showInfor());
        }
    }

    public static void showAllRoom(){
        WriterAndReader.readerService("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Room.csv");
        for (Room room:WriterAndReader.getRooms()) {
            System.out.println(room.showInfor()+"\n");
        }
    }

    public static void addNewCustomer(){
        System.out.println("enter name:");
        String name = sc.nextLine();
        while (!Regex.check(Regex.NAMEPERSON_REGEX,name)){
            System.out.println("enter name:");
            name = sc.nextLine();
        }
        System.out.println("enter date of birth:");
        String dateOfBirth = sc.nextLine();
        while (!Regex.check(Regex.DATEOFBIRTH_REGEX,dateOfBirth)){
            System.out.println("enter date of birth:");
            dateOfBirth = sc.nextLine();
        }
        System.out.println("enter gender:");
        String gender = sc.nextLine();
        while (!Regex.check(Regex.GENDER_REGEX,gender.toLowerCase())){
            System.out.println("enter date of birth:");
            gender = sc.nextLine();
        }
        System.out.println("enter id:");
        String id = sc.nextLine();
        while (!Regex.check(Regex.IDCUSTOMER_REGEX,id)){
            System.out.println("enter id:");
            id = sc.nextLine();
        }
        System.out.println("enter phone:");
        String phone = sc.nextLine();
        while (!Regex.check(Regex.PHONE_REGEX,phone)){
            System.out.println("enter phone:");
            phone = sc.nextLine();
        }
        System.out.println("enter email:");
        String email = sc.nextLine();
        while (!Regex.check(Regex.EMAIL_REGEX,email)){
            System.out.println("enter email:");
            email = sc.nextLine();
        }
        System.out.println("enter type of customer:");
        String typeOf = sc.nextLine();
        System.out.println("enter address:");
        String address = sc.nextLine();
        Customer customer = new Customer(name,dateOfBirth,gender,id,phone,email,typeOf,address);
        WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Customer.csv",customer.toString(),true);
    }

    public static void showInformationOfCustomer(){
        WriterAndReader.readerCustomer();
        int i = 1;
        for (Customer customer:WriterAndReader.getCustomers()) {
            System.out.println((i++) + "." + customer.showInfor() +" \n");
        }
    }

    public static void addNewBooking(){
        int i = 1;
        for (Customer customer:WriterAndReader.getCustomers()) {
            System.out.println((i++) + "." + customer.showInfor() +" \n");
        }
        System.out.println("enter serial customer to add new booking:");
        int j = Integer.parseInt(sc.nextLine());
        for (int k=0; k<WriterAndReader.getCustomers().size(); k++) {
            if (j==k){
                System.out.println("1.Booking Villa\n" +
                        "2.Booking House\n" +
                        "3.Booking Room\n");
                int n = Integer.parseInt(sc.nextLine());
                switch (n){
                    case 1:
                        addNewBookingVilla(WriterAndReader.getCustomers().get(k).showInfor());
                        break;
                    case 2:
                        addNewBookingHouse(WriterAndReader.getCustomers().get(k).showInfor());
                        break;
                    case 3:
                        addNewBookingRoom(WriterAndReader.getCustomers().get(k).showInfor());
                        break;
                }
            }
        }
    }

    public static void addNewBookingVilla(String customerInformation){
        showAllVilla();
        System.out.println("enter service id:");
        String find = sc.nextLine();
        for (Villa villa:WriterAndReader.getVillas()) {
            if (find.equals(villa.getId())){
                String information = customerInformation + "booking" + villa.showInfor();
                WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Booking.csv",information,true);
                System.out.println("done");
            }
        }
    }

    public static void addNewBookingHouse(String customerInformation){
        showAllHouse();
        System.out.println("enter service id:");
        String find = sc.nextLine();
        for (House house:WriterAndReader.getHouses()) {
            if (find.equals(house.getId())){
                String information = customerInformation + "booking" + house.showInfor();
                WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Booking.csv",information,true);
                System.out.println("done");
            }
        }
    }

    public static void addNewBookingRoom(String customerInformation){
        showAllRoom();
        System.out.println("enter service id:");
        String find = sc.nextLine();
        for (Room room:WriterAndReader.getRooms()) {
            if (find.equals(room.getId())){
                String information = customerInformation + "booking" + room.showInfor();
                WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Booking.csv",information,true);
                System.out.println("done");
            }
        }
    }

    public static void showInformationOfEmployee(){
        WriterAndReader.readerEmployee();
        for (Employee employee:WriterAndReader.getEmployees()){
            System.out.println(employee.showInfor()+"\n");
        }
    }

    public static void showAllNameVillaNotDuplicate(){
        TreeSet<Villa> villas = new TreeSet<>();
        for (int i = 0; i < WriterAndReader.getVillas().size(); i++) {
            villas.add(WriterAndReader.getVillas().get(i));
        }
        for (Villa villa:villas) {
            System.out.println(villa.showInfor());
        }
    }

    public  static void showAllNameHouseNotDuplicate(){
        TreeSet<House> houses = new TreeSet<>();
        for (int i = 0; i < WriterAndReader.getHouses().size(); i++) {
            houses.add(WriterAndReader.getHouses().get(i));
        }
        for (House house:houses) {
            System.out.println(house.showInfor());
        }
    }

    public  static void showAllNameRoomNotDuplicate(){
        TreeSet<Room> rooms = new TreeSet<>();
        for (int i = 0; i < WriterAndReader.getRooms().size(); i++) {
            rooms.add(WriterAndReader.getRooms().get(i));
        }
        for (Room room:rooms) {
            System.out.println(room.showInfor());
        }
    }



    public static void main(String[] args) {
        display();
    }
}
