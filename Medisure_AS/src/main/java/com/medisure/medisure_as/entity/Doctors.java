package com.medisure.medisure_as.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@ToString
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String fulllName;

    private String phone;

    private String address;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    private String description;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
