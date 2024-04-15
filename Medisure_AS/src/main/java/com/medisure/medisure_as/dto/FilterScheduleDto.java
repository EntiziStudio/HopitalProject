package com.medisure.medisure_as.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class FilterScheduleDto {

    private Date startDate;

    private Date endDate;

    private Integer paid;

}
