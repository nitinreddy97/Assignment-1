package com.nitin.employee.modal;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name="EMPLOYEE")
public class Employee {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="employee_id")
    private long employeeId;

    @NotNull(message = "First name can not be null")
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Min(value = 1 , message = "Value should be greater then then equal to 1")
    @Max(value = 10 , message = "Value should be less then then equal to 10")
    @NotEmpty(message = "Job Level can not be null. Please provide no. in b/w 1 to 10")
    @JoinColumn(name="job_level")
    private Integer jobLevel;

    @Column(name="department_id")
    @JoinColumn(name="department_id")
    private long departmentId;

    @Email
    @Column(name = "email_id")
    private String emailId;

    @Column(name = "manager_id")
    private long managerId;
}
