package com.genting.testbackend.controllers;

import com.genting.testbackend.service.CurrencyService;
import com.genting.testbackend.service.impl.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/currency")
@CrossOrigin
public class TestController {
    private CurrencyService currencyService;

    @Autowired
    public TestController(CurrencyServiceImpl currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public ResponseEntity getAllCurrencies(){
        try{
            return new ResponseEntity(currencyService.getAllCny(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(Collections.singletonMap("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{currencyName}/{action}/{amount}")
    public ResponseEntity convertCurrency(@PathVariable String currencyName, @PathVariable String action, @PathVariable double amount){
        try{
            return new ResponseEntity(currencyService.convertCny(currencyName, action, amount), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(Collections.singletonMap("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
