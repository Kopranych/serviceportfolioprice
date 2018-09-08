package com.kopranych.serviceportfolioprice.service.impl;

import com.kopranych.serviceportfolioprice.model.StockParametrs;
import com.kopranych.serviceportfolioprice.service.ServiceIextrading;
import com.kopranych.serviceportfolioprice.service.ServiceJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class ServiceIextradingImpl implements ServiceIextrading {
    @Autowired
    ServiceJson serviceJson;

    private static final String HOST = "https://api.iextrading.com/1.0/stock/market/list/gainers";
    @Override
    public List<StockParametrs> getStockParametrs() {
        String request = HOST;
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

            } else {
                System.out.println("Response: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return serviceJson.jsonParseStockParametrs(strBuilder.toString());
    }
}
