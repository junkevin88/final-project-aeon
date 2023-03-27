package com.aeon.finpro.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "detail_karyawan")
@Where(clause = "deleted_at is null")
public class EmployeeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nik", length = 16)
    private String nik;

    @Column(name = "npwp", length = 20)
    private String npwp;

    @JsonIgnore
    @OneToOne (targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name="id_karyawan", referencedColumnName = "id")
    private Employee employee;
}
