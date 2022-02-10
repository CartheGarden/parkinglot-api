package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNaverId(String naverId);
}
