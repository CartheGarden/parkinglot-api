package com.carthegarden.parkinglotapi.dto;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ParkingLotDTO {

    public static class Request {

    }

    public static class Info {
        private String weekdayStartTime;
        private String weekdayEndTime;
        private String weekendStartTime;
        private String weekendEndTime;
        private String holidayStartTime;
        private String holidayEndTime;
        private String address;
        private String adminPhone;
        private Integer basicCharge;
        private Integer basicTimeUnitMinute;
        private Integer additionalCharge;
        private Integer additionalTimeUnitMinute;
        private Integer dailyCharge;

        public String getWeekdayStartTime() {
            return weekdayStartTime;
        }

        public String getWeekdayEndTime() {
            return weekdayEndTime;
        }

        public String getWeekendStartTime() {
            return weekendStartTime;
        }

        public String getWeekendEndTime() {
            return weekendEndTime;
        }

        public String getHolidayStartTime() {
            return holidayStartTime;
        }

        public String getHolidayEndTime() {
            return holidayEndTime;
        }

        public String getAddress() {
            return address;
        }

        public String getAdminPhone() {
            return adminPhone;
        }

        public Integer getBasicCharge() {
            return basicCharge;
        }

        public Integer getBasicTimeUnitMinute() {
            return basicTimeUnitMinute;
        }

        public Integer getAdditionalCharge() {
            return additionalCharge;
        }

        public Integer getAdditionalTimeUnitMinute() {
            return additionalTimeUnitMinute;
        }

        public Integer getDailyCharge() {
            return dailyCharge;
        }
    }
}
