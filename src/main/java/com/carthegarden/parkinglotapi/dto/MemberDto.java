package com.carthegarden.parkinglotapi.dto;

public class MemberDto {

    public static class MemberLoginDto {

        private String name;
        private String email;
        private String naverId;

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getNaverId() {
            return naverId;
        }

    }
}
