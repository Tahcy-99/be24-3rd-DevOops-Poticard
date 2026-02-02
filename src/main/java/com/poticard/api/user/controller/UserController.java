package com.poticard.api.user.controller;


import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.user.UserService;
import com.poticard.api.user.model.UserDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 라우팅 처리를 AppConfig에서 전부 처리하기 위해서 주석처리
//@WebServlet(urlPatterns = {"/board/register"})
public class UserController implements Controller {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {


        if (req.getRequestURI().contains("login") && req.getMethod().equals("POST")) {
            UserDto.LoginReq dto = JsonParser.from(req, UserDto.LoginReq.class);
            UserDto.LoginRes loginDto = userService.login(dto);
            String jwt = loginDto.getJwt();
            resp.setHeader("Set-Cookie","ATOKEN="+jwt+"; Path=/");
            return BaseResponse.success("로그인 성공");
        }
        else if (req.getRequestURI().contains("signup") && req.getMethod().equals("POST")) {
            UserDto.SignupReq dto = JsonParser.from(req, UserDto.SignupReq.class);
            UserDto.SignupRes signupDto = userService.signup(dto);
            return  BaseResponse.success("신규 회원 "+signupDto.getUserName()+" 회원가입 성공");
        }
        return null;
    }
}
