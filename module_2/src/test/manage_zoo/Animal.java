package test.manage_zoo;

public class Animal {
    String name;
    int age;
    String description;
    void display(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(description);
    }
    void showSound(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
