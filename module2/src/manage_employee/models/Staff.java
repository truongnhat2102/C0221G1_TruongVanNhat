package manage_employee.models;

public class Staff extends Employee {
    private String job;


    public Staff(String name, String dayOfBirth, String gender, String address, String job) {
        super(name, dayOfBirth, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return super.getName() +
                "," + super.getDayOfBirth() +
                "," + super.getGender() +
                "," + super.getAddress() +
                "," + job;
    }


    public String showInfor() {
        return "Staff{" +
                "name='" + super.getName() + '\'' +
                ", dayOfBirth='" + super.getDayOfBirth() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
