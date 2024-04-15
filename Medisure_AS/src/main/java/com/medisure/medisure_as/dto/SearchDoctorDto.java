package com.medisure.medisure_as.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchDoctorDto {

    private String param;

    private Integer sex;

    private Long specialistId;
}
