package com.sprint2.employee.model.entity.user_role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;
}
