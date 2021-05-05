package electric_bill.models;

public class InternationalCustomer extends Customer{
    String passport;

    public InternationalCustomer(String id, String name, String passport) {
        super(id, name);
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + passport;
    }
}
