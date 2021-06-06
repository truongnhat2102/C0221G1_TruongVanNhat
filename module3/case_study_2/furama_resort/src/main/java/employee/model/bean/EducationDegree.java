package employee.model.bean;

public class EducationDegree {
    private int idEducation;
    private String nameEducation;

    public int getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(int idEducation) {
        this.idEducation = idEducation;
    }

    public String getNameEducation() {
        return nameEducation;
    }

    public void setNameEducation(String nameEducation) {
        this.nameEducation = nameEducation;
    }

    public EducationDegree(int idEducation, String nameEducation) {
        this.idEducation = idEducation;
        this.nameEducation = nameEducation;
    }
}
