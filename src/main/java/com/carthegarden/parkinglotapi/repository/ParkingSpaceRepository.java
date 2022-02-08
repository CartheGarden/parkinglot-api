package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
}
