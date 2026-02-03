package com.poticard.api.namecard.controller;


import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.namecard.NamecardService;
import com.poticard.api.namecard.model.NamecardDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 라우팅 처리를 AppConfig에서 전부 처리하기 위해서 주석처리
public class NamecardSearchController implements Controller {
    private final NamecardService namecardService;

    public NamecardSearchController(NamecardService namecardService) {
        this.namecardService = namecardService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        NamecardDto.SearchRes responseDto = null;

        if (req.getRequestURI().contains("search") && req.getMethod().equals("POST")) {
            NamecardDto.SearchReq dto = JsonParser.from(req, NamecardDto.SearchReq.class);
            responseDto = namecardService.search(dto.getUserId());
        }
        else if (req.getRequestURI().contains("search") && req.getMethod().equals("GET")) {
            String userId = req.getParameter("userId");
            responseDto = namecardService.search(userId);
        }

        return BaseResponse.success(responseDto);
    }
}
