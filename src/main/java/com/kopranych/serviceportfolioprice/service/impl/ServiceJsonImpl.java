package com.kopranych.serviceportfolioprice.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.service.ServiceJson;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ServiceJsonImpl implements ServiceJson {
    public List<StockParametrs> jsonParseStockParametrs(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<List<StockParametrs>>(){}.getType();
        List<StockParametrs> result = gson.fromJson(json, type);
        return result;
    }
}
