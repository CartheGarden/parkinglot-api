package com.carthegarden.parkinglotapi.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: 생성시에도 현재시간으로 timestamp 자동으로 들어가는지 확인
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Temporal(TemporalType.TIME)
    private Date weekdayStartTime;

    @Temporal(TemporalType.TIME)
    private Date weekdayEndTime;

    @Temporal(TemporalType.TIME)
    private Date weekendStartTime;

    @Temporal(TemporalType.TIME)
    private Date weekendEndTime;

    @Temporal(TemporalType.TIME)
    private Date holidayStartTime;

    @Temporal(TemporalType.TIME)
    private Date holidayEndTime;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getWeekdayStartTime() {
        return weekdayStartTime;
    }

    public void setWeekdayStartTime(Date weekdayStartTime) {
        this.weekdayStartTime = weekdayStartTime;
    }

    public Date getWeekdayEndTime() {
        return weekdayEndTime;
    }

    public void setWeekdayEndTime(Date weekdayEndTime) {
        this.weekdayEndTime = weekdayEndTime;
    }

    public Date getWeekendStartTime() {
        return weekendStartTime;
    }

    public void setWeekendStartTime(Date weekendStartTime) {
        this.weekendStartTime = weekendStartTime;
    }

    public Date getWeekendEndTime() {
        return weekendEndTime;
    }

    public void setWeekendEndTime(Date weekendEndTime) {
        this.weekendEndTime = weekendEndTime;
    }

    public Date getHolidayStartTime() {
        return holidayStartTime;
    }

    public void setHolidayStartTime(Date holidayStartTime) {
        this.holidayStartTime = holidayStartTime;
    }

    public Date getHolidayEndTime() {
        return holidayEndTime;
    }

    public void setHolidayEndTime(Date holidayEndTime) {
        this.holidayEndTime = holidayEndTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Integer getBasicCharge() {
        return basicCharge;
    }

    public void setBasicCharge(Integer basicCharge) {
        this.basicCharge = basicCharge;
    }

    public Integer getBasicTimeUnitMinute() {
        return basicTimeUnitMinute;
    }

    public void setBasicTimeUnitMinute(Integer basicTimeUnitMinute) {
        this.basicTimeUnitMinute = basicTimeUnitMinute;
    }

    public Integer getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Integer additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    public Integer getAdditionalTimeUnitMinute() {
        return additionalTimeUnitMinute;
    }

    public void setAdditionalTimeUnitMinute(Integer additionalTimeUnitMinute) {
        this.additionalTimeUnitMinute = additionalTimeUnitMinute;
    }

    public Integer getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(Integer dailyCharge) {
        this.dailyCharge = dailyCharge;
    }
}
