package com.carthegarden.parkinglotapi.controller;

import com.carthegarden.parkinglotapi.domain.ParkingLot;
import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.dto.ParkingLotDTO;
import com.carthegarden.parkinglotapi.dto.ParkingSpaceDTO;
import com.carthegarden.parkinglotapi.repository.UsageRepository;
import com.carthegarden.parkinglotapi.service.ParkingSpaceService;
import com.carthegarden.parkinglotapi.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ParkingSpaceController {

    private ParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("/api/parkingspace/{parkingLockId}")
    public ResponseEntity<Optional<ParkingSpace>> getParkingSpace(@PathVariable("parkingLockId") String parkingLockId) {
        Optional<ParkingSpace> parkingSpace = parkingSpaceService.getParkingSpace(parkingLockId);
        // TODO: null일경우 예외처리(null 반환 X)
        return new ResponseEntity<>(parkingSpace, HttpStatus.OK);
    }

    @PostMapping("/api/parkingspace")
    public ResponseEntity<ParkingSpace> createParkingSpace(@RequestBody ParkingSpaceDTO.RequestWithId request) {
        ParkingSpace parkingSpace = parkingSpaceService.createParkingSpace(request);
        //TODO: Usage도 같이 등록
        return new ResponseEntity<>(parkingSpace, HttpStatus.OK);
    }
}
