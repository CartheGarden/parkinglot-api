package com.carthegarden.parkinglotapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "boolean default true")
    private Boolean isPayed;

    private String name;

    private String email;

    private String naverId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNaverId() {
        return naverId;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public Member updatePayed(Boolean payed){
        isPayed = payed;
        return this;
    }
}
