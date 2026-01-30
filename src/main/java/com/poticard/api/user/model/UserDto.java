package com.poticard.api.user.model;

import jakarta.servlet.http.HttpServletRequest;

public class UserDto {
    public static class LoginReq {
        private String loginEmail;
        private String loginPw;

        public String getLoginEmail() {
            return loginEmail;
        }

        public void setLoginEmail(String loginEmail) {
            this.loginEmail = loginEmail;
        }

        public String getLoginPw() {
            return loginPw;
        }

        public void setLoginPw(String loginPw) {
            this.loginPw = loginPw;
        }

        public LoginReq() {
        }

        public LoginReq(String loginEmail, String loginPw) {
            this.loginEmail = loginEmail;
            this.loginPw = loginPw;
        }
    }

    public static class LoginRes {
        private String jwt;

        public String getJwt() {
            return jwt;
        }

        public void setJwt(String jwt) {
            this.jwt = jwt;
        }

        public LoginRes() {
        }

        public LoginRes(String jwt) {
            this.jwt = jwt;
        }
    }
}
