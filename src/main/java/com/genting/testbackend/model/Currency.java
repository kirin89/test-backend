package com.genting.testbackend.model;

import lombok.Data;

@Data
public class Currency {
    private String name;
    private double buyRate;
    private double sellRate;

    public Currency() {
    }

    public Currency(String name, double buyRate, double sellRate) {
        this.name = name;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }
}
