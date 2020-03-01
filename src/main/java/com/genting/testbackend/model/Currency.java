package com.genting.testbackend.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Currency {
    private String name;
    private double buyRate;
    private double sellRate;
    private Timestamp time;
}
