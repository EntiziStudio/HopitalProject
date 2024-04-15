package com.medisure.medisure_as.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "medical_process")
@Getter
@Setter
public class MedicalProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String processName;

    private String description;

    private Double price;
}
