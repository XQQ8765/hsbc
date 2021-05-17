package org.hsbc.ficc;

import java.util.Arrays;

public class PaymentUtil {
    public static Payment toPayment(String paymentStr) {
        if (paymentStr == null || paymentStr.trim().length() <= 1) {
            return null;
        }
        String[] strs = paymentStr.split(" ");
        if (strs.length != 2) {
            System.out.println("paymentStr: \'" + paymentStr +"\' is invalid.");
            return null;
        }
        String concurrencyStr = strs[0];
        if (concurrencyStr.length() != 3) {
            System.out.println("paymentStr: \'" + paymentStr +"\' concurrency is invalid.");
            return null;
        }
        boolean strAreUpperCase = concurrencyStr.chars().mapToObj(c->(char)c).allMatch(c -> Character.isUpperCase(c));
        if (!strAreUpperCase) {
            System.out.println("paymentStr: \'" + paymentStr +"\' concurrency is not upper case.");
            return null;
        }
        String amountStr = strs[1];
        Integer amount = 0;
        try {
            amount = Integer.parseInt(amountStr);
        } catch (Exception e) {
            System.out.println("paymentStr: \'" + paymentStr +"\' amount is not an integer.");
            return null;
        }
        Payment payment = new Payment(concurrencyStr, amount);
        return payment;
    }
}
