package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String START_PHRASE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int PRIME_MIN_NUMBER = 2;
    private static final int PRIME_MAX_NUMBER = 100;

    public static void play() {

        String[][] rounds = new String[Engine.ROUND_COUNT][2];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            int primeNumber = Engine.createRandomNumber(PRIME_MIN_NUMBER, PRIME_MAX_NUMBER);

            rounds[i][0] = Integer.toString(primeNumber);
            rounds[i][1] = isPrime(primeNumber) ? "yes" : "no";
        }

        Engine.runGame(START_PHRASE, rounds);
    }


    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
