package com.carthegarden.parkinglotapi.dto;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.domain.Usage;

import java.util.Date;

public class UsageDTO {

    public static class Request {

        private String naverId;
        private Long parkingSpaceId;

        public String getNaverId() {
            return naverId;
        }

        public Long getParkingSpaceId() {
            return parkingSpaceId;
        }

    }

    public static class UsageWithBill {

        public UsageWithBill(com.carthegarden.parkinglotapi.domain.Usage usage, long usageMinute, int charge) {
            this.usage = usage;
            this.usageMinute = usageMinute;
            this.charge = charge;
        }

        private com.carthegarden.parkinglotapi.domain.Usage usage;
        private long usageMinute;
        private int charge;

        public com.carthegarden.parkinglotapi.domain.Usage getUsage() {
            return usage;
        }

        public long getUsageMinute() {
            return usageMinute;
        }

        public int getCharge() {
            return charge;
        }
    }

    public static class Usage {

        public Usage(ParkingSpace parkingSpace, Member member) {
            this.parkingSpace = parkingSpace;
            this.member = member;
        }

        private ParkingSpace parkingSpace;
        private Member member;

        public ParkingSpace getParkingSpace() {
            return parkingSpace;
        }

        public Member getMember() {
            return member;
        }
    }
}
