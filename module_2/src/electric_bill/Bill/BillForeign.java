package electric_bill.Bill;

import electric_bill.models.InternationalCustomer;

public class BillForeign extends InternationalCustomer {
    String billId;
    String date;
    String consumption;
    double price;

    public BillForeign(String id, String name, String passport, String billId, String date, String consumption) {
        super(id, name, passport);
        this.billId = billId;
        this.date = date;
        this.consumption = consumption;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = CalculateMoney.internationalCalculate(consumption);
    }

    @Override
    public String toString() {
        return  super.getId() +
                "," + super.getName() +
                "," + super.getPassport() +
                "," + billId +
                "," + date +
                "," + consumption +
                "," + price;
    }
}
