package com.medisure.medisure_as.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "detail_invoice")
@Getter
@Setter
public class DetailInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicalProcess_id")
    private MedicalProcess medicalProcess;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
