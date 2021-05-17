package org.hsbc.ficc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentUtilTest {
    @Test
    public void testToPayment() {
        assertNull(PaymentUtil.toPayment(null));
        assertNull(PaymentUtil.toPayment("usd"));
        assertNull(PaymentUtil.toPayment("usd123"));
        assertNull(PaymentUtil.toPayment("Usd 123"));
        assertNull(PaymentUtil.toPayment("USD 123a"));
        Payment payment = PaymentUtil.toPayment("USD 123");
        assertEquals("USD", payment.getCurrency());
        assertEquals(123, payment.getAmount());
    }
}
