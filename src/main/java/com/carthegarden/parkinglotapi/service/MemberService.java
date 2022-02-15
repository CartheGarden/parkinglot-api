package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.dto.MemberDto;
import com.carthegarden.parkinglotapi.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MemberService {

    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member loginMember(MemberDto.MemberLoginDto memberLoginDto) {

        String naverId = memberLoginDto.getNaverId();
        Member member;
        Optional<Member> optionalMember = memberRepository.findByNaverId(naverId);
        if(!optionalMember.isPresent()) {
            Member newMember = new Member.Builder(memberLoginDto).build();
            member = memberRepository.save(newMember);
        } else {
            member = optionalMember.get();
        }

        return member;
    }
}
