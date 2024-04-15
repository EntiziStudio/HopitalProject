package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.Room;
import com.medisure.medisure_as.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RoomRest {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/addmin/addOrUpdateRoom")
    public Room addOrUpdateRoom(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @DeleteMapping("/addmin/deleteRoom")
    public void deleteRoom(@RequestParam("id") Long id){
        roomRepository.deleteById(id);
    }

    @GetMapping("/addmin/findAllRoom")
    public List<Room> findAll(){
        return roomRepository.findAll();
    }
}
