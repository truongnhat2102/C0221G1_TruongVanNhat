package manage_vehicles.vehicle;

public class Motorbike extends Vehicle{
    private String wattage;

    public Motorbike(String number, String productOf, String yearFrom, String owner, String wattage) {
        super(number, productOf, yearFrom, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return getNumber() + ',' +
                getProductOf() + ',' +
                getYearFrom() + ',' +
                getOwner() + ',' +
                getWattage();
    }
}
