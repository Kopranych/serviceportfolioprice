package com.kopranych.serviceportfolioprice.service.impl;

import com.kopranych.serviceportfolioprice.model.AllocationSector;
import com.kopranych.serviceportfolioprice.model.Stocks;
import com.kopranych.serviceportfolioprice.service.ServicePortfolioPrice;
import org.springframework.stereotype.Service;

@Service
public class ServicePortfolioPriceImpl implements ServicePortfolioPrice {
    @Override
    public AllocationSector getPortfolioPrice(Stocks stocks) {
        AllocationSector allocationSector = new AllocationSector();
        allocationSector.setValue(stocks.getStocks().get(0).getVolume());
        return allocationSector;
    }
}
