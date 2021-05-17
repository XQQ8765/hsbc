package org.hsbc.ficc;

import java.util.*;

public class PaymentBoard {
    private Map<String, Integer> currencyTotalMap;
    private Queue<Payment> newAddedPaymentsQueue;

    public PaymentBoard() {
        currencyTotalMap = new HashMap<>();
        newAddedPaymentsQueue = new LinkedList<>();
    }

    public synchronized void addPayment(Payment payment) {
        if (payment != null) {
            newAddedPaymentsQueue.add(payment);
            System.out.println("PaymentBoard: Add payment:" + payment);
        }
    }

    public synchronized Map<String, Integer> calculateTotalPayments() {
        //Calculate "currencyTotalMap"
        while (!newAddedPaymentsQueue.isEmpty()) {
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

        //Return an unmodified view for the map, so that the scheduled timer task can print the map.
        return Collections.unmodifiableMap(currencyTotalMap);
    }
}
