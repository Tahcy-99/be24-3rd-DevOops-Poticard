package com.poticard.api.user;

import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.user.model.UserDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController implements Controller {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {

        // ✅ 과제 예시처럼 requestURI 기반 분기 (contains + method)
        String uri = req.getRequestURI();

        // 회원가입
        if (uri.contains("/user/signup") && req.getMethod().equals("POST")) {
            UserDto dto = JsonParser.from(req, UserDto.class);

            UserDto created = userService.signup(dto);
            if (created == null) {
                return BaseResponse.fail("SIGNUP_FAILED");
            }
            return BaseResponse.success(created);
        }

        // 로그인
        if (uri.contains("/user/login") && req.getMethod().equals("POST")) {
            UserDto dto = JsonParser.from(req, UserDto.class);

            UserDto loginUser = userService.login(dto.getEmail(), dto.getPassword());
            if (loginUser == null) {
                return BaseResponse.fail("LOGIN_FAILED");
            }
            return BaseResponse.success(loginUser);
        }

        // 비밀번호 찾기 (일단 과제용으로 이메일로 조회만 예시)
        if (uri.contains("/user/password/find") && req.getMethod().equals("POST")) {
            UserDto dto = JsonParser.from(req, UserDto.class);

            UserDto found = userService.findByEmail(dto.getEmail());
            if (found == null) {
                return BaseResponse.fail("NOT_FOUND_USER");
            }
            return BaseResponse.success(found);
        }

        return BaseResponse.fail("NOT_FOUND");
    }
}
