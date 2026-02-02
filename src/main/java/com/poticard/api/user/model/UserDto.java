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

    public static class SignupReq{
        private String email;
        private String password;
        private String userName;
        private String userPhone;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public SignupReq() {
        }

        public SignupReq(String email, String password, String userName, String userPhone) {
            this.email = email;
            this.password = password;
            this.userName = userName;
            this.userPhone = userPhone;
        }
    }

    public static class SignupRes {
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public SignupRes() {
        }

        public SignupRes(String userName) {
            this.userName = userName;
        }
    }
}
