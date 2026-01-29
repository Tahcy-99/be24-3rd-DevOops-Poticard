package com.poticard.api.user;

import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController implements Controller {
    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("UserController 실행");
        return null;
    }
}
