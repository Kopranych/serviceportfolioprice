package com.kopranych.serviceportfolioprice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllocationSector {
    private float value;
    private List<Sector> allocations = new ArrayList<>();

}
