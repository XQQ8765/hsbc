package org.hsbc.ficc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class CommandInput {
    private PaymentBoard paymentBoard;

    public CommandInput(PaymentBoard paymentBoard) {
        this.paymentBoard = paymentBoard;
    }

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:1-> Input a payment manually(By default);  2-> Load from a file.");

        String line = scanner.nextLine().trim();
        if ("2".equals(line)) {
            System.out.println("Input the file path that keeps a record of payments.(Like: D:\\tmp\\test.txt)");
            String filepath = scanner.nextLine().trim();
            try {
                Stream<String> stream = Files.lines(Paths.get(filepath));
                stream.forEach(System.out::println);

            } catch (IOException e) {
                System.err.println("Exception for open filepath:" + filepath + ", e:" + e);
            }
        } else {
            System.out.println("Input the payment(Like: USD 1000).");
            line = scanner.nextLine().trim();
        }
    }
}
