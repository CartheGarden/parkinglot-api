package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.repository.ParkingSpaceRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpaceService {

    public final ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }
}
