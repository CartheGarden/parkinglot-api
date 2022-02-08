package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
