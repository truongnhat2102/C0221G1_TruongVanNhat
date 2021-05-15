package bai12_java_collection_framework.exercise.use_java_collection_framework;

import java.util.Scanner;

public class ProductManagerTest{
    public static void main(String[] args) {
        System.out.println("--------WELCOME TO SYSTEM--------");
        ProductManager productManager=new ProductManager();
        do {
            Scanner sc=new Scanner(System.in);
            System.out.println("---------------------------------");
            System.out.println("what do you want to do?\n" +
                    "1.Add new product\n" +
                    "2.Delete product\n" +
                    "3.Edit product\n" +
                    "4.Display product\n" +
                    "5.Find product\n" +
                    "6.Sort products\n" +
                    "7.Exit\n" +
                    "---------------------------------");
            switch (sc.nextInt()){
                case 1:
                    productManager.add();
                    continue;
                case 2:
                    productManager.deleteById();
                    continue;
                case 3:
                    productManager.editById();
                    continue;
                case 4:
                    productManager.display();
                    continue;
                case 5:
                    productManager.findByName();
                    continue;
                case 6:
                    productManager.sortPrice();
                    continue;
                case 7:
                    productManager.exit();
                    System.exit(0);
            }
        }while (true);
    }
}
