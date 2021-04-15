package bai11_stack_queue.exercise.manage_person;

public class Person {
    static int id;
    static String name;
    static int age;
    static String gender;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Person.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Person.name = name;
    }

    public int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Person.age = age;
    }

    public static String isGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Person.gender = gender;
    }

    @Override
    public String toString() {
        return "{id= " + id +
                ", name= " + name +
                ", age= " + age +
                ", gender= " + gender + "}";
    }

}
