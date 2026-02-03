package com.poticard.api.portfolio;

import com.poticard.api.portfolio.model.PortfolioDto;

public interface PortfolioRepository {
    Integer create(PortfolioDto.CreateRequest dto);
}