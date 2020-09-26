import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in, "Windows-1252");

        System.out.print("Geben Sie die Primzahlen-Höchstgrenze ein: ");
        int upper = Integer.parseInt(s.nextLine());

        if (upper < 1) {
            System.out.println("Ungültige Eingabe");
            System.exit(0);
        }

        System.out.println("Wollen Sie\n\t(1) Alle Primzahlen bis " + upper + " anzeigen lassen oder\n\t(2) Für jede gerade natürliche Zahl n bis " + upper + " zwei Primzahlen anzeigen lassen, deren Summe n ist?");
        int mode = Integer.parseInt(s.nextLine());

        EratosthenesPrimeSieve sieve = new EratosthenesPrimeSieve(upper);

        switch (mode) {
            case 1:
                sieve.printPrimes();
                break;

            case 2:
                sieve.splitInSummands();
                break;

            default:
                System.out.println("Ungültige Eingabe");
                System.exit(0);
        }
    }
}
