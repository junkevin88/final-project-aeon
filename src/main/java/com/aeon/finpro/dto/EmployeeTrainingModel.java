package com.aeon.finpro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTrainingModel {

    private UUID employeeId;

    private UUID trainingId;

    @DateTimeFormat(pattern = "yyMMdd")
    private Date trainingDate;
}
