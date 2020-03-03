package com.genting.testbackend.service;


import com.genting.testbackend.model.ConvertedCurrency;
import com.genting.testbackend.model.Currency;
import com.genting.testbackend.repository.CurrencyDAO;
import com.genting.testbackend.service.impl.CurrencyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CurrencyServiceJUnit {
    @Test
    public void convertCnyTest() throws Exception {
        CurrencyDAO dao = Mockito.mock(CurrencyDAO.class);
        CurrencyService service = new CurrencyServiceImpl(dao);
        Currency cuy = new Currency("HKD", 0.1738, 0.1698);
        Mockito.doReturn(cuy).when(dao).getByName("HKD");

        ConvertedCurrency converted = service.convertCny("HKD", "sell", 200);
        Assertions.assertEquals("SGD", converted.getBaseCurrency());
        Assertions.assertEquals("HKD", converted.getConvertedCurrency());
        Assertions.assertEquals(200.0, converted.getBaseAmount());
        Assertions.assertEquals(1177.86, converted.getConvertedAmount());
        Assertions.assertEquals(203.76, converted.getSuggestedBaseAmount());
        Assertions.assertEquals(1200, converted.getSuggestedConvertedAmount());

        converted = service.convertCny("HKD", "buy", 1);
        Assertions.assertEquals("HKD", converted.getBaseCurrency());
        Assertions.assertEquals("SGD", converted.getConvertedCurrency());
        Assertions.assertEquals(1, converted.getBaseAmount());
        Assertions.assertEquals(0.17, converted.getConvertedAmount());
    }
}
