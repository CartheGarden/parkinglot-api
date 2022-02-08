package com.carthegarden.parkinglotapi.service;

import com.carthegarden.parkinglotapi.repository.UsageRepository;
import org.springframework.stereotype.Service;

@Service
public class UsageService {

    public final UsageRepository usageRepository;

    public UsageService(UsageRepository usageRepository) {
        this.usageRepository = usageRepository;
    }
}
