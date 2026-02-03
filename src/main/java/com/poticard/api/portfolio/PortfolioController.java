package com.poticard.api.portfolio;

import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.portfolio.model.PortfolioDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PortfolioController implements Controller {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        // 프로젝트 작성 요청 처리: POST /portfolio/create
        if (req.getRequestURI().contains("create") && req.getMethod().equals("POST")) {
            // JSON 데이터를 CreateRequest 객체로 변환
            PortfolioDto.CreateRequest dto = JsonParser.from(req, PortfolioDto.CreateRequest.class);

            Integer portfolioIdx = portfolioService.register(dto);

            return BaseResponse.success(portfolioIdx);
        }

        return BaseResponse.fail(null);
    }
}