package com.batiaev.gb223.lesson5;

import java.util.Currency;
import java.util.List;

/**
 * BrokerageAccount
 *
 * @author anton
 * @since 30/07/19
 */
public class BrokerageAccount {
    private List<Asset> assets;
    double getAmount(Currency ccy) {
        double result = 0;
        for (Asset asset : assets) {
            result += asset.getValue();
        }
        return result;
    }
}
