package com.sprint2.employee.model.entity.employee;

import com.sprint2.employee.model.entity.user_role.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeAddress;
    private String employeeImage;
    private String employeePhone;
    private String employeeBirthday;
    private String employeeStartDate;
    private boolean flag = true;

    @OneToOne(mappedBy = "user_name")
    private User user;
}
