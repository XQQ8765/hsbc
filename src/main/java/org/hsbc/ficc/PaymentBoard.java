package org.hsbc.ficc;

import java.util.*;

public class PaymentBoard {
    private Map<String, Integer> currencyTotalMap;
    private Queue<Payment> newAddedPaymentsQueue;
    private Object displayObjectLock;

    public PaymentBoard() {
        currencyTotalMap = new HashMap<>();
        newAddedPaymentsQueue = new LinkedList<>();
        displayObjectLock = new Object();
    }

    public void addPayment(Payment payment) {
        synchronized (displayObjectLock) {
            newAddedPaymentsQueue.add(payment);
        }
    }

    public void calculateTotalPayments() {
        synchronized (displayObjectLock) {
            //Calculate "currencyTotalMap"
            while(!newAddedPaymentsQueue.isEmpty()) {
                Payment payment = newAddedPaymentsQueue.poll();
                if (payment == null) {
                    continue;
                }
                Integer totalValue = currencyTotalMap.get(payment.getCurrency());
                if (totalValue == null) {
                    currencyTotalMap.put(payment.getCurrency(), payment.getAmount());
                } else {
                    totalValue = totalValue + payment.getAmount();
                    currencyTotalMap.put(payment.getCurrency(), totalValue);
                }
            }

            //Print "currencyTotalMap"
            currencyTotalMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " +entry.getValue()));
        }
    }
}
