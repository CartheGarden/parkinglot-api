package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.domain.Record;
import com.carthegarden.parkinglotapi.repository.RecordRepository;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    public final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
}
