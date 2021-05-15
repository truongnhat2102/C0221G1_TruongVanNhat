package manage_phone.controller;


import manage_phone.common.Regex;
import manage_phone.common.WriteAndReader;
import manage_phone.model.PhoneBook;

import java.util.Scanner;

public class MainController {
    static Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        while (true) {
            System.out.println("---CHUONG TRINH QUAN LYS DANH BA---\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.xem danh sach\n" +
                    "2.them moi\n" +
                    "3.cap nhat\n" +
                    "4.xoa\n" +
                    "5.tim kiem\n" +
                    "6.doc tu file\n" +
                    "7.ghi vao file\n" +
                    "8.thoat\n" +
                    "Chon chuc nang:");
            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    xemDanhSach();
                    break;
                case 2:
                    themMoi();
                    break;
                case 3:
                    capNhat();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    timKiem();
                    break;
//                case 6:
//                    docTuFile();
//                    break;
//                case 7:
//                    ghiVaoFile();
//                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void xemDanhSach() {
        WriteAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv");
        for (PhoneBook phonebook : WriteAndReader.phoneBooks) {
            System.out.println(phonebook.showInfor());
        }
        WriteAndReader.getPhoneBook().clear();
    }

    public static void themMoi() {
        System.out.println("nhap so dien thoai:");
        String phone = sc.nextLine();
        while (!Regex.checkPhone(phone)) {
            System.out.println("nhap so dien thoai lai:");
            phone = sc.nextLine();
        }
        System.out.println("nhap kieu:");
        String typeOf = sc.nextLine();
        while (!Regex.checkName(typeOf)) {
            System.out.println("nhap kieu lai:");
            typeOf = sc.nextLine();
        }
        System.out.println("nhap ten:");
        String name = sc.nextLine();
        while (!Regex.checkName(name)) {
            System.out.println("nhap ten lai:");
            name = sc.nextLine();
        }


        System.out.println("nhap gioi tinh:");
        String gender = sc.nextLine();
        while (!Regex.checkGender(gender)) {
            System.out.println("nhap gioi tinh lai:");
            gender = sc.nextLine();
        }
        System.out.println("nhap dia chi:");
        String address = sc.nextLine();

        System.out.println("nhap ngay sinh:");
        String dateOfBirth = sc.nextLine();
        while (!Regex.checkDate(dateOfBirth)) {
            System.out.println("nhap ngay sinh lai:");
            dateOfBirth = sc.nextLine();
        }
        System.out.println("nhap email:");
        String email = sc.nextLine();
        while (!Regex.checkEmail(email)) {
            System.out.println("nhap ten lai:");
            email = sc.nextLine();
        }
        PhoneBook phoneBook = new PhoneBook(typeOf,name,gender,address,dateOfBirth,email,phone);
        WriteAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv",phoneBook.toString(),true);
    }

    public static void capNhat(){
        System.out.println("nhap so dien thoai can cap nhat:");
        String find = sc.nextLine();
        WriteAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv");
        for (int i=0; i<WriteAndReader.phoneBooks.size(); i++) {
            if (WriteAndReader.phoneBooks.get(i).getPhoneNumber().equals(find)){
                System.out.println(WriteAndReader.phoneBooks.get(i).showInfor());
                System.out.println("nhap moi kieu:");
                String typeOf = sc.nextLine();
                while (!Regex.checkName(typeOf)) {
                    System.out.println("nhap kieu lai:");
                    typeOf = sc.nextLine();
                }
                WriteAndReader.phoneBooks.get(i).setTypeOf(typeOf);
                System.out.println("nhap moi ten:");
                String name = sc.nextLine();
                while (!Regex.checkName(name)) {
                    System.out.println("nhap ten lai:");
                    name = sc.nextLine();
                }
                WriteAndReader.phoneBooks.get(i).setName(name);
                System.out.println("nhap moi gioi tinh:");
                String gender = sc.nextLine();
                while (!Regex.checkGender(gender)) {
                    System.out.println("nhap gioi tinh lai:");
                    gender = sc.nextLine();
                }
                WriteAndReader.phoneBooks.get(i).setGender(gender);
                System.out.println("nhap moi dia chi:");
                String address = sc.nextLine();
                WriteAndReader.phoneBooks.get(i).setAddress(address);
                System.out.println("nhap moi ngay sinh:");
                String dateOfBirth = sc.nextLine();
                while (!Regex.checkDate(dateOfBirth)) {
                    System.out.println("nhap ngay sinh lai:");
                    dateOfBirth = sc.nextLine();
                }
                WriteAndReader.phoneBooks.get(i).setDateOfBirth(dateOfBirth);
                System.out.println("nhap moi email:");
                String email = sc.nextLine();
                while (!Regex.checkEmail(email)) {
                    System.out.println("nhap ten lai:");
                    email = sc.nextLine();
                }
                WriteAndReader.phoneBooks.get(i).setEmail(email);
                System.out.println("done\n"+ WriteAndReader.phoneBooks.get(i).showInfor());
            }
        }
        for (int i=0; i<WriteAndReader.getPhoneBook().size(); i++){
            if (i==0){
                WriteAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv",WriteAndReader.phoneBooks.get(i).toString(),false);
            }
            else {
                WriteAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv",WriteAndReader.phoneBooks.get(i).toString(),true);
            }
        }
        WriteAndReader.phoneBooks.clear();
    }

    public static void xoa(){
        System.out.println("nhap so dien thoai can cap nhat:");
        String find = sc.nextLine();
        WriteAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv");
        for (int i=0; i<WriteAndReader.getPhoneBook().size(); i++) {
            if (WriteAndReader.phoneBooks.get(i).getPhoneNumber().equals(find)){
                System.out.println(WriteAndReader.phoneBooks.get(i).showInfor());
                System.out.println("ban co muon xoa danh ba nay:\n" +
                        "1.yes\n" +
                        "2.no");
                int j = Integer.parseInt(sc.nextLine());
                if (j==1){
                    WriteAndReader.phoneBooks.remove(i);
                    System.out.println("done");
                    break;
                }
            }
        }
        for (int i=0; i<WriteAndReader.phoneBooks.size(); i++){
            if (i==0){
                WriteAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv",WriteAndReader.phoneBooks.get(i).toString(),false);
            }
            else {
                WriteAndReader.write("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv",WriteAndReader.phoneBooks.get(i).toString(),true);
            }
        }
        WriteAndReader.phoneBooks.clear();
    }

    public static void timKiem(){
        WriteAndReader.read("D:\\C0221G1_TruongVanNhat\\module_2\\src\\manage_phone\\data\\contacts.csv");
        System.out.println("ban muon tim kiem theo gi\n" +
                "1.theo ten\n" +
                "2.theo so dien thoai");
        int i = Integer.parseInt(sc.nextLine());
        if(i==1){
            System.out.println("nhap ten can tim:");
            String find = sc.nextLine();
            for (PhoneBook phoneBook:WriteAndReader.getPhoneBook()) {
                if (phoneBook.getName().contains(find)){
                    System.out.println(phoneBook.showInfor()+"\n");
                }
            }
        } else {
            System.out.println("nhap so dien thoai can tim:");
            String find = sc.nextLine();
            for (PhoneBook phoneBook:WriteAndReader.getPhoneBook()) {
                if (phoneBook.getPhoneNumber().contains(find)){
                    System.out.println(phoneBook.showInfor()+"\n");
                }
            }
        }
        WriteAndReader.getPhoneBook().clear();
    }



    public static void main(String[] args) {
        displayMenu();
    }

}
