package com.genting.testbackend.model;

import lombok.Data;

@Data
public class ConvertedCurrency {
    private String action;
    private String baseCurrency;
    private String convertedCurrency;
    private double baseAmount;
    private double convertedAmount;
    private double suggestedBaseAmount;
    private int suggestedConvertedAmount;

    public ConvertedCurrency(String action, String baseCurrency, String convertedCurrency, double baseAmount,
                             double convertedAmount, double suggestedBaseAmount, int suggestedConvertedAmount) {
        this.action = action;
        this.baseCurrency = baseCurrency;
        this.convertedCurrency = convertedCurrency;
        this.baseAmount = baseAmount;
        this.convertedAmount = convertedAmount;
        this.suggestedBaseAmount = suggestedBaseAmount;
        this.suggestedConvertedAmount = suggestedConvertedAmount;
    }
}
