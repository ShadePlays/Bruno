import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteEntrada {

    public static int nextInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido:");
                scanner.next();
            }
        }
    }

    public static double nextDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido:");
                scanner.next();
            }
        }
    }
}
