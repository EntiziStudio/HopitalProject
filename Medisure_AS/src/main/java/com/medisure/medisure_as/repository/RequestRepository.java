package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Long> {

    @Query("select r from Request r where r.actived = ?1 order by r.id asc ")
    public List<Request> findRequestByActive(Integer actived);
}
