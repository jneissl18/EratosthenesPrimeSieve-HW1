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
}
