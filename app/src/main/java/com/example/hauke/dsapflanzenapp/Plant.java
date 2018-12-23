package com.example.hauke.dsapflanzenapp;

import java.util.List;

public class Plant {

    String name;
    List<String> regions;
    List<String> territories;
    List<String> months;

    Plant(String name, List<String> regions, List<String> territories, List<String> months) {
        this.name = name;
        this.regions = regions;
        this.territories = territories;
        this.months = months;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegions() {
        return regions;
    }

    public List<String> getTerritories() {
        return territories;
    }

    public List<String> getMonths() {
        return months;
    }
}
