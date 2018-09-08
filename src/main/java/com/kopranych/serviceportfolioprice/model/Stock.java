package com.kopranych.serviceportfolioprice.model;

import lombok.Data;

@Data
public class Stock {
    private String symbol;
    private int volume;
    transient double assetValue;
    transient String sector;
}
