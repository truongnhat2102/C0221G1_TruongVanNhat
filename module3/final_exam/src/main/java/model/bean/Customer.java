package model.bean;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private TypeCustomer typeCustomer;
    private String birthday;
    private String gender;

    public Customer(int idCustomer, String nameCustomer, TypeCustomer typeCustomer, String birthday, String gender) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.typeCustomer = typeCustomer;
        this.birthday = birthday;
        this.gender = gender;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
