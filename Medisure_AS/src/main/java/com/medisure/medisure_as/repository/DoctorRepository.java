package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctors,Long> {

    @Query("select d from Doctors d where d.user.id = ?1")
    public Doctors findByUser(Long userId);

    @Query("select d from Doctors d where d.specialist.id = ?1 and d.user.sex = ?2")
    public List<Doctors> searchDoctor(Long ck, Integer sex);

    @Query("select d from Doctors d where d.specialist.id = ?1")
    public List<Doctors> findBySpecialist(Long id);

    @Query("select d from Doctors d where d.user.sex = ?1")
    public List<Doctors> findBySex(Integer sex);

    @Query("select d from Doctors d where d.user.sex = ?1 and d.specialist.id = ?2 ")
    public List<Doctors> findBySexAAndSpecialist(Integer sex, Long SpeciaId);

    @Query("select d from Doctors d where d.specialist.id = ?2 and d.fulllName like ?1")
    public List<Doctors> findBySpecialistAndParam(String param, Long SpeciaId);

    @Query("select d from Doctors d where d.user.sex = ?2 and d.fulllName like ?1")
    public List<Doctors> findBySexAndParam(String param, Integer sex);

    @Query("select d from Doctors d where d.fulllName like ?1")
    public List<Doctors> findByParam(String param);

    @Query("select d from Doctors d where d.user.sex = ?2 and d.specialist.id = ?3 and d.fulllName like ?1")
    public List<Doctors> findBySexAndParam(String param, Integer sex, Long speId);

    @Query("select count(d.id) from Doctors d")
    public Double getTotal();
}
