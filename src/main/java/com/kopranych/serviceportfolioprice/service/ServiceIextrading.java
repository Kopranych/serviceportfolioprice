package com.kopranych.serviceportfolioprice.service;

import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.model.Stocks;

import java.util.List;

public interface ServiceIextrading {
    List<StockParametrs> getStockParametrs(Stocks stocks);
}
