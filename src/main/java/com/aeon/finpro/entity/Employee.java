package com.aeon.finpro.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "karyawan")
@Where(clause = "deleted_at is null")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;
    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "nama", nullable = false, length = 50)
    private String name;

    @Column(name = "jk")
    private Character gender;

    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dob;

    @Column(name = "alamat", columnDefinition="TEXT")
    private String address;

    @Column(name = "status", length = 20)
    private String status;


    @OneToOne(mappedBy = "employee")
    private EmployeeDetail employeeDetail;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    List<EmployeeTraining> employeeTrainingList;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accountList;
}
