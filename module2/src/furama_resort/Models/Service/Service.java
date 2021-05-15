package furama_resort.Models.Service;

public abstract class Service {
    private String id;
    private String name;
    private String area;
    private String price;
    private String maxPeople;
    private String typeOfRent;

    public Service(String id, String name, String area, String price, String maxPeople, String typeOfRent) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.typeOfRent = typeOfRent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + area +
                "," + price +
                "," + maxPeople +
                "," + typeOfRent;
    }
}
