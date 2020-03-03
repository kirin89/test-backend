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
}