package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
