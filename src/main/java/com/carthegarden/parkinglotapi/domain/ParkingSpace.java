package com.carthegarden.parkinglotapi.domain;

import com.carthegarden.parkinglotapi.dto.ParkingSpaceDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String parkingLockId;

    @ManyToOne(cascade = CascadeType.ALL)
    private ParkingLot parkingLot;

    @Column(columnDefinition = "boolean default true")
    private Boolean available;

    private String section;

    public Boolean getAvailable() {
        return available;
    }

    public Long getId() {
        return id;
    }

    public String getParkingLockId() {
        return parkingLockId;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public String getSection() {
        return section;
    }

    public static class Builder {

        private ParkingLot parkingLot;
        private String section;
        private String parkingLockId;
        private Boolean available;

        public Builder(ParkingSpaceDTO.Info info) {
            this.parkingLot = info.getParkingLot();
            this.section = info.getSection();
        }

        public Builder setAvailable(Boolean available) {
            this.available = available;
            return this;
        }

        public Builder setParkingLockId(String parkingLockId) {
            this.parkingLockId = parkingLockId;
            return this;
        }

        public ParkingSpace build() {
            ParkingSpace parkingSpace = new ParkingSpace();
            parkingSpace.parkingLot = parkingLot;
            parkingSpace.section = section;
            parkingSpace.available = available;
            parkingSpace.parkingLockId = parkingLockId;

            return parkingSpace;
        }
    }
}
