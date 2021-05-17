package org.hsbc.ficc;

import java.util.Timer;
import java.util.TimerTask;

public class AppMain {
    public static void main(String[] args) {
        PaymentBoard paymentBoard = new PaymentBoard();

        Timer timer = new Timer();
        TimerTask printTask = new PrintPaymentBoardTimerTask(paymentBoard);
        timer.schedule(printTask, 1000l, 60 * 1000l);

        CommandInput commandInput = new CommandInput(paymentBoard);
        commandInput.acceptInput();
    }
}
