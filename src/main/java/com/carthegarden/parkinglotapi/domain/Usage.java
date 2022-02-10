package com.carthegarden.parkinglotapi.domain;

import com.carthegarden.parkinglotapi.dto.UsageDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicInsert
public class Usage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(unique = true)
    @OneToOne
    private ParkingSpace parkingSpace;

    @JoinColumn(unique = true)
    @OneToOne
    private Member member;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date entranceTime;

//    @Column(columnDefinition = "boolean default false")
//    private Boolean occupied;

    public Long getId() {
        return id;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public Member getMember() {
        return member;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

//    public Boolean getOccupied() {
//        return occupied;
//    }

    public static class Builder {

        private ParkingSpace parkingSpace;
        private Member member;
//        private Boolean occupied;

        public Builder(UsageDTO.Usage usage) {
            this.parkingSpace = usage.getParkingSpace();
            this.member = usage.getMember();
        }

//        public Builder SetOccupied(Boolean occupied){
//            this.occupied = occupied;
//            return this;
//        }

        public Usage build() {
            Usage usage = new Usage();
            usage.parkingSpace = parkingSpace;
            usage.member = member;

            return usage;
        }
    }
}
