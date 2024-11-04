package org.example.domain;


public class Money {
    private double amount;
    private CurrencyType currency;

    public Money(double amount, CurrencyType currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
    public void setAmount(double amount) {
        this.amount =  amount;
    }

    public CurrencyType getCurrency() {
        return currency;
    }


    public Money add(Money other) {
        if (this.currency != other.currency) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.amount + other.amount, this.currency);
    }

    public Money subtract(Money other) {
        if (this.currency != other.currency) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.amount - other.amount, this.currency);
    }
    public void reduceAmount(int reduction){
        this.amount -= reduction;
    }
    public void increaseAmount(int increase){
        this.amount += increase;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency);
    }
}
