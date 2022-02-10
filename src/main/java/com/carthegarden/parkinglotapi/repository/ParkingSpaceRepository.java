package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    Optional<ParkingSpace> findByParkingLockId(String parkingLockId);
    ParkingSpace getParkingSpaceByParkingLockId(String parkingLockId);
}
