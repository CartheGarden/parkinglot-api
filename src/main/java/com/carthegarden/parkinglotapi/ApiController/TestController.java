package com.carthegarden.parkinglotapi.ApiController;

import com.carthegarden.parkinglotapi.ApiDomain.Member;
import com.carthegarden.parkinglotapi.ApiService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public Long testResponseBody(@RequestParam("name") String name) {
        System.out.println(name);
        Member user = new Member();
        user.setUsername(name);
        System.out.println(user.getUsername());
        Long id = testService.join(user);
        System.out.println(id);
        return id;
    }
}
