package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Schedule;
import com.medisure.medisure_as.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist,Long> {
}
