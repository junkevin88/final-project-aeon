package com.aeon.finpro.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "karyawan_training")
@Where(clause = "deleted_date is null")
public class EmployeeTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd")
    @Column(name = "tanggal_training", nullable = false)
    private Date trainingDate;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;
    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @ManyToOne
    @JoinColumn(name = "training_id")
    Training training;

    @ManyToOne
    @JoinColumn(name = "karyawan_id")
    Employee employee;
}
