package bai11_stack_queue.exercise.manage_person;

import java.util.*;

public class Demerging {
    public static void main(String[] args) {
        Stack<Person> MALE = new Stack<>();
        Stack<Person> FEMALE = new Stack<>();
        do {
            Person person=new Person();
            Scanner sc=new Scanner(System.in);
            System.out.println("enter name:");
            person.setName(sc.nextLine());
            System.out.println("enter gender:");
            person.setGender(sc.nextLine());
            System.out.println("enter id");
            person.setId(sc.nextInt());
            System.out.println("enter age:");
            person.setAge(sc.nextInt());
            System.out.println("what i do next?");
            int i=sc.nextInt();
            if (i==1){
                if (person.gender.toLowerCase().equals("male")){
                    MALE.add(person);
                    MALE.sort(Comparator.comparing(Person::getAge));
                }
                else if (person.gender.toLowerCase().equals("female")){
                    FEMALE.add(person);
                    FEMALE.sort(Comparator.comparing(Person::getAge));
                }
            }
            else {
                for (int j = 0; j < FEMALE.size(); j++) {
                    System.out.println(FEMALE.get(i));
                }
                for (int j = 0; j < MALE.size(); j++) {
                    System.out.println(MALE.get(i));
                }
                break;
            }
        }while (true);

    }
}
