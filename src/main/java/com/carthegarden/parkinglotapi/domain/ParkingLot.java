package com.carthegarden.parkinglotapi.domain;

import com.carthegarden.parkinglotapi.dto.ParkingLotDTO;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: 생성시에도 현재시간으로 timestamp 자동으로 들어가는지 확인
    // -> 자동생성됨. TIMEZONE 설정 필요
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    private String name;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

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

    public static class Builder {

        private String weekdayStartTime;
        private String weekdayEndTime;
        private String weekendStartTime;
        private String weekendEndTime;
        private String holidayStartTime;
        private String holidayEndTime;
        private String address;
        private String adminPhone;
        private String name;
        private Integer basicCharge;
        private Integer basicTimeUnitMinute;
        private Integer additionalCharge;
        private Integer additionalTimeUnitMinute;
        private Integer dailyCharge;

        public Builder(ParkingLotDTO.Info info) {
            this.weekdayStartTime = info.getWeekdayStartTime();
            this.weekdayEndTime = info.getWeekdayEndTime();
            this.weekendStartTime = info.getWeekendStartTime();
            this.weekendEndTime = info.getWeekendEndTime();
            this.holidayStartTime = info.getHolidayStartTime();
            this.holidayEndTime = info.getHolidayEndTime();
            this.address = info.getAddress();
            this.adminPhone = info.getAdminPhone();
            this.name = info.getName();
            this.basicCharge = info.getBasicCharge();
            this.basicTimeUnitMinute = info.getBasicTimeUnitMinute();
            this.additionalCharge = info.getAdditionalCharge();
            this.additionalTimeUnitMinute = info.getAdditionalTimeUnitMinute();
            this.dailyCharge = info.getDailyCharge();
        }

        public ParkingLot build() {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.weekdayStartTime = weekdayStartTime;
            parkingLot.weekdayEndTime = weekdayEndTime;
            parkingLot.weekendStartTime = weekendStartTime;
            parkingLot.weekendEndTime = weekendEndTime;
            parkingLot.holidayStartTime = holidayStartTime;
            parkingLot.holidayEndTime = holidayEndTime;
            parkingLot.address = address;
            parkingLot.adminPhone = adminPhone;
            parkingLot.name = name;
            parkingLot.basicCharge = basicCharge;
            parkingLot.basicTimeUnitMinute = basicTimeUnitMinute;
            parkingLot.additionalCharge = additionalCharge;
            parkingLot.additionalTimeUnitMinute = additionalTimeUnitMinute;
            parkingLot.dailyCharge = dailyCharge;

            return parkingLot;
        }
    }
}
