package com.aeon.finpro.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "training")
@Where(clause = "deleted_date is null")
public class Training {
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


    @Column(name = "tema", length = 100)
    private String topic;

    @Column(name = "nama_pengajar", length = 50)
    private String facilitator;
}
