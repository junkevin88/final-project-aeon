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
public class EmployeeModel {
    private UUID id;
    private String name;
    private Character gender;
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dob;
    private String address;
    private String status;
    private String nik;
    private String npwp;
    private String accountName;
    private String accountNumber;
    private String accountType;

}
