public class Main {

    public static Prime prime = new Prime();

    public static void main(String[] args) throws Exception {
        int number = 159;

        System.out.printf("Number %d is prime: %s\n", number, prime.isPrime(number));
        System.out.printf("Last prime before %d: %s\n", number, prime.lastPrimeBefore(number));
        System.out.printf("First prime after %d: %s\n", number, prime.firstPrimeAfter(number));
        System.out.printf("Prime factors of %d: %s\n", number, prime.factorsOf(number));
        System.out.printf("Multiplicities of prime factors of %d: %s\n", number, prime.factorMultiplicitiesOf(number));
    }
}