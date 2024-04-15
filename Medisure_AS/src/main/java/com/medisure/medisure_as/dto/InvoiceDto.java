package com.medisure.medisure_as.dto;

import com.medisure.medisure_as.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InvoiceDto {

    private Double totalAmount;

    private String note;

    private Schedule schedule;

    private List<Long> listProcess;
}
