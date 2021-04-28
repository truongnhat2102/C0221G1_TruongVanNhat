package manage_vehicles.vehicle;

public abstract class Vehicle {
    protected String number;
    protected String productOf;
    protected String yearFrom;
    protected String owner;

    public Vehicle(String number, String productOf, String yearFrom, String owner) {
        this.number = number;
        this.productOf = productOf;
        this.yearFrom = yearFrom;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProductOf() {
        return productOf;
    }

    public void setProductOf(String productOf) {
        this.productOf = productOf;
    }

    public String getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(String yearFrom) {
        this.yearFrom = yearFrom;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
