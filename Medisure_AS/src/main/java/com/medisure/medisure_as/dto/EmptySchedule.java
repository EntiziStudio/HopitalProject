package com.medisure.medisure_as.dto;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class EmptySchedule {

    private List<Doctors> doctorsList;

    private List<Room> roomList;

}
