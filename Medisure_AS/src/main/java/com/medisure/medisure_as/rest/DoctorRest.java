package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.dto.SearchDoctorDto;
import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.PatientRecord;
import com.medisure.medisure_as.entity.User;
import com.medisure.medisure_as.repository.DoctorRepository;
import com.medisure.medisure_as.repository.PatientRecordRepository;
import com.medisure.medisure_as.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DoctorRest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/admin/adddoctor")
    public Doctors addDoctor(@RequestBody Doctors doctors){
        return doctorRepository.save(doctors);
    }

    @PostMapping("/doctor/updatedoctor")
    public Doctors updatedoctor(@RequestBody Doctors doctors) throws Exception {
        User user = userService.getUserWithAuthority();
        Doctors d = doctorRepository.findById(doctors.getId()).get();
        if(d.getUser().getId() != user.getId()){
            throw new Exception("access denied");
        }
        return doctorRepository.save(doctors);
    }

    @GetMapping("/doctor/getDoctorByUserLogged")
    public Doctors findByUser() {
        User user = userService.getUserWithAuthority();
        return doctorRepository.findByUser(user.getId());
    }

    @GetMapping("/admin/getDoctorByUserId")
    public Doctors findByUserId(@RequestParam("id") Long userId) {
        return doctorRepository.findByUser(userId);
    }

    @GetMapping("/public/getDoctorById")
    public Doctors findById(@RequestParam("id") Long id) {
        return doctorRepository.findById(id).get();
    }

    @GetMapping("/user/searchDoctor")
    public List<Doctors> searchDoctor(@RequestParam("c") Long c, @RequestParam("s") Integer s) {
        return doctorRepository.searchDoctor(c,s);
    }

    @GetMapping("/user/searchAllDoctor")
    public List<Doctors> searchAllDoctor() {
        return doctorRepository.findAll();
    }
    @GetMapping("/public/searchAllDoctor")
    public List<Doctors> searchAllDoctorAdmin() {
        return doctorRepository.findAll();
    }

    @PostMapping("/public/searchDoctorByAll")
    public List<Doctors> searchDoctorByAll(@RequestBody SearchDoctorDto s) {
        System.out.println("search doctordto: "+s);
        if(s.getParam() == null && s.getSpecialistId() == -1L && s.getSex() == -1){
            return doctorRepository.findAll();
        }
        else if(s.getParam() == null && s.getSpecialistId() == -1L && s.getSex() != -1 ){
            return doctorRepository.findBySex(s.getSex());
        }
        else if(s.getParam() == null && s.getSpecialistId() != -1L && s.getSex() == -1 ){
            return doctorRepository.findBySpecialist(s.getSpecialistId());
        }
        else if(s.getParam() == null && s.getSpecialistId() != -1L && s.getSex() != -1 ){
            return doctorRepository.findBySexAAndSpecialist(s.getSex(), s.getSpecialistId());
        }
        else if(s.getParam() != null && s.getSpecialistId() == -1L && s.getSex() == -1 ){
            return doctorRepository.findByParam("%"+s.getParam()+"%");
        }
        else if(s.getParam() != null && s.getSpecialistId() != -1L && s.getSex() == -1 ){
            return doctorRepository.findBySpecialistAndParam("%"+s.getParam()+"%",s.getSpecialistId());
        }
        else if(s.getParam() != null && s.getSpecialistId() == -1L && s.getSex() != -1 ){
            return doctorRepository.findBySexAndParam("%"+s.getParam()+"%",s.getSex());
        }
        else if(s.getParam() != null && s.getSpecialistId() != -1L && s.getSex() != -1 ){
            return doctorRepository.findByParam("%"+s.getParam()+"%");
        }
        return doctorRepository.findAll();
    }

    @GetMapping("/public/findDoctorBySpecialist")
    public List<Doctors> findBySprcialist(@RequestParam("id") Long id) {
        return doctorRepository.findBySpecialist(id);
    }
}
