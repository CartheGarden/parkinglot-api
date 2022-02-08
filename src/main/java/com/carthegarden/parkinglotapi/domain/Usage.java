package com.carthegarden.parkinglotapi.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private ParkingSpace parkingSpace;

    @OneToOne
    private Member member;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entranceTime;

    @Column(columnDefinition = "boolean default false")
    private Boolean occupied;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) { this.occupied = occupied; }
}
