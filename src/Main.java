public class Main {
    public static void main(String[] args) throws Exception {
        int number = 4125;

        System.out.printf("Prime factors of %d: %s\n", number, Prime.factorsOf(number));
        System.out.printf("Prime factors of %d: %s\n", number, Prime.factorMultiplicitiesOf(number));
    }
}