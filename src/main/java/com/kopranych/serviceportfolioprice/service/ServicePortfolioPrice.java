package com.kopranych.serviceportfolioprice.service;


import com.kopranych.serviceportfolioprice.model.AllocationSector;
import com.kopranych.serviceportfolioprice.model.Stocks;
import org.springframework.stereotype.Service;

@Service
public interface ServicePortfolioPrice {
    AllocationSector getPortfolioPrice(Stocks stocks);
}
