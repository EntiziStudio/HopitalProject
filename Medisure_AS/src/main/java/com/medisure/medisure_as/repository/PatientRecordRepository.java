package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRecordRepository extends JpaRepository<PatientRecord,Long> {

    @Query("select p from PatientRecord p where p.user.id = ?1")
    public Optional<PatientRecord> findByUserId(Long userId);
}
