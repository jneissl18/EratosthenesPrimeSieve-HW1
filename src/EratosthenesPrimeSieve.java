import java.util.ArrayList;
import java.util.List;

public class EratosthenesPrimeSieve implements PrimeSieve {
    private final int upper;
    private final List<Integer> primzahlen;

    public EratosthenesPrimeSieve(int upper) {
        this.upper = upper;

        primzahlen = new ArrayList<>(upper);
        generatePrimes();
    }

    @Override
    public boolean isPrime(int n) {
        return primzahlen.contains(n);
    }

    @Override
    public void printPrimes() {
        System.out.println(primzahlen);
    }

    private void generatePrimes() {
        List<Integer> zahlen = new ArrayList<>(upper - 1);
        for (int i = 0; i < upper - 1; i++) {
            zahlen.add(i + 2);
        }
        int aktuell = 2;

        while (aktuell < Math.sqrt(upper)) {
            for (int i = aktuell; i <= upper; i += aktuell) {
                if (zahlen.contains(i))
                    zahlen.remove((Integer) i);
            }
            primzahlen.add(aktuell);
            aktuell = zahlen.get(0);
        }
        primzahlen.addAll(zahlen);
    }

    public void splitInSummands() {
        int first = -1, second = -1;

        for (int i = 4; i <= upper; i += 2) { //Loop through all even numbers <= upper
            for (int j = i - 2; j >= 2; j--) { //Find the biggest prime number in i so there is at least a little bit of variation in the summands and it's not just 3+(i-3)
                if (isPrime(j)) {
                    first = i - j;
                    second = j;

                    break;
                }
            }

            System.out.println("Prime summands for " + i + ": " + first + " + " + second + " = " + i);
        }
    }
}
