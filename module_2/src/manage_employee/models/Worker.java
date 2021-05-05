package manage_employee.models;

public class Worker extends Employee{
    private String claass;

    public Worker(String name, String dayOfBirth, String gender, String address, String claass) {
        super(name, dayOfBirth, gender, address);
        this.claass = claass;
    }

    public String getClaass() {
        return claass;
    }

    public void setClaass(String claass) {
        this.claass = claass;
    }

    public String showInfor() {
        return "Worker{" +
                "name='" + super.getName() + '\'' +
                ", dayOfBirth='" + super.getDayOfBirth() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                "claass='" + claass + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + claass;
    }
}
