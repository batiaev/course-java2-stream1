package com.batiaev.patterns.lesson4;

import com.batiaev.patterns.lesson4.adapter.Currency;
import com.batiaev.patterns.lesson4.adapter.MoexCurrency;
import com.batiaev.patterns.lesson4.adapter.MoexCurrencyAdapter;
import com.batiaev.patterns.lesson4.bridge.NyseAssets;
import com.batiaev.patterns.lesson4.composite.FinancialInstrument;
import com.batiaev.patterns.lesson4.composite.Futures;
import com.batiaev.patterns.lesson4.composite.Option;
import com.batiaev.patterns.lesson4.composite.StockAsset;
import com.batiaev.patterns.lesson4.decorator.TaxManager;
import com.batiaev.patterns.lesson4.facade.InvestPortfolio;
import com.batiaev.patterns.lesson4.facade.Portfolio;
import com.batiaev.patterns.lesson4.proxy.CachedQuotationManager;
import com.batiaev.patterns.lesson4.proxy.CentalBankQuotationManager;
import com.batiaev.patterns.lesson4.proxy.QuotationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson4 {
    public static void main(String[] args) {
        adapter();
        bridge();
        composite();
        decorator();
        facade();
        proxy();
    }

    private static void proxy() {
        QuotationManager quotationManager = getCentralBankQuotationManager();
        quotationManager.getQuote();
    }

    private static QuotationManager getCentralBankQuotationManager() {
        CachedQuotationManager cachedQuotationManager = new CachedQuotationManager(new CentalBankQuotationManager());
        cachedQuotationManager.fetchData();
        return cachedQuotationManager;
    }

    private static void facade() {
        Portfolio portfolio = new InvestPortfolio();
        double evaluation = portfolio.getEvaluation();
        System.out.println(evaluation);
    }

    private static void decorator() {
        TaxManager taxManager = new TaxManager();
        NonTradeManager nontradeManager = new NonTradeManager(taxManager);
        nontradeManager.transfer("12345");
    }

    private static void composite() {
        StockAsset apple = new StockAsset();
        Futures appleFutures = new Futures(apple);
        Option appleOption = new Option(appleFutures);

        List<FinancialInstrument> financialInstruments =
                Arrays.asList(apple, appleFutures, appleOption);

        for (FinancialInstrument financialInstrument : financialInstruments) {
            System.out.println(financialInstrument.getQuote());
        }
    }

    private static void bridge() {
        List<NyseAssets> nyseAssetsList = new ArrayList<NyseAssets>();
        List<Currency> currencies = new ArrayList<Currency>();
    }

    private static void adapter() {
        //FIXME
        MoexCurrency currency = new MoexCurrency();
        processCurrency(new MoexCurrencyAdapter(currency));
    }

    private static void processCurrency(Currency currency) {
        //FIXME
    }
}
