package com.aeon.finpro.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "rekening")
@Where(clause = "deleted_at is null")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "nama", length = 50)
    private String name;

    @Column(name = "jenis", length = 10)
    private String accountType;

    @Column(name = "nomor", length = 20)
    private String accountNumber;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "karyawan_id")
    private Employee employee;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;
    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;
}
