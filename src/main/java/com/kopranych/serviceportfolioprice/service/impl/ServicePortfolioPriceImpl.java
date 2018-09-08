package com.kopranych.serviceportfolioprice.service.impl;

import com.kopranych.serviceportfolioprice.model.AllocationSector;
import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.model.Stocks;
import com.kopranych.serviceportfolioprice.service.ServiceIextrading;
import com.kopranych.serviceportfolioprice.service.ServicePortfolioPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePortfolioPriceImpl implements ServicePortfolioPrice {
    @Autowired
    private ServiceIextrading serviceIextrading;
    @Override
    public AllocationSector getPortfolioPrice(Stocks stocks) {
        AllocationSector allocationSector = new AllocationSector();
        allocationSector.setValue(stocks.getStocks().get(0).getVolume());
        List<StockParametrs> stockParametrsList = serviceIextrading.getStockParametrs();
        stockParametrsList.forEach(stockParametrs -> System.out.println(stockParametrs.getSymbol()));
        return allocationSector;
    }
}
