package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.domain.Record;
import com.carthegarden.parkinglotapi.domain.Usage;
import com.carthegarden.parkinglotapi.dto.RecordDTO;
import com.carthegarden.parkinglotapi.repository.ParkingSpaceRepository;
import com.carthegarden.parkinglotapi.repository.RecordRepository;
import com.carthegarden.parkinglotapi.repository.UsageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class RecordService {

    public final RecordRepository recordRepository;
    public final ParkingSpaceRepository parkingSpaceRepository;
    public final UsageRepository usageRepository;
    public final BillService billService;

    public RecordService(RecordRepository recordRepository, ParkingSpaceRepository parkingSpaceRepository, UsageRepository usageRepository, BillService billService) {
        this.recordRepository = recordRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.usageRepository = usageRepository;
        this.billService = billService;
    }

    @Transactional
    public Record createRecord(RecordDTO.Request request) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findByParkingLockId(request.getParkingLockId()).orElseThrow(NoSuchFieldError::new);
        Usage usage = usageRepository.findByParkingSpace(parkingSpace).orElseThrow(NoSuchFieldError::new);

        // TODO: parkingSpace에서 가져온 parkinglot과 현재시간으로 charge 계산
        Date currentTime = new Date();
        int charge = billService.GetCharge(parkingSpace.getParkingLot(), usage.getEntranceTime(), currentTime);
        RecordDTO.Record recordBuild = new RecordDTO.Record(usage.getMember(), parkingSpace, charge, usage.getEntranceTime(), currentTime);
        Record record = new Record.Builder(recordBuild).build();
        recordRepository.save(record);

        usage.getMember().updatePayed(false);
        usageRepository.delete(usage);
        return record;
    }
}
