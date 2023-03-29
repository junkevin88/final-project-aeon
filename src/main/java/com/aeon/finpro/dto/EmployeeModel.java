package com.aeon.finpro.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private String name;
    private Character gender;
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dob;
    private String address;
    private String status;
    private String nik;
    private String npwp;

}
