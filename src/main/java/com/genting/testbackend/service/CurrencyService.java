package com.genting.testbackend.service;

import com.genting.testbackend.model.Currency;

import java.util.List;

public interface CurrencyService {
    public List<Currency> getAllCny() throws Exception;
    public Currency getCnyByName(String cnyName) throws Exception;
    public double convertCny(String cnyName, String action, double amount) throws Exception;
}
