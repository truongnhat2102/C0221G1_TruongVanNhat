package furama_resort.Models.Employee;

public class Employee {
    private String name;
    private String dateOfBirth;
    private String id;
    private String phone;
    private String email;
    private String education;
    private String position;
    private String safari;

    public Employee(String name, String dateOfBirth, String id, String phone, String email, String education, String position, String safari) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.position = position;
        this.safari = safari;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSafari() {
        return safari;
    }

    public void setSafari(String safari) {
        this.safari = safari;
    }

    public String showInfor() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", safari='" + safari + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return name +
                "," + dateOfBirth +
                "," + id +
                "," + phone +
                "," + email +
                "," + education +
                "," + position +
                "," + safari;
    }
}
