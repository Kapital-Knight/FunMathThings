import java.util.ArrayList;
public class PrimeNumbers {
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
