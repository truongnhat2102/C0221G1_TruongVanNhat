package manage_vehicle.Model;

public class Truck extends Vehicle{
    private String payload;

    public Truck(String idNumber, String productOf, String yearOf, String owner, String payload) {
        super(idNumber, productOf, yearOf, owner);
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String showInfor() {
        return "Truck{" +
                "idNumber='" + super.getIdNumber() + '\'' +
                ", productOf='" + super.getProductOf() + '\'' +
                ", yearOf='" + super.getYearOf() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }

        @Override
    public String toString() {
        return super.toString() +
                "," + payload;
    }
}
