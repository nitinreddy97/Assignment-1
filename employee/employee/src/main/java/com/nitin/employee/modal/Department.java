package com.nitin.employee.modal;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="DEPARTMENT")
public class Department {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="department_id")
    private long departmentId;

    @NotNull(message = "Department name can not be null")
    @Column(name="department_name")
    private String departmentName;

    @Column(name="department_number")
    private Integer departmentNumber;
}
