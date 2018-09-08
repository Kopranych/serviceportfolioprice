package com.kopranych.serviceportfolioprice.service;

import com.kopranych.serviceportfolioprice.model.AllocationSector;
import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.model.Stocks;

import java.util.List;

public interface ServiceCalculation {
    AllocationSector calculationPortfolioSumPrice(Stocks stocks, List<StockParametrs> stockParametrsList);
}
