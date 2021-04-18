package bai12_java_collection_framework.exercise.use_java_collection_framework;

public class Product {
    private String name;
    private int id;
    private int price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "" +
                "id: " + id +
                ", name: " + name +
                ", price: " + price ;
    }
}
