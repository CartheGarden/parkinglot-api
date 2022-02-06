package com.carthegarden.parkinglotapi.ApiRepository;

import com.carthegarden.parkinglotapi.ApiDomain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Member, Long> {
}
