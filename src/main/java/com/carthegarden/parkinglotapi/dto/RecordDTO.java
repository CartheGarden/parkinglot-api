package com.carthegarden.parkinglotapi.dto;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.domain.ParkingSpace;

import java.util.Date;

public class RecordDTO {

    public static class Request {

        private String parkingLockId;

        public String getParkingLockId() {
            return parkingLockId;
        }
    }

    public static class Record {

        private Member member;
        private ParkingSpace parkingSpace;
        private Integer charge;
        private Date entranceTime;
        private Date exitTime;

        public Record(Member member, ParkingSpace parkingSpace, Integer charge, Date entranceTime, Date exitTime) {
            this.member = member;
            this.parkingSpace = parkingSpace;
            this.charge = charge;
            this.entranceTime = entranceTime;
            this.exitTime = exitTime;
        }

        public Member getMember() {
            return member;
        }

        public ParkingSpace getParkingSpace() {
            return parkingSpace;
        }

        public Integer getCharge() {
            return charge;
        }

        public Date getEntranceTime() {
            return entranceTime;
        }

        public Date getExitTime() {
            return exitTime;
        }
    }
}
