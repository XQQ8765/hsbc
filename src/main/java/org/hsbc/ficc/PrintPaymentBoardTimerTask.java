package org.hsbc.ficc;

import java.time.Instant;
import java.util.Map;
import java.util.TimerTask;

public class PrintPaymentBoardTimerTask extends TimerTask {
    private PaymentBoard paymentBoard;

    public PrintPaymentBoardTimerTask(PaymentBoard paymentBoard) {
        this.paymentBoard = paymentBoard;
    }

    @Override
    public void run() {
        System.out.println("Current time is:" + Instant.now());
        Map<String, Integer> currencyTotalMap = paymentBoard.calculateTotalPayments();
        currencyTotalMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
