package electric_bill.common;

import electric_bill.model.ForeignCustomer;
import electric_bill.model.LocalCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterAndReader {
    static List<ForeignCustomer> foreignCustomers = new ArrayList<>();
    static List<LocalCustomer> localCustomers = new ArrayList<>();

    public static void write(String path, String line, boolean status) {
        try {
            FileWriter data = new FileWriter(path, true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(line);
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(String path) {
        try {
            FileReader data = new FileReader(path);
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            if (path.contains("LocalCustomer")) {
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    LocalCustomer localCustomer = new LocalCustomer(arr[0], arr[1], arr[2], arr[3]);
                    localCustomers.add(localCustomer);
                }
            } else if (path.contains("ForeignCustomer")) {
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    ForeignCustomer foreignCustomer = new ForeignCustomer(arr[0], arr[1], arr[2]);
                    foreignCustomers.add(foreignCustomer);
                }
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ForeignCustomer> getForeignCustomers() {
        return foreignCustomers;
    }

    public static List<LocalCustomer> getLocalCustomers() {
        return localCustomers;
    }
}
