package com.poticard.api.namecard.controller;


import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.namecard.NamecardService;
import com.poticard.api.namecard.model.NamecardDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 라우팅 처리를 AppConfig에서 전부 처리하기 위해서 주석처리
public class NamecardCreateController implements Controller {
    private final NamecardService namecardService;

    public NamecardCreateController(NamecardService namecardService) {
        this.namecardService = namecardService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        NamecardDto.CreateRes response = null;

        if (req.getRequestURI().contains("create") && req.getMethod().equals("POST")) {
            NamecardDto.CreateReq reqDto = JsonParser.from(req, NamecardDto.CreateReq.class);
            response = namecardService.create(reqDto);
        }
//        else if (req.getRequestURI().contains("search") && req.getMethod().equals("GET")) {
//            String userId = req.getParameter("userId");
//            response = namecardService.search(userId);
//        }
        if (response.getSuccess()) {
            return BaseResponse.success("통신 완료");
        } else {
            return null;
        }
    }
}
