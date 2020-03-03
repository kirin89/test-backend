package com.genting.testbackend.service;

import com.genting.testbackend.model.ConvertedCurrency;
import com.genting.testbackend.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAllCny() throws Exception;
    ConvertedCurrency convertCny(String currencyName, String action, double amount) throws Exception;
}
