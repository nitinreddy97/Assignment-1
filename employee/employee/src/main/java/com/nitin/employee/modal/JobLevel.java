package com.nitin.employee.modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class JobLevel {
    @Min(value = 1 , message = "Value should be greater then then equal to 1")
    @Max(value = 10 , message = "Value should be less then then equal to 10")
    @NotNull(message = "Job Level can not be null. Please provide no. in b/w 4 to 6")
    @Id
    private Integer jobLevel;

    @NotNull(message = "Department name can not be null")
    private String jobLevelName;

    private Long basicPay;
}
