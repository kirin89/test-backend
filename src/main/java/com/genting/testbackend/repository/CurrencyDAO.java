package com.genting.testbackend.repository;

import com.genting.testbackend.model.Currency;
import com.genting.testbackend.model.mapper.CurrencyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CurrencyDAO {
    private JdbcTemplate db;

    @Autowired
    public CurrencyDAO(JdbcTemplate db){
        this.db = db;
    }

    public List<Currency> listAll(){
        return db.query("SELECT * FROM Currency", new CurrencyMapper());
    }

    public Currency getByName(String name) throws Exception {
        try {
            return db.queryForObject("SELECT * FROM Currency WHERE name = ?", new Object[]{name}, new CurrencyMapper());
        } catch (Exception e){
            throw new Exception("Currency " + name + " is not found");
        }
    }

    public double convertCurrency(String cnyName, String action, double amount) throws Exception {
        Currency cny = getByName(cnyName);
        double result;

        if(amount < 0){
            throw new Exception("Amount is invalid");
        }
        if(action.equalsIgnoreCase("buy")){
            result = amount * cny.getBuyRate();
        } else if(action.equalsIgnoreCase("sell")){
            result = amount * cny.getSellRate();
        } else {
            throw new Exception("Action is invalid");
        }

        // round to 2 digits
        return (double) Math.round(result * 1000) / 1000;
    }
}