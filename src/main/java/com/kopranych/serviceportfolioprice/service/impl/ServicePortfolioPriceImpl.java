package com.kopranych.serviceportfolioprice.service.impl;

import com.kopranych.serviceportfolioprice.model.AllocationSector;
import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.model.Stocks;
import com.kopranych.serviceportfolioprice.service.ServiceCalculation;
import com.kopranych.serviceportfolioprice.service.ServiceIextrading;
import com.kopranych.serviceportfolioprice.service.ServicePortfolioPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePortfolioPriceImpl implements ServicePortfolioPrice {
    @Autowired
    private ServiceIextrading serviceIextrading;
    @Autowired
    private ServiceCalculation serviceCalculation;

    @Override
    public AllocationSector getPortfolioPrice(Stocks stocks) {
        List<StockParametrs> stockParametrsList = serviceIextrading.getStockParametrs();
        return serviceCalculation.calculationPortfolioSumPrice(stocks, stockParametrsList);
    }
}
