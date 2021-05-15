package manage_employee.models;

public class Engineer extends Employee {
    private String major;

    public Engineer(String name, String dayOfBirth, String gender, String address, String major) {
        super(name, dayOfBirth, gender, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String showInfor() {
        return "Engineer{" +
                "name='" + super.getName() + '\'' +
                ", dayOfBirth='" + super.getDayOfBirth() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                "major='" + major + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.getName() +
                "," + super.getDayOfBirth() +
                "," + super.getGender() +
                "," + super.getAddress() +
                "," + major;
    }
}
