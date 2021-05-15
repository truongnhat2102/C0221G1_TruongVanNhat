package manage_phone.model;

public class PhoneBook extends Customer{
    private String phoneNumber;

    public PhoneBook(String typeOf, String name, String gender, String address, String dateOfBirth, String email, String phoneNumber) {
        super(typeOf, name, gender, address, dateOfBirth, email);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String showInfor() {
        return "PhoneBook{" +
                "typeOf='" + super.getTypeOf() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", dateOfBirth='" + super.getDateOfBirth() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + phoneNumber;

    }
}
