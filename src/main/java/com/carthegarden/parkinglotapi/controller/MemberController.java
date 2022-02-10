package com.carthegarden.parkinglotapi.controller;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.dto.MemberDto;
import com.carthegarden.parkinglotapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<Member> memberLogin(@RequestBody MemberDto.MemberLoginDto memberLoginDto) {

        Member member =memberService.loginMember(memberLoginDto);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
