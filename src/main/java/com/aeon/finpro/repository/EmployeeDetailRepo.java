package com.aeon.finpro.repository;

import com.aeon.finpro.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeDetailRepo extends JpaRepository<EmployeeDetail, UUID> {
    @Query(value = "select e from EmployeeDetail e where e.employee.id = ?1")
    EmployeeDetail findByEmployeeId(UUID employeeId);
//
//    @Query(value = "select e.nik, e.npwp from detail_karyawan e join karyawan k on k.id = e.id_karyawan where k.id = :id_karyawan", nativeQuery = true)
//    EmployeeDetail findByIdKaryawan(@Param("id_karyawan") String idKaryawan);
}
