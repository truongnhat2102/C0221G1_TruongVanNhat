package electric_bill.Bill;

import electric_bill.models.Customer;
import electric_bill.models.LocalCustomer;

public class BillLocal extends LocalCustomer {
    String billId;
    String date;
    String consumption;
    double price;

    public BillLocal(String id, String name, String typeOf,String billId,String date,String consumption) {
        super(id, name, typeOf);
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = CalculateMoney.localCalculate(consumption);
    }

    @Override
    public String toString() {
        return super.getId() +
                "," + super.getName() +
                "," + billId +
                "," + date +
                "," + consumption +
                "," + price;
    }
}
