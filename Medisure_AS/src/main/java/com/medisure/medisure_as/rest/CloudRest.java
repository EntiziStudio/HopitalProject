package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CloudRest {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/public/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return cloudinaryService.uploadFile(file);
    }
}
