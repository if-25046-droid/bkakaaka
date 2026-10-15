package view;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}
