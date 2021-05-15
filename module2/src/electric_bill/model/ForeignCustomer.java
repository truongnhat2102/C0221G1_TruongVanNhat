package electric_bill.model;

public class ForeignCustomer extends Customer{
    private String passport;
    private String amount;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = Double.parseDouble(amount)*1800;
    }

    public ForeignCustomer(String name, String id, String passport) {
        super(name, id);
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String showInfor() {
        return "ForeignCustomer{" +
                "name='" + super.getName() + '\'' +
                ",id='" + super.getId() + '\'' +
                ",passport='" + passport + '\'' +
                '}';
    }

        @Override
    public String toString() {
        return super.toString() +
                "," + passport;
    }
}
