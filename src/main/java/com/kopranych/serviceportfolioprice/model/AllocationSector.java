package com.kopranych.serviceportfolioprice.model;

import lombok.Data;

import java.util.List;

@Data
public class AllocationSector {
    private int value;
    private List<Sector> allocatrions;
}
