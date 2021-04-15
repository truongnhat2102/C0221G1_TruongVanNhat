package bai11_stack_queue.exercise.manage_person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static bai11_stack_queue.exercise.manage_person.Person.age;

public class ManagePerson {
    private static Object Comparable;

    public static void main(String[] args) {
        ArrayList<Person> Person1 = new ArrayList<Person>();
        do {
            Person person = new Person();
            Scanner sc = new Scanner(System.in);
            System.out.println("enter name:");
            person.setName(sc.nextLine());
            System.out.println("enter gender:");
            person.setGender(sc.nextLine());
            System.out.println("enter id");
            person.setId(sc.nextInt());
            System.out.println("enter age:");
            person.setAge(sc.nextInt());
            System.out.println("what i do next?");
            int i = sc.nextInt();
            if (i == 1) {
                Person1.add(person);
            } else {
                Person1.add(person);
                break;
            }
        } while (true);
        Person1.sort(Comparator.comparing(Person::getAge));
        for (Person str : Person1) {
            System.out.println(str);
        }
    }
}
