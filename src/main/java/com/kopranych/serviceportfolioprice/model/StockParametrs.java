package com.kopranych.serviceportfolioprice.model;

import lombok.Data;

@Data
public class StockParametrs {
    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String sector;
    private String calculationPrice;
    private double open;
    private long openTime;
    private double close;
    private long closeTime;
    private float high;
    private double low;
    private double latestPrice;
    private String latestSource;
    private String latestTime;
    private long latestUpdate;
    private long latestVolume;
    private String iexRealtimePrice;
    private String iexRealtimeSize;
    private String iexLastUpdated;
    private double delayedPrice;
    private long delayedPriceTime;
    private double extendedPrice;
    private double extendedChange;
    private double extendedChangePercent;
    private long extendedPriceTime;
    private double previousClose;
    private double change;
    private double changePercent;
    private String iexMarketPercent;
    private String iexVolume;
    private long avgTotalVolume;
    private String iexBidPrice;
    private String iexBidSize;
    private String iexAskPrice;
    private String iexAskSize;
    private long marketCap;
    private double peRatio;
    private double week52High;
    private double week52Low;
    private double ytdChange;
}
