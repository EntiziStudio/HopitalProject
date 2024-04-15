package com.medisure.medisure_as.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProcessDto {
    private Long scheduleId;
    private List<Long> listProcess;
}
