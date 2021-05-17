package org.hsbc.ficc;

import org.junit.Test;

public class PaymentBoardTest {

    @Test
    public void testCalculateTotalPayments() {
        /**
         * USD 1000
         * HKD 100
         * USD -100
         * CNY 2000
         * HKD 200
         */
        PaymentBoard paymentBoard = new PaymentBoard();
        paymentBoard.addPayment(new Payment("USD", 1000));
        paymentBoard.addPayment(new Payment("HKD", 100));
        paymentBoard.addPayment(new Payment("USD", -100));
        paymentBoard.addPayment(new Payment("CNY", 2000));
        paymentBoard.addPayment(new Payment("HKD", 200));

        paymentBoard.calculateTotalPayments();
    }
}
