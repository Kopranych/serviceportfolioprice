package com.kopranych.serviceportfolioprice.service;

import com.kopranych.serviceportfolioprice.model.StockParametrs;

import java.util.List;

public interface ServiceJson {
    List<StockParametrs> jsonParseStockParametrs(String json);
}
