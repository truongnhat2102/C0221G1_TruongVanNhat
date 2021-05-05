package electric_bill.models;

public class LocalCustomer extends Customer{
    String typeOf;

    public LocalCustomer(String id, String name, String typeOf) {
        super(id, name);
        this.typeOf = typeOf;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }


    @Override
    public String toString() {
        return id +
                ","+ name +
                "," + typeOf;
    }
}
