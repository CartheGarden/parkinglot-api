package com.carthegarden.parkinglotapi.controller;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.domain.Usage;
import com.carthegarden.parkinglotapi.dto.UsageDTO;
import com.carthegarden.parkinglotapi.service.BillService;
import com.carthegarden.parkinglotapi.service.MailService;
import com.carthegarden.parkinglotapi.service.ParkingLockService;
import com.carthegarden.parkinglotapi.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UsageController {

    private UsageService usageService;
    private MailService mailService;
    private ParkingLockService parkingLockService;
    private BillService billService;

    @Autowired
    public UsageController(UsageService usageService, MailService mailService, ParkingLockService parkingLockService, BillService billService) {
        this.usageService = usageService;
        this.mailService = mailService;
        this.parkingLockService = parkingLockService;
        this.billService = billService;
    }

    @GetMapping("/api/usage/{id}")
    public ResponseEntity<UsageDTO.UsageWithBill> getUsageInfo(@PathVariable("id") Long usageId) {
        Usage usage = usageService.getUsageInfo(usageId).orElseThrow(NoSuchFieldError::new);
        long usageMinute = billService.GetUsageMinute(usage.getEntranceTime());
        int charge = billService.GetCharge(usage.getParkingSpace().getParkingLot(), usage.getEntranceTime(), new Date());
        UsageDTO.UsageWithBill usageInfo = new UsageDTO.UsageWithBill(usage, usageMinute, charge);
        return new ResponseEntity<>(usageInfo, HttpStatus.OK);
    }

    // User client 주차하기 버튼 & 로그인 완료시 호출
    @PostMapping("/api/usage")
    public ResponseEntity<Usage> useParkingSpace(@RequestBody UsageDTO.Request request) {
        Usage usage = usageService.register(request);
        Member member = usage.getMember();
        mailService.sendMail("어따하지 이용 안내", member.getEmail(), member.getName(), usage.getId());

        parkingLockService.deactivate();
        // TODO: 하드웨어 장치에 신호 보내기

        return new ResponseEntity<>(usage, HttpStatus.OK);
    }

    @GetMapping("/api/usage/parkingLockList")
    public ResponseEntity<List<String>> getParkingLockList() {
        List<String> parkingLockList = usageService.getParkingLockList();
        return new ResponseEntity<>(parkingLockList, HttpStatus.OK);
    }
}
