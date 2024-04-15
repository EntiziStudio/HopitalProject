package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.entity.PatientRecord;
import com.medisure.medisure_as.entity.User;
import com.medisure.medisure_as.repository.PatientRecordRepository;
import com.medisure.medisure_as.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientRecordRest {

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/user/checkExistPatient")
    public Boolean checkExistPatient(){
        User user = userService.getUserWithAuthority();
        Optional<PatientRecord> patientRecord = patientRecordRepository.findByUserId(user.getId());
        if(patientRecord.isPresent()){
            return true;
        }
        return false;
    }

    @GetMapping("/user/getPatientRecordByUserLogged")
    public PatientRecord findByUserLogged() throws Exception {
        User user = userService.getUserWithAuthority();
        Optional<PatientRecord> patientRecord = patientRecordRepository.findByUserId(user.getId());
        if(patientRecord.isPresent() == false){
            throw new Exception("not found a patientRecord of this user");
        }
        return patientRecord.get();
    }

    @PostMapping("/user/addOrUpdatePatient")
    public PatientRecord save(@RequestBody PatientRecord patientRecord) throws Exception {
        User user = userService.getUserWithAuthority();
        patientRecord.setUser(user);
        return patientRecordRepository.save(patientRecord);
    }

    @PostMapping("/user/updatepatient")
    public PatientRecord update(@RequestBody PatientRecord patientRecord) throws Exception {
        User user = userService.getUserWithAuthority();
        Optional<PatientRecord> p = patientRecordRepository.findById(patientRecord.getId());
        if(p.get().getUser().getId() != user.getId()){
            throw new Exception("access denied");
        }
        patientRecord.setUser(user);
        return patientRecordRepository.save(patientRecord);
    }
}
