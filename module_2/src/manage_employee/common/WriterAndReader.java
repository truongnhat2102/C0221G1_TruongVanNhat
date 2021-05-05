package manage_employee.common;

import manage_employee.models.Employee;
import manage_employee.models.Engineer;
import manage_employee.models.Staff;
import manage_employee.models.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterAndReader {
    static List<Employee> employees = new ArrayList<>();
    public static void writer(String path, String line, boolean status) {
        try {
            FileWriter data = new FileWriter(path, status);
            BufferedWriter bfw = new BufferedWriter(data);
            for (Employee employee:employees) {
                bfw.write(line + "\n");
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> reader(String path) {
        try {
            FileReader data = new FileReader(path);
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr[4].contains("N1") || arr[4].contains("N2") || arr[4].contains("N3")){
                    Employee newEngineer = new Engineer(arr[0],arr[1],arr[2],arr[3],arr[4]);
                    employees.add(newEngineer);
                }
                else if (arr[4].contains("/7")){
                    Employee newWorker = new Worker(arr[0],arr[1],arr[2],arr[3],arr[4]);
                    employees.add(newWorker);
                }
                else if (arr[4].contains("PV")){
                    Employee newStaff = new Staff(arr[0],arr[1],arr[2],arr[3],arr[4]);
                    employees.add(newStaff);
                }
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return employees;
        }
    }
}
