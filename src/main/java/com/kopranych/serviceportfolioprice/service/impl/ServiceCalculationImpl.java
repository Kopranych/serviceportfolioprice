package com.kopranych.serviceportfolioprice.service.impl;

import com.kopranych.serviceportfolioprice.model.*;
import com.kopranych.serviceportfolioprice.service.ServiceCalculation;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiceCalculationImpl implements ServiceCalculation {
    @Override
    public AllocationSector calculationPortfolioSumPrice(Stocks stocks, List<StockParametrs> stockParametrsList) {
        AllocationSector allocationSector = new AllocationSector();

        for (StockParametrs stockParametrs : stockParametrsList) {
            for (Stock stock : stocks.getStocks()) {
                if (stock.getSymbol().equals(stockParametrs.getSymbol())) {
                    stock.setAssetValue(calculAssetValue(stock, stockParametrs));
                    stock.setSector(stockParametrs.getSector());
                }
            }
        }

        Iterator<Stock> it = stocks.getStocks().iterator();
        while (it.hasNext()) {
            if (it.next().getSector() == null) {
                it.remove();
            }
        }

        Set<String> sectorNameSet = new LinkedHashSet<>();
        stocks.getStocks().forEach(stock -> sectorNameSet.add(stock.getSector()));
        double sumAssetValue = 0;
        for (String s : sectorNameSet) {
            for (Stock stock : stocks.getStocks()) {

                if (s.equals(stock.getSector())) {
                    sumAssetValue += stock.getAssetValue();
                }

            }
            Sector sector = new Sector();
            sector.setSector(s);
            sector.setAssetValue(sumAssetValue);
            allocationSector.getAllocations().add(sector);
            sumAssetValue = 0;
        }

        return calculPortfolioValueAndProportion(allocationSector);
    }


    private double calculAssetValue(Stock stock, StockParametrs stockParametrs) {
        return stock.getVolume() * stockParametrs.getLatestPrice();
    }

    private AllocationSector calculPortfolioValueAndProportion(AllocationSector allocationSector) {

        double value = 0;
        for (Sector sector : allocationSector.getAllocations()) {
            value += sector.getAssetValue();
        }
        allocationSector.setValue(value);

        for (Sector sector : allocationSector.getAllocations()) {
            sector.setProportion(sector.getAssetValue() / allocationSector.getValue());
        }

        return allocationSector;
    }

}
