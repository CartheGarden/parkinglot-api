package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
}
