package electric_bill.model;

import static java.lang.Double.parseDouble;

public class LocalCustomer extends Customer{
    private String typeOf;
    private String consumption;
    private String amount;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice() {
        if (parseDouble(consumption)>50){
            this.price = (parseDouble(amount)-1.8)*4500+50*1800;
        }
        else {
            this.price = Double.parseDouble(amount)*1800;
        }

    }

    public LocalCustomer(String name, String id, String typeOf, String consumption){
        super(name,id);
        this.typeOf = typeOf;
        this.consumption = consumption;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String showInfor() {
        return "LocalCustomer{" +
                "name='" + super.getName() + '\'' +
                ",id='" + super.getId() + '\'' +
                ",typeOf='" + typeOf + '\'' +
                ", consumption='" + consumption + '\'' +
                '}';
    }

        @Override
    public String toString() {
        return super.toString() +
                "," + typeOf +
                "," + consumption;
    }
}
