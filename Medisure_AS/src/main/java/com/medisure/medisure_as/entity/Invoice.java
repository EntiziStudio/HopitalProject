package com.medisure.medisure_as.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@ToString
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Timestamp createdDate;

    private Double totalAmount;

    private String note;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
