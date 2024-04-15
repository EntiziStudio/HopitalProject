package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.MedicalProcess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalProcessRepository extends JpaRepository<MedicalProcess,Long> {
}
