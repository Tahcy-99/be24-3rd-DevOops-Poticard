package com.poticard.api.portfolio;

import com.poticard.api.portfolio.model.PortfolioDto;

public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Integer register(PortfolioDto.CreateRequest dto) {
        return portfolioRepository.create(dto);
    }
}