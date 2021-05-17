package org.hsbc.ficc;

public class Payment {
    private String currency;
    private int amount;

    public Payment(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return new StringBuilder(currency).append(' ').append(amount).toString();
    }
}
