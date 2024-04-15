package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.entity.PatientRecord;
import com.medisure.medisure_as.entity.Request;
import com.medisure.medisure_as.entity.Room;
import com.medisure.medisure_as.entity.User;
import com.medisure.medisure_as.repository.PatientRecordRepository;
import com.medisure.medisure_as.repository.RequestRepository;
import com.medisure.medisure_as.service.MailService;
import com.medisure.medisure_as.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RequestRest {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Autowired
    private MailService mailService;

    // user send request to admin
    @PostMapping("/user/addRequest")
    public Request addOrUpdateRequest(@RequestBody Request request) throws Exception {
        User user = userService.getUserWithAuthority();
        request.setActived(0);
        request.setCreatedDate(new Date(System.currentTimeMillis()));
        request.setCreatedTime(new Time(System.currentTimeMillis()));
        Optional<PatientRecord> patientRecord = patientRecordRepository.findByUserId(user.getId());
        if(patientRecord.isPresent() == false){
            throw new Exception("1");
        }
        request.setPatientRecord(patientRecord.get());
        return requestRepository.save(request);
    }

    // admin confirm request for user
    @PostMapping("/addmin/activeRequest")
    public void activeRequest(@RequestParam("id") Long id){
        Request request = requestRepository.findById(id).get();
        request.setActived(1);
        requestRepository.save(request);
        User user = request.getPatientRecord().getUser();

        mailService.sendEmail(user.getEmail(), "Congratulations on your successful appointment",
        "We have confirmed your appointment request, please go to profile for details", false, false);
    }

    @GetMapping("/addmin/findRequestNotActive")
    public List<Request> findRequestNotActive(){
        List<Request> list = requestRepository.findRequestByActive(0);
        return list;
    }

    @GetMapping("/addmin/findRequestActived")
    public List<Request> findRequestActived(){
        List<Request> list = requestRepository.findRequestByActive(1);
        return list;
    }
}
