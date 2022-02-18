package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.ParkingLot;
import com.carthegarden.parkinglotapi.domain.Usage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillService {

    public long GetUsageMinute(Date startTime) {
        return (new Date().getTime() - startTime.getTime()) / (60*1000);
    }

    public long GetUsageMinute(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / (60*1000);
    }

    public int GetCharge(ParkingLot parkingLot, Date entranceTime, Date currentTime) {
        long usageMinute = GetUsageMinute(entranceTime, currentTime);
        int basicTimeUnitMinute = parkingLot.getBasicTimeUnitMinute();
        int charge = parkingLot.getBasicCharge();
        if (usageMinute > basicTimeUnitMinute) {
            charge += (((usageMinute - basicTimeUnitMinute) / parkingLot.getAdditionalTimeUnitMinute()) + 1) * parkingLot.getAdditionalCharge();
        }
        return charge;
    }
}
