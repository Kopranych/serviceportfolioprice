package com.kopranych.serviceportfolioprice.controller;

import com.kopranych.serviceportfolioprice.model.AllocationSector;
import com.kopranych.serviceportfolioprice.model.Stocks;
import com.kopranych.serviceportfolioprice.service.ServicePortfolioPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/portfolio")
public class Controller {

    @Autowired
    ServicePortfolioPrice servicePortfolioPrice;

    @RequestMapping(method = RequestMethod.POST, path = "/sum_price")
    public @ResponseBody
    AllocationSector getPortfolioPrice(@RequestBody Stocks stocks){
        return servicePortfolioPrice.getPortfolioPrice(stocks);
    }
}
