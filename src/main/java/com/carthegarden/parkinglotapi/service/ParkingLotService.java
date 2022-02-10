package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.ParkingLot;
import com.carthegarden.parkinglotapi.dto.ParkingLotDTO;
import com.carthegarden.parkinglotapi.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {

    public final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    // TODO: name으로 가져오기, dto parameter 형식 지정
    public ParkingLot getParkingLot() {
        return parkingLotRepository.getById(1L);
    }

    public ParkingLot createParkingLot(ParkingLotDTO.Info info) {
        ParkingLot parkingLot = new ParkingLot.Builder(info).build();
        return parkingLotRepository.save(parkingLot);
    }
}
