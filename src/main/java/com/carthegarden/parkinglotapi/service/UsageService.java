package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.domain.Usage;
import com.carthegarden.parkinglotapi.dto.UsageDTO;
import com.carthegarden.parkinglotapi.repository.MemberRepository;
import com.carthegarden.parkinglotapi.repository.ParkingSpaceRepository;
import com.carthegarden.parkinglotapi.repository.UsageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsageService {

    public final UsageRepository usageRepository;
    public final MemberRepository memberRepository;
    public final ParkingSpaceRepository parkingSpaceRepository;

    public UsageService(UsageRepository usageRepository, MemberRepository memberRepository, ParkingSpaceRepository parkingSpaceRepository) {
        this.usageRepository = usageRepository;
        this.memberRepository = memberRepository;
        this. parkingSpaceRepository = parkingSpaceRepository;
    }

    public Optional<Usage> getUsageInfo(Long usageId) {
        return usageRepository.findById(usageId);
    }

    @Transactional
    public Usage register(UsageDTO.Request request) {

        Member member = memberRepository.findByNaverId(request.getNaverId()).orElseThrow(NoSuchElementException::new);
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(request.getParkingSpaceId()).orElseThrow(NoSuchElementException::new);

        UsageDTO.Usage usageBuild = new UsageDTO.Usage(parkingSpace, member);
        Usage usage = new Usage.Builder(usageBuild).build();
        // TODO: parkingSpace available false로 변경, Member is_payed 필드 수정
        return usageRepository.save(usage);
    }
}
