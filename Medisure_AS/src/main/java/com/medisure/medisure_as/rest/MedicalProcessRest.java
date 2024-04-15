package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.entity.MedicalProcess;
import com.medisure.medisure_as.entity.Specialist;
import com.medisure.medisure_as.repository.MedicalProcessRepository;
import com.medisure.medisure_as.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MedicalProcessRest {

    @Autowired
    private MedicalProcessRepository medicalProcessRepository;

    @GetMapping("/public/allMedicalProcess")
    public List<MedicalProcess> findAll(){
        return medicalProcessRepository.findAll();
    }

    @GetMapping("/public/medicalProcessById")
    public MedicalProcess findById(@RequestParam("id") Long id){
        return medicalProcessRepository.findById(id).get();
    }

    @PostMapping("/admin/saveOrUpdateMedicalProcess")
    public MedicalProcess saveOrUpdate(@RequestBody MedicalProcess specialist){
        return medicalProcessRepository.save(specialist);
    }

    @DeleteMapping("/admin/deleteMedicalProcess")
    public void delete(@RequestParam("id") Long id){
        medicalProcessRepository.deleteById(id);
    }
}
