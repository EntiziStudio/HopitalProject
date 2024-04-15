package com.medisure.medisure_as.dto;

import com.medisure.medisure_as.entity.Doctors;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class SearchScheduleDto {

    private Date date;

    private Doctors doctors;


}
