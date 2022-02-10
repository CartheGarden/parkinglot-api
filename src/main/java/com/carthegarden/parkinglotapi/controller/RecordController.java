package com.carthegarden.parkinglotapi.controller;

import com.carthegarden.parkinglotapi.domain.Record;
import com.carthegarden.parkinglotapi.dto.RecordDTO;
import com.carthegarden.parkinglotapi.service.MailService;
import com.carthegarden.parkinglotapi.service.ParkingLockService;
import com.carthegarden.parkinglotapi.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    private RecordService recordService;
    private MailService mailService;
    private ParkingLockService parkingLockService;

    @Autowired
    public RecordController(RecordService recordService, MailService mailService, ParkingLockService parkingLockService) {
        this.recordService = recordService;
        this.mailService = mailService;
        this.parkingLockService = parkingLockService;
    }

    // ParkingLock에서 출차 감지시 호출(gateway에서?)
    @PostMapping("/api/record")
    public ResponseEntity<Record> CreateRecord(@RequestBody RecordDTO.Request request) {
        Record record = recordService.createRecord(request);

        mailService.sendMail("사용 종료", "요금: "+record.getCharge(), "hskeen@naver.com");
        // TODO: 이메일 템플릿 설정

        parkingLockService.activate();
        // TODO: 하드웨어 장치에 신호 보내기

        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}
