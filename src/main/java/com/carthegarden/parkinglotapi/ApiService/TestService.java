package com.carthegarden.parkinglotapi.ApiService;

import com.carthegarden.parkinglotapi.ApiDomain.Member;
import com.carthegarden.parkinglotapi.ApiRepository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Long join(Member user) {

        testRepository.save(user);
        return user.getId();
    }
}
