package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    @Query("select s from Schedule s where s.doctors.id = ?1")
    public List<Schedule> findByDoctorId(Long doctorId);

    @Query("select s from Schedule s where s.patientRecord.user.id = ?1")
    public List<Schedule> findByUserId(Long userId);


    @Query("select s from Schedule s where s.patientRecord.user.id = ?1 and s.doctors.fulllName like ?2")
    public List<Schedule> findByUserIdAndParam(Long userId, String param);

    @Query("select s from Schedule s where s.doctors.id = ?1 and s.bookingDate >= ?2 and s.bookingDate <= ?3")
    public List<Schedule> findByDoctorIdAndDate(Long doctorId, Date d1, Date d2);

    @Query("select s from Schedule s where s.patientRecord.user.id = ?1 and s.bookingDate >= ?2 and s.bookingDate <= ?3")
    public List<Schedule> findByUserIdAndDate(Long userId, Date d1, Date d2);

    @Query("select s from Schedule s where s.bookingDate = ?1 and s.bookingTime = ?2 and s.doctors.id = ?3 and s.paid = 0")
    public Optional<Schedule> findByDateAndDoctor(Date d, Time t, Long idDoctor);

    @Query("select s from Schedule s where s.bookingDate = ?1 and s.doctors.id = ?2 and s.paid = 0")
    public List<Schedule> findByDateAndDoctorId(Date d, Long doctorId);

    @Query("select s from Schedule s where s.bookingDate >= ?1 and s.paid = 0 and s.patientRecord.user.id = ?2")
    public List<Schedule> findScheduleByDateAndPay(Date d, Long userId);

    @Query("select s from Schedule s where s.paid = ?1")
    public List<Schedule> findScheduleByPay(Integer paid);

    @Query("select s from Schedule s where s.paid = ?1 and s.bookingDate >= ?2 and s.bookingDate <= ?3")
    public List<Schedule> getScheduleByDateAndPay(Integer paid, Date startDate, Date endDate);

    @Query("select count(d.id) from Schedule d")
    public Double getTotal();
}
