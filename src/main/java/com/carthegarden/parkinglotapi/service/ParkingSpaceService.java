package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.ParkingLot;
import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.domain.Usage;
import com.carthegarden.parkinglotapi.dto.ParkingSpaceDTO;
import com.carthegarden.parkinglotapi.dto.UsageDTO;
import com.carthegarden.parkinglotapi.repository.ParkingLotRepository;
import com.carthegarden.parkinglotapi.repository.ParkingSpaceRepository;
import com.carthegarden.parkinglotapi.repository.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ParkingSpaceService {

    public final ParkingSpaceRepository parkingSpaceRepository;
    public final ParkingLotRepository parkingLotRepository;
    public final UsageRepository usageRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, ParkingLotRepository parkingLotRepository, UsageRepository usageRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.usageRepository = usageRepository;
    }

    public Optional<ParkingSpace> getParkingSpace(String parkingLockId) {
        return parkingSpaceRepository.findByParkingLockId(parkingLockId);
    }

    @Transactional
    public ParkingSpace createParkingSpace(ParkingSpaceDTO.RequestWithId request) {

        // TODO: 예외처리, 구조변경
        ParkingLot parkingLot = parkingLotRepository.findById(request.getParkingLotId())
                                                    .orElseThrow(NoSuchElementException::new);
        ParkingSpaceDTO.Info info = new ParkingSpaceDTO.Info(parkingLot, request.getSection(), request.getParkingLockId());
        ParkingSpace parkingSpaceBuild = new ParkingSpace.Builder(info)
                                                    .setParkingLockId(request.getParkingLockId())
                                                    .build();
        return parkingSpaceRepository.save(parkingSpaceBuild);
//        UsageDTO.Register register = new UsageDTO.Register(parkingSpace);
//        Usage usageBuild = new Usage.Builder(register).build();
//        usageRepository.save(usageBuild);
//        return parkingSpace;
        // TODO: Entity builder에서 save?
    }
}
