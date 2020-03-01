package com.genting.testbackend.service.impl;

import com.genting.testbackend.model.Currency;
import com.genting.testbackend.repository.CurrencyDAO;
import com.genting.testbackend.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {
    CurrencyDAO currencyDAO;

    @Autowired
    public CurrencyServiceImpl(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Override
    public List<Currency> getAllCny() throws Exception {
        List<Currency> list = currencyDAO.listAll();
        return list;
    }

    @Override
    public Currency getCnyByName(String cnyName) throws Exception {
        Currency cny = currencyDAO.getByName(cnyName);
        return cny;
    }

    @Override
    public double convertCny(String cnyName, String action, double amount) throws Exception {
        double result = currencyDAO.convertCurrency(cnyName, action, amount);
        return result;
    }
}
