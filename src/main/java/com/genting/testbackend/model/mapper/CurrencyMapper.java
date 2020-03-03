package com.genting.testbackend.model.mapper;

import com.genting.testbackend.model.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyMapper implements RowMapper<Currency> {

    @Override
    public Currency mapRow(ResultSet rs, int i) throws SQLException {
        Currency cny = new Currency();
        cny.setName(rs.getString("NAME"));
        cny.setBuyRate(rs.getDouble("BUY_RATE"));
        cny.setSellRate(rs.getDouble("SELL_RATE"));

        return cny;
    }
}
