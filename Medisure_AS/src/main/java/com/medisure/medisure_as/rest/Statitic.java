package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.repository.DoctorRepository;
import com.medisure.medisure_as.repository.InvoiceRepository;
import com.medisure.medisure_as.repository.ScheduleRepository;
import com.medisure.medisure_as.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Statitic {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/admin/totalStatitic")
    public List<Double> getQuantity(){
        List<Double> list = new ArrayList<>();
        list.add(userRepository.getTotal());
        list.add(doctorRepository.getTotal());
        list.add(scheduleRepository.getTotal());
        list.add(invoiceRepository.getTotal());
        return list;
    }
}
