package com.carthegarden.parkinglotapi.controller;

import com.carthegarden.parkinglotapi.domain.Usage;
import com.carthegarden.parkinglotapi.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsageController {

    private UsageService usageService;

    @Autowired
    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }
}
