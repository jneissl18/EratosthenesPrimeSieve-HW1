import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in, "Windows-1252");

        System.out.print("Geben Sie die Primzahlen-Höchstgrenze ein: ");
        int upper = Integer.parseInt(s.nextLine());

        new EratosthenesPrimeSieve(upper).printPrimes();
    }
}
