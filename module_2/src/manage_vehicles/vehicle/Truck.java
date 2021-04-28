package manage_vehicles.vehicle;

public class Truck extends Vehicle{
    private String payload;

    public Truck(String number, String productOf, String yearFrom, String owner, String payload) {
        super(number, productOf, yearFrom, owner);
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return getNumber() + ',' +
                getProductOf() + ',' +
                getYearFrom() + ',' +
                getOwner() + ',' +
                getPayload();
    }
}
