package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
