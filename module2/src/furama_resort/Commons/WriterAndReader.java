package furama_resort.Commons;

import com.sun.media.jfxmediaimpl.platform.gstreamer.GSTPlatform;
import furama_resort.Models.Customer.Customer;
import furama_resort.Models.Employee.Employee;
import furama_resort.Models.Service.House;
import furama_resort.Models.Service.Room;
import furama_resort.Models.Service.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterAndReader {
    static List<Villa> villas = new ArrayList<>();
    static List<House> houses = new ArrayList<>();
    static List<Room> rooms = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public static String writer(String path, String line, boolean status) {
        try {
            FileWriter data = new FileWriter(path, status);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(line + "\n");
            bfw.close();
            return "done";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "can not write";
    }

    public static void readerService(String path) {
        try {
            FileReader data = new FileReader(path);
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 10) {
                    Villa villa = new Villa(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9]);
                    villas.add(villa);
                } else if (arr.length == 9) {
                    House house = new House(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]);
                    houses.add(house);
                } else if (arr.length == 7) {
                    Room room = new Room(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                    rooms.add(room);
                }
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readerCustomer() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Customer.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                Customer customer = new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                customers.add(customer);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readerEmployee() {
        try {
            FileReader data = new FileReader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\furama_resort\\Data\\Employee.csv");
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                Employee employee = new Employee(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                employees.add(employee);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Villa> getVillas() {
        return villas;
    }

    public static List<House> getHouses() {
        return houses;
    }

    public static List<Room> getRooms() {
        return rooms;
    }

    public static List<Customer> getCustomers(){
        return customers;
    }

    public static List<Employee> getEmployees(){
        return employees;
    }
}
