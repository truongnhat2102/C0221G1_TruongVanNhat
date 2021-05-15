package manage_vehicle.Model;

public class Motorbike extends Vehicle{
    private String wattage;

    public Motorbike(String idNumber, String productOf, String yearOf, String owner, String wattage) {
        super(idNumber, productOf, yearOf, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    public String showInfor() {
        return "Motorbike{" +
                "idNumber='" + super.getIdNumber() + '\'' +
                ", productOf='" + super.getProductOf() + '\'' +
                ", yearOf='" + super.getYearOf() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", wattage='" + wattage + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + wattage;
    }
}
