package com.aeon.finpro.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "detail_karyawan")
@Where(clause = "deleted_at is null")
public class EmployeeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @Size(max=16,min=16,message="nik number invalid!")
    @Column(name = "nik", length = 16)
    private String nik;

    @Size(max=20,min=20,message="npwp number invalid!")
    @Column(name = "npwp", length = 20)
    private String npwp;

    @JsonIgnore
    @OneToOne (targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name="id_karyawan", referencedColumnName = "id")
    private Employee employee;
}
