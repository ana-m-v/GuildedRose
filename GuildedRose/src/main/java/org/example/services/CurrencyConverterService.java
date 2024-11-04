package org.example.services;

import org.example.domain.CurrencyType;
import org.example.domain.Money;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterService {
    private static final Map<CurrencyType, Double> conversionRates = new HashMap<>();

    static {
        conversionRates.put(CurrencyType.EUR, 1.0); // Base currency (EUR)
        conversionRates.put(CurrencyType.USD, 1.1); // 1 EUR = 1.1 USD
        conversionRates.put(CurrencyType.GBP, 0.85); // 1 EUR = 0.85 GBP
    }

    public static Money convert(Money money, CurrencyType targetCurrency) {
        if (money.getCurrency() == targetCurrency) return money;

        double rate = conversionRates.get(targetCurrency) / conversionRates.get(money.getCurrency());
        double convertedAmount = money.getAmount() * rate;

        return new Money(convertedAmount, targetCurrency);
    }
}
