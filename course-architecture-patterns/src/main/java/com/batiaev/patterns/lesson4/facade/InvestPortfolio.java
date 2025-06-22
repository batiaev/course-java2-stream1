package com.batiaev.patterns.lesson4.facade;

import com.batiaev.patterns.lesson4.composite.FinancialInstrument;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class InvestPortfolio implements Portfolio {
    private Map<FinancialInstrument, Long> instruments = new HashMap<>();

    @Override
    public double getEvaluation() {
        double result = 0;
        for (FinancialInstrument finInstrument : instruments.keySet()) {
            result += finInstrument.getQuote() * instruments.get(finInstrument);
        }
        return result;
    }
}
