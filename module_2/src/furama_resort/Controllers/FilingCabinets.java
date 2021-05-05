package furama_resort.Controllers;

import furama_resort.Commons.WriterAndReader;
import furama_resort.Models.Employee.Employee;

import java.util.Scanner;
import java.util.Stack;

public class FilingCabinets {
    static Scanner sc = new Scanner(System.in);
    static Stack<Employee> filingCabinets = new Stack<Employee>();

    public static void storage(){
        WriterAndReader.readerEmployee();
        for (Employee employee : WriterAndReader.getEmployees()) {
            filingCabinets.add(employee);
        }
    }

    public static void findEmployee(){
        System.out.println("enter name of employee");
        String find = sc.nextLine();
        for (int i = 0; i < filingCabinets.size(); i++) {
            if (find.equals(filingCabinets.get(i).getName())){
                System.out.println(filingCabinets.get(i).showInfor());
                break;
            }
        }
    }

    public static void main(String[] args) {
        storage();
        findEmployee();
    }
}
