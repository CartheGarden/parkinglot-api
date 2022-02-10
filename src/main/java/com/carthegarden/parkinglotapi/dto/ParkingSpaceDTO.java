package com.carthegarden.parkinglotapi.dto;

import com.carthegarden.parkinglotapi.domain.ParkingLot;

public class ParkingSpaceDTO {

    public static class Request {

        private String parkingLockId;

        public String getParkingLockId() {
            return parkingLockId;
        }
    }

    public static class RequestWithId {

        private Long parkingLotId;

        private String section;

        private String parkingLockId;

        public Long getParkingLotId() {
            return parkingLotId;
        }

        public String getSection() {
            return section;
        }

        public String getParkingLockId() {
            return parkingLockId;
        }
    }

    // TODO: use builder
    public static class Info {

        public Info(ParkingLot parkingLot, String section) {
            this.parkingLot = parkingLot;
            this.section = section;
        }

        public Info(ParkingLot parkingLot, String section, String parkingLockId) {
            this.parkingLot = parkingLot;
            this.section = section;
            this.parkingLockId = parkingLockId;
        }

        private ParkingLot parkingLot;

        private String section;

        private String parkingLockId;

        public ParkingLot getParkingLot() {
            return parkingLot;
        }

        public String getSection() {
            return section;
        }

        public String getParkingLockId() {
            return parkingLockId;
        }
    }
}
