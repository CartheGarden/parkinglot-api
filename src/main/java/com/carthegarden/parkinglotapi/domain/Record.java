package com.carthegarden.parkinglotapi.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private ParkingSpace parkingSpace;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entranceTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date exitTime;

    @CreationTimestamp
    private Date recordTime;

    private Integer charge;
}
