package com.genting.testbackend.controllers;

import com.genting.testbackend.model.Currency;
import com.genting.testbackend.service.CurrencyService;
import com.genting.testbackend.service.impl.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
public class TestController {
    private CurrencyService currencyService;

    @Autowired
    public TestController(DataSource dataSource, JdbcTemplate jdbcTemplate, CurrencyServiceImpl currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public ResponseEntity getAllCurrencies(){
        try{
            return new ResponseEntity(currencyService.getAllCny(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{currencyName}")
    public ResponseEntity getCurrencyByName(@PathVariable String currencyName){
        try{
            return new ResponseEntity(currencyService.getCnyByName(currencyName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{currencyName}/{action}/{amount}")
    public ResponseEntity convertCurrency(@PathVariable String currencyName, @PathVariable String action, @PathVariable double amount){
        try{
            return new ResponseEntity(Collections.singletonMap("result", currencyService.convertCny(currencyName, action, amount)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
