package manage_vehicle.Model;

public abstract class Vehicle {
    private String idNumber;
    private String productOf;
    private String yearOf;
    private String owner;

    Vehicle(String idNumber, String productOf, String yearOf, String owner){
        this.idNumber = idNumber;
        this.productOf = productOf;
        this.yearOf = yearOf;
        this.owner = owner;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getProductOf() {
        return productOf;
    }

    public void setProductOf(String productOf) {
        this.productOf = productOf;
    }

    public String getYearOf() {
        return yearOf;
    }

    public void setYearOf(String yearOf) {
        this.yearOf = yearOf;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String showInfor() {
        return "Vehicle{" +
                "idNumber='" + idNumber + '\'' +
                ", productOf='" + productOf + '\'' +
                ", yearOf='" + yearOf + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

        @Override
    public String toString() {
        return idNumber +
                "," + productOf +
                "," + yearOf +
                "," + owner;
    }
}
