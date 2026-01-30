package com.poticard.api.namecard.controller;


import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.namecard.NamecardService;
import com.poticard.api.namecard.model.NamecardCreateDto;
import com.poticard.api.namecard.model.NamecardUpdateDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 라우팅 처리를 AppConfig에서 전부 처리하기 위해서 주석처리
public class NamecardUpdateController implements Controller {
    private final NamecardService namecardService;

    public NamecardUpdateController(NamecardService namecardService) {
        this.namecardService = namecardService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        NamecardUpdateDto.Response response = null;

        if (req.getRequestURI().contains("update") && req.getMethod().equals("POST")) {
            NamecardUpdateDto.Update reqDto = JsonParser.from(req, NamecardUpdateDto.UPdate.class);
            response = namecardService.update(reqDto);
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
