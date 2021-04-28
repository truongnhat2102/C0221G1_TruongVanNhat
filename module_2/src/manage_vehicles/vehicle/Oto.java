package manage_vehicles.vehicle;

public class Oto extends Vehicle{
    private String seats;
    private String typeOf;

    public Oto(String number, String productOf, String yearFrom, String owner, String seats, String typeOf) {
        super(number, productOf, yearFrom, owner);
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

    @Override
    public String toString() {
        return getNumber() + ',' +
                getProductOf() + ',' +
                getYearFrom() + ',' +
                getOwner() + ',' +
                getSeats() + ',' +
                getTypeOf();
    }
}
