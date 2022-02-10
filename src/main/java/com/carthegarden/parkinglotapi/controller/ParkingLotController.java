package com.carthegarden.parkinglotapi.controller;

import com.carthegarden.parkinglotapi.domain.ParkingLot;
import com.carthegarden.parkinglotapi.dto.ParkingLotDTO;
import com.carthegarden.parkinglotapi.dto.ParkingSpaceDTO;
import com.carthegarden.parkinglotapi.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingLotController {

    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }


    @PostMapping("/api/parkinglot")
    public ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLotDTO.Info info) {
        ParkingLot parkingLot = parkingLotService.createParkingLot(info);
        return new ResponseEntity<>(parkingLot, HttpStatus.OK);
    }
}

// 다른 컨트롤러에 주차하기 버튼 눌렀을때 호출하는 API 추가하기 - 파라미터 memberid, parking space id    11111
// parking space id로 usage 업데이트 하고, user email로 user id 토큰 링크 포함한 메일 전송하고(서비스 두개)
// is_payed 수정하고(member)

//또다른 컨트롤러에는 사용정보 페이지에서 호출하는 API 추가   22222
// user id 로 usage 조회해서 정보 출력 - 여기서 parking space id 가지고있음
// 거기서 상세보기 버튼 누르면 위의 parkinglotinfo API 호출

//테스트용으로 post요청(출차감지) 만들어서 테스트