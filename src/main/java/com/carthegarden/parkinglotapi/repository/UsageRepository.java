package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.domain.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Long> {
    Optional<Usage> findByParkingSpace(ParkingSpace parkingSpace);
}
