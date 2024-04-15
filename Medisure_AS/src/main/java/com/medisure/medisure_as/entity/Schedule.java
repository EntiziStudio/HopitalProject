package com.medisure.medisure_as.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.medisure.medisure_as.config.SqlTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "schedules_as")
@Getter
@Setter
@ToString
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date bookingDate;

    @JsonFormat(pattern = "HH:mm")
    @JsonDeserialize(using = SqlTimeDeserializer.class)
    private Time bookingTime;

    @JsonFormat(pattern = "HH:mm")
    @JsonDeserialize(using = SqlTimeDeserializer.class)
    private Time toTime;

    private String medicines;

    private String note;

    private Integer confirm;

    private Integer paid;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctors doctors;

    @ManyToOne
    @JoinColumn(name = "patientRecord_id")
    private PatientRecord patientRecord;

}
