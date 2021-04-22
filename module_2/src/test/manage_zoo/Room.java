package test.manage_zoo;

import java.util.List;
import java.util.Scanner;

public class Room {
    static int roomNo;
    List<Animal> animalList;
    Scanner sc=new Scanner(System.in);
    void addAnimal(){
        Animal animal = new Animal();
        System.out.println("enter kind of animal");
        switch (sc.nextLine()){
            case "tiger":
                animal=(Tiger) animal;
                break;
            case "dog":
                animal=(Dog) animal;
                break;
            case "cat":
                animal=(Cat) animal;
                break;
        }
        System.out.println("enter name of animal:");
        animal.setName(sc.nextLine());
        System.out.println("enter age of animal:");
        animal.setAge(sc.nextInt());
        animalList.add(animal);
    }
    void removeAnimal(){
        System.out.println("enter name of animal you want to delete:");
        String name=sc.nextLine();
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getName()==name){
                animalList.remove(animalList.get(i));
            }
        }
    }
    void display(){
        System.out.print("[ RoomNo:"+roomNo);
        for (int i = 0; i < animalList.size(); i++) {
//            if (animalList.get(i))
        }
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    void input(){
        setRoomNo(sc.nextInt());
    }
}
