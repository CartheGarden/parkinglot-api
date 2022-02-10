package com.carthegarden.parkinglotapi.domain;

import com.carthegarden.parkinglotapi.dto.MemberDto;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicInsert
public class Member {
    /* Table Field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "boolean default true")
    private Boolean isPayed;

    private String name;

    private String email;

    private String naverId;

    /* Getter */
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

    /* Builder Pattern */
    public static class Builder {
        private String name;
        private String email;
        private String naverId;

        public Builder(MemberDto.MemberLoginDto memberLoginDto) {
            this.name = memberLoginDto.getName();
            this.email = memberLoginDto.getEmail();
            this.naverId = memberLoginDto.getNaverId();
        }

        public Member build() {
            Member member = new Member();
            member.name = name;
            member.email = email;
            member.naverId = naverId;

            return member;
        }
    }
}
