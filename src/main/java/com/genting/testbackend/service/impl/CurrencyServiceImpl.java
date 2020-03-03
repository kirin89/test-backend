package com.genting.testbackend.service.impl;

import com.genting.testbackend.model.ConvertedCurrency;
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
    public List<Currency> getAllCny() {
        List<Currency> list = currencyDAO.listAll();
        return list;
    }

    @Override
    public ConvertedCurrency convertCny(String currencyName, String action, double amount) throws Exception {
        Currency base = currencyDAO.getByName(currencyName);
        if(amount < 0){
            throw new Exception("Amount should be positive");
        }
        if(action.equalsIgnoreCase("buy")){
            double result = amount * base.getBuyRate();
            double rounded = (double) Math.round(result * 100) / 100;
            return new ConvertedCurrency("buy", base.getName(), "SGD", amount, rounded, 0, 0);
        } else if(action.equalsIgnoreCase("sell")){
            double result =  amount / base.getSellRate();
            double rounded = (double) Math.round(result * 100) / 100;
            int suggestedAmount = (int)Math.round(result / 100) * 100;
            double suggestedBase = (double) Math.round(suggestedAmount * base.getSellRate() * 100) / 100;
            return new ConvertedCurrency("sell", "SGD", base.getName(), amount, rounded, suggestedBase, suggestedAmount);
        } else {
            throw new Exception("Action should be either buy or sell");
        }
    }
}
