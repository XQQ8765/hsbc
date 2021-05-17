package org.hsbc.ficc;

public class AppMain {
    public static void main(String[] args) {
        PaymentBoard paymentBoard = new PaymentBoard();
        CommandInput commandInput = new CommandInput(paymentBoard);
        commandInput.getInput();
    }
}
