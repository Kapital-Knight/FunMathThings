import java.util.ArrayList;

public class Prime {
    private static ArrayList<Integer> primes = new ArrayList<>();

    public static int getPrime (int index) throws Exception{
        if (primes.size() == 0) {
            primes.add(Integer.valueOf(2));
        }
        if (index < 0) {
            return -1;
        }
        if (index < primes.size()) {
            return primes.get(index);
        }
        while (index >= primes.size()) {
            generateNextPrime();
        }
        return primes.get(index);
    }

    public static ArrayList<Integer> factorsOf (int number) throws Exception {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 0; getPrime(i) <= number; i++) {
            Integer factorCandidate = getPrime(i);
            while (number % factorCandidate == 0) {
                number = number / factorCandidate;
                factors.add(factorCandidate);
            }
        }
        return (factors);
    }

    /***
     * @return List of the multiplicity of each prime factor of number.
     * Index n represents how many times number can be divided by the nth prime, aka getPrime(n).
     */
    public static ArrayList<Integer> factorMultiplicitiesOf(int number) throws Exception {
        ArrayList<Integer> factorMultiplicities = new ArrayList<>();
        for (int i = 0; getPrime(i) <= number; i++) {
            int factorCandidate = getPrime(i);
            Integer multiplicity = 0;
            while (number % factorCandidate == 0) {
                number = number / factorCandidate;
                multiplicity++;
            }
            factorMultiplicities.add(multiplicity);
        }
        return (factorMultiplicities);
    }

    private static void generateNextPrime() throws Exception {
        int candidate = primes.getLast() + 1;
        // prevent infinite loops from overflow
        if (candidate < 0) throw new Exception("Overflow error in generating a prime");
        boolean isPrime = false;
        while (!isPrime) {
            isPrime = true;
            for (Integer prime : primes) {
                if (candidate % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(Integer.valueOf(candidate));
            }
            candidate++;
        }
    }
}
