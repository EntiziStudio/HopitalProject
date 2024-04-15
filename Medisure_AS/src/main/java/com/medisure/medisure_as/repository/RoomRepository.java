package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
