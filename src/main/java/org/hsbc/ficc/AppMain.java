package org.hsbc.ficc;

import java.util.Timer;
import java.util.TimerTask;

public class AppMain {
    public static void main(String[] args) {
        PaymentBoard paymentBoard = new PaymentBoard();

        Timer timer = new Timer();
        TimerTask printTask = new PrintPaymentBoardTimerTask(paymentBoard);
        //Delay 1 min, and schedule for each 1 min.
        timer.schedule(printTask, 60 * 1000l, 60 * 1000l);

        CommandInput commandInput = new CommandInput(paymentBoard);
        commandInput.acceptInput();

        System.out.println("AppMain: Cancel the timer task.");
        timer.cancel();
        System.out.println("AppMain: The application is quit.");
    }
}
