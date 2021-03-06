package org.hsbc.ficc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class accept user input for adding "Payment" into "PaymentBoard" class.
 * If a wrong format "Payment" is input, it will display the error message and will be skipped.
 */
public class CommandInput {
    private PaymentBoard paymentBoard;
    private Scanner scanner;

    public CommandInput(PaymentBoard paymentBoard) {
        this.paymentBoard = paymentBoard;
        scanner = new Scanner(System.in);
    }

    public void acceptInput() {
        System.out.println("Type '1' or '2' to choose the way for input:");
        System.out.println("  Type '1' -> Input a payment manually(By default).");
        System.out.println("  Type '2' -> Load from a file.");
        System.out.println("  Type 'quit' -> To exit the application.");

        String line = scanner.nextLine().trim();
        if ("quit".equals(line)) {
            System.out.println("CommandInput: quit.");
            return;//Exit the app
        }
        if ("2".equals(line)) {
            acceptInputFromFile();
        }

        while(true) {
            System.out.println("Input the payment(Like: USD 1000). Type \"quit\" to exit the application.   >");
            line = scanner.nextLine().trim();
            if ("quit".equals(line)) {
                System.out.println("CommandInput: quit.");
                return;//Exit the app
            }
            Payment payment = PaymentUtil.toPayment(line);
            if (payment != null) {
                paymentBoard.addPayment(payment);
            }
        }
    }

    private void acceptInputFromFile() {
        System.out.println("Input the file path that keeps a record of payments.(Like: D:\\tmp\\test.txt)   >");
        String filepath = scanner.nextLine().trim();
        if ("quit".equals(filepath)) {
            return;//Exit the app
        }

        try {
            Files.lines(Paths.get(filepath)).map(PaymentUtil::toPayment).filter(payment -> payment != null)
                    .forEach(payment -> paymentBoard.addPayment(payment));
        } catch (IOException e) {
            System.err.println("Exception for open filepath:" + filepath + ", e:" + e);
        }
    }
}
