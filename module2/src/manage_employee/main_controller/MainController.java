package manage_employee.main_controller;

import manage_employee.common.WriterAndReader;
import manage_employee.models.Employee;
import manage_employee.models.Staff;
import manage_employee.models.Worker;

import java.util.*;

public class MainController {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("1.Add new employee\n" +
                    "2.Find by name\n" +
                    "3.Sort by name\n" +
                    "4.Show employee\n" +
                    "5.Exit");
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    sortByName();
                    break;
                case 4:
                    showEmployee();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    public static void addNewEmployee() {
        System.out.println("enter name:");
        String name = sc.nextLine();
        System.out.println("enter date of birth:");
        String dateOfBirth = sc.nextLine();
        System.out.println("enter gender:");
        String gender = sc.nextLine();
        System.out.println("enter address:");
        String address = sc.nextLine();
        System.out.println("enter type of employee:\n" +
                "1.Worker\n" +
                "2.Engineer\n" +
                "3.Staff");
        int i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1:
                System.out.println("enter class of worker:");
                String claass = sc.nextLine();
                Employee newWorker = new Worker(name, dateOfBirth, gender, address, claass);
                WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv", newWorker.toString(),true);
                break;
            case 2:
                System.out.println("enter major of engineer:");
                String major = sc.nextLine();
                Employee newEngineer = new Worker(name, dateOfBirth, gender, address, major);
                WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv", newEngineer.toString(),true);
                break;
            case 3:
                System.out.println("enter job of staff:");
                String job = sc.nextLine();
                Employee newStaff = new Staff(name, dateOfBirth, gender, address, job);
                WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv", newStaff.toString(),true);
                break;
        }
    }

    public static void findByName() {
        List<Employee> employees = WriterAndReader.reader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv");
        System.out.println("enter name to find:");
        String find = sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(find)){
                System.out.println(employees.get(i));
                break;
            }
        }
    }

    public static void sortByName() {
        List<Employee> employees = WriterAndReader.reader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv");
        employees.sort(Comparator.comparing(Employee::getName));
        for (Employee employee : employees) {
            WriterAndReader.writer("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv", employee.toString(),false);
        }
    }

    public static void showEmployee(){
        List<Employee> employees = WriterAndReader.reader("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_employee\\data\\Employee.csv");
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }
}
