package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {

    public final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
}
