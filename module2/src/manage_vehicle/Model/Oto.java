package manage_vehicle.Model;

public class Oto extends Vehicle{
    private String seats;
    private String typeOf;

    public Oto(String idNumber, String productOf, String yearOf, String owner, String seats, String typeOf) {
        super(idNumber, productOf, yearOf, owner);
        this.seats = seats;
        this.typeOf = typeOf;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public String showInfor() {
        return "Oto{" +
                "idNumber='" + super.getIdNumber() + '\'' +
                ", productOf='" + super.getProductOf() + '\'' +
                ", yearOf='" + super.getYearOf() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", seats='" + seats + '\'' +
                ", typeOf='" + typeOf + '\'' +
                '}';
    }

        @Override
    public String toString() {
        return super.toString() +
                "," + seats +
                "," + typeOf;
    }
}
