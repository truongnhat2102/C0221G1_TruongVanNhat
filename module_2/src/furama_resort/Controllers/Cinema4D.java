package furama_resort.Controllers;

import furama_resort.Commons.WriterAndReader;
import furama_resort.Models.Customer.Customer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cinema4D {
    static Scanner sc = new Scanner(System.in);
    static Queue<Customer> queue = new LinkedList<>();
    private static int tickets = 10;

    public static void displayCinema4D() {
       while (true){
           System.out.println("1.Buy Tickets:\n" +
                   "2.Show Queue\n" +
                   "3.Exit");
           int i = Integer.parseInt(sc.nextLine());
           switch (i) {
               case 1:
                   buyTickets();
                   break;
               case 2:
                   showQueue();
                   break;
               case 3:
                   if (queue.isEmpty()) {
                       System.out.println("thanks for watching");
                       System.exit(0);
                   } else {
                       showQueue();
                       System.out.println("thanks !!!");
                       System.exit(0);
                   }
           }
       }
    }

    public static void buyTickets() {
        WriterAndReader.readerCustomer();
        while (tickets > 0) {
            System.out.println("Enter name customer want to buy tickets");
            String find = sc.nextLine();
            System.out.println("How many tickets do u want to buy?");
            String amount = sc.nextLine();
            for (int i = 0; i < WriterAndReader.getCustomers().size(); i++) {
                if (find.equals(WriterAndReader.getCustomers().get(i).getName())) {
                    queue.add(WriterAndReader.getCustomers().get(i));
                    tickets = tickets - Integer.parseInt(amount);
                    break;
                }
            }
            System.out.println("do u want to buy continue?\n" +
                    "1.yes\n" +
                    "2.no");
            int i = Integer.parseInt(sc.nextLine());
            if (i == 1) {
                System.out.println("Enter name customer want to buy tickets");
                find = sc.nextLine();
                for (int j = 0; j < WriterAndReader.getCustomers().size(); j++) {
                    if (find.equals(WriterAndReader.getCustomers().get(i).getName())) {
                        queue.add(WriterAndReader.getCustomers().get(j));
                        tickets--;
                        break;
                    }
                }
            } else if (i == 2) {
                break;
            }
        }
        if (tickets > 0) {
            System.out.println("we have " + tickets + " tickets");
        } else {
            System.out.println("The tickets was sold out!!!");
        }

    }

    public static void showQueue() {
        for (Customer queue : queue) {
            System.out.println(queue.showInfor() + "\n");
        }
    }

    public static void main(String[] args) {
        displayCinema4D();
    }
}
