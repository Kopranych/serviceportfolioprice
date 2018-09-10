package com.kopranych.serviceportfolioprice.service.impl;

import com.kopranych.serviceportfolioprice.model.Stock;
import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.model.Stocks;
import com.kopranych.serviceportfolioprice.service.ServiceIextrading;
import com.kopranych.serviceportfolioprice.service.ServiceJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceIextradingImpl implements ServiceIextrading {
    @Autowired
    ServiceJson serviceJson;

    private static final String HOST = "https://api.iextrading.com/1.0/stock/";
    @Override
    public List<StockParametrs> getStockParametrs(Stocks stocks) {

        List<StockParametrs> stockParametrsList = new ArrayList<>();
        for (Stock stock :stocks.getStocks()) {
            String request = HOST + stock.getSymbol() + "/quote";
            HttpURLConnection connection = null;
            StringBuilder strBuilder = new StringBuilder();
            try {
                connection = (HttpURLConnection) new URL(request).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                    String tmp;
                    while ((tmp = reader.readLine()) != null) {
                        strBuilder.append(tmp);
                    }
                    stockParametrsList.add(serviceJson.jsonParseSingleStockParametrs(strBuilder.toString()));

                } else {
                    System.out.println("Response: " + connection.getResponseCode() + "stock symbol " + stock.getSymbol());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
        }
        return stockParametrsList;
    }
}
