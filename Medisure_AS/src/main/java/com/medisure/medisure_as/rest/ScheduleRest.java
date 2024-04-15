package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.dto.EmptySchedule;
import com.medisure.medisure_as.dto.FilterScheduleDto;
import com.medisure.medisure_as.dto.SearchScheduleDto;
import com.medisure.medisure_as.entity.*;
import com.medisure.medisure_as.repository.DoctorRepository;
import com.medisure.medisure_as.repository.PatientRecordRepository;
import com.medisure.medisure_as.repository.RoomRepository;
import com.medisure.medisure_as.repository.ScheduleRepository;
import com.medisure.medisure_as.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ScheduleRest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping("/admin/allSchedule")
    public List<Schedule> findAll(){
        return scheduleRepository.findAll();
    }


    @GetMapping("/user/getScheduleByDateAndDoctor")
    public List<Schedule> getScheduleByDate(@RequestParam("date") Date date, @RequestParam("id") Long id){
        List<Schedule> list = scheduleRepository.findByDateAndDoctorId(date, id);
        return list;
    }

    @GetMapping("/doctor/getScheduleByDoctor")
    public List<Schedule> findByDoctor(@RequestParam(value = "from", required = false) Date fromDate,
            @RequestParam(value = "to", required = false) Date toDate){
        User u = userService.getUserWithAuthority();
        Doctors doctors = doctorRepository.findByUser(u.getId());
        if(fromDate != null && toDate != null){
            return scheduleRepository.findByDoctorIdAndDate(doctors.getId(), fromDate, toDate);
        }
        return scheduleRepository.findByDoctorId(doctors.getId());
    }

    @GetMapping("/public/getScheduleByDoctorId")
    public List<Schedule> findByDoctorId(@RequestParam("id") Long id){
        return scheduleRepository.findByDoctorId(id);
    }

    @GetMapping("/user/getScheduleByUser")
    public List<Schedule> findByUser(@RequestParam(value = "from", required = false) Date fromDate,
                                       @RequestParam(value = "to", required = false) Date toDate){
        User u = userService.getUserWithAuthority();
        if(fromDate != null && toDate != null){
            return scheduleRepository.findByUserIdAndDate(u.getId(), fromDate, toDate);
        }
        return scheduleRepository.findByUserId(u.getId());
    }

    @GetMapping("/user/getScheduleByUserParam")
    public List<Schedule> getScheduleByUserParam(@RequestParam(value = "param") String param){
        User u = userService.getUserWithAuthority();
        return scheduleRepository.findByUserIdAndParam(u.getId(), "%"+param+"%");
    }

    @PostMapping("/user/addSchedule")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) throws Exception {
        Date d = schedule.getBookingDate();
        Time t = schedule.getBookingTime();
        Time to = schedule.getToTime();
        Doctors doctors = doctorRepository.findById(schedule.getDoctors().getId()).get();
        Optional<Schedule> sc = scheduleRepository.findByDateAndDoctor(d,t,doctors.getId());
        if(sc.isPresent()){
            return ResponseEntity.status(350).body(null);
        }
        User user = userService.getUserWithAuthority();
        Optional<PatientRecord> patientRecord = patientRecordRepository.findByUserId(user.getId());
        if(patientRecord.isPresent() == false){
            return ResponseEntity.status(300).body(null);
        }
        Date nowDate = new Date(System.currentTimeMillis());
        List<Schedule> list = scheduleRepository.findScheduleByDateAndPay(nowDate, user.getId());
        if(list.size() > 0){
            return ResponseEntity.status(305).body(null);
        }
        schedule.setPatientRecord(patientRecord.get());
        schedule.setConfirm(0);
        schedule.setPaid(0);
        System.out.println("schedule add: "+schedule);
        Schedule result = scheduleRepository.save(schedule);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/user/checkpatinet")
    public Boolean checkPatinesRecord(){
        User user = userService.getUserWithAuthority();
        Optional<PatientRecord> patientRecord = patientRecordRepository.findByUserId(user.getId());
        if(patientRecord.isPresent() == false){
            return false;
        }
        return true;
    }

    @GetMapping("/user/getScheduleById")
    public Schedule getScheduleById(@RequestParam("id") Long id) throws Exception {
        User user = userService.getUserWithAuthority();
        Schedule schedule = scheduleRepository.findById(id).get();
        if(schedule.getPatientRecord().getUser().getId() != user.getId()){
            throw new Exception("");
        }
        return schedule;
    }

    @GetMapping("/doctor/getScheduleByIdRoleDoctor")
    public Schedule getScheduleByIddoctor(@RequestParam("id") Long id) throws Exception {
        User user = userService.getUserWithAuthority();
        Schedule schedule = scheduleRepository.findById(id).get();
        if(schedule.getDoctors().getUser().getId() != user.getId()){
            throw new Exception("");
        }
        return schedule;
    }

    @DeleteMapping("/user/deleteSchedule")
    public void deleteSchedule(@RequestParam("id") Long id) throws Exception {
        Schedule schedule = scheduleRepository.findById(id).get();
        User user = userService.getUserWithAuthority();
        if(schedule.getPatientRecord().getUser().getId() != user.getId()){
            throw new Exception("access denied");
        }
        scheduleRepository.delete(schedule);
    }

    @DeleteMapping("/admin/deleteScheduleByAdmin")
    public void deleteScheduleByAdmin(@RequestParam("id") Long id) throws Exception {
        scheduleRepository.deleteById(id);
    }

    @PostMapping("/admin/allscheduleadmin")
    public List<Schedule> getAllSchedule(@RequestBody FilterScheduleDto filter){
        if(filter.getStartDate() == null){
            return scheduleRepository.findScheduleByPay(filter.getPaid());
        }
        else{
            return scheduleRepository.getScheduleByDateAndPay(filter.getPaid(), filter.getStartDate(), filter.getEndDate());
        }
    }

    @PostMapping("/doctor/updateSchedule")
    public void updateSchedule(@RequestBody Schedule schedule){
       Schedule s = scheduleRepository.findById(schedule.getId()).get();
       s.setNote(schedule.getNote());
       s.setMedicines(schedule.getMedicines());
       scheduleRepository.save(s);
    }
}
