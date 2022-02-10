package com.carthegarden.parkinglotapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class ParkinglotApiApplication {

//	@PostConstruct
//	public void started() {
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
//		System.out.println("현재 시각: " + new Date());
//	}

	public static void main(String[] args) {
		SpringApplication.run(ParkinglotApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:19006");
			}
		};
	}
}
