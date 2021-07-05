package com.furama_resort.model.entity.employee;

import javax.persistence.*;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long educationDegreeId;

    private String educationDegreeName;

    public EducationDegree() {
    }

    public long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
