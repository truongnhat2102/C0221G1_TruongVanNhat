package bai12_java_collection_framework.exercise.use_java_collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    static ArrayList<Product> products = new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    void display() {
//        for (int i = 0; i < products.size(); i++) {
//            System.out.println(products.get(i));
//        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    void add() {
        Product newProduct = new Product();
        System.out.println("enter id: ");
        newProduct.setId(sc.nextInt());
        System.out.println("enter name: ");
        sc.nextLine();
        newProduct.setName(sc.nextLine());
        System.out.println("enter price: ");
        newProduct.setPrice(sc.nextInt());
        products.add(newProduct);
    }

    void deleteById() {
        System.out.println("enter ID: ");
        int i = sc.nextInt();
        for (int j = 0; j < products.size(); j++) {
            if (i == products.get(j).getId()) {
                System.out.println("are you sure?\n1.sure\n2.no");
                int confirm = sc.nextInt();
                if (confirm == 1) {
                    products.remove(products.get(j));
                }
            }
        }
    }

    void edit(int i) {
        for (int j = 0; j < products.size(); j++) {
            if (i == products.get(j).getId()) {
                System.out.println("what infor do you want to edit\n1.name\n2.ID\n3.price\n4.exit");
                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("enter name: ");
                        sc.nextLine();
                        products.get(j).setName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("enter ID: ");
                        products.get(j).setId(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("enter price: ");
                        products.get(j).setPrice(sc.nextInt());
                        break;
                    case 4:
                        break;
                }
            }
        }
    }

    void editById() {
        System.out.println("enter ID: ");
        int i = sc.nextInt();
        edit(i);
    }

    void findByName() {
        System.out.println("enter name to find: ");
        sc.nextLine();
        String i = sc.nextLine();
        for (int j = 0; j < products.size(); j++) {
            if (products.get(j).getName().contains(i)) {
                System.out.println(products.get(j));
                System.out.println("do you want to do:\n1.delete\n2.edit\n3.exit");
                switch (sc.nextInt()) {
                    case 1:
                        products.remove(j);
                        break;
                    case 2:
                        edit(j);
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

    void sortPriceUp() {
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println("--------SORT PRICE UP--------");
        display();
    }

    void sortPriceDown() {
        products.sort(Comparator.comparing(Product::getPrice));
        Collections.reverse(products);
        System.out.println("--------SORT PRICE DOWN--------");
        display();
    }

    void sortPrice() {
        System.out.println("Do you want to \n1.sort price up\n2.sort price down");
        switch (sc.nextInt()) {
            case 1:
                sortPriceUp();
            case 2:
                sortPriceDown();
        }
    }

    void exit() {
        if (products.isEmpty()) {
            System.out.println("--------GOOD BYE--------");
        } else {
            display();
            System.out.println("--------GOOD BYE--------");
        }
    }
}
