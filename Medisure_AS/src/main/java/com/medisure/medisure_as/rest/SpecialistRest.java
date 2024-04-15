package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.entity.Schedule;
import com.medisure.medisure_as.entity.Specialist;
import com.medisure.medisure_as.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SpecialistRest {

    @Autowired
    private SpecialistRepository specialistRepository;

    @GetMapping("/public/allSpecialist")
    public List<Specialist> findAll(){
        return specialistRepository.findAll();
    }

    @GetMapping("/public/getSpecialistById")
    public Specialist findById(@RequestParam("id") Long id){
        return specialistRepository.findById(id).get();
    }

    @PostMapping("/admin/saveOrUpdateSpecialist")
    public Specialist saveOrUpdate(@RequestBody Specialist specialist){
        return specialistRepository.save(specialist);
    }

    @DeleteMapping("/admin/deleteSpecialist")
    public void saveOrUpdate(@RequestParam("id") Long id){
        specialistRepository.deleteById(id);
    }
}
