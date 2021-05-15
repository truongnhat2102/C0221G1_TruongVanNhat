package manage_phone.common;


import manage_phone.model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReader {
    public static List<PhoneBook> phoneBooks = new ArrayList<>();

    public static void write(String path, String line, boolean status) {
        try {
            FileWriter data = new FileWriter(path, true);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(line+"\n");
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
            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                PhoneBook phoneBook = new PhoneBook(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
                phoneBooks.add(phoneBook);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PhoneBook> getPhoneBook(){
        return phoneBooks;
    }
}
