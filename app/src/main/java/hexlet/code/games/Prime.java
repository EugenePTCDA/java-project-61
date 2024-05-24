package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String START_PHRASE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int PRIME_MIN_NUMBER = 2;
    private static final int PRIME_MAX_NUMBER = 100;

    public static void play() {
        int roundCount = Engine.getRoundsCount();
        String[][] rounds = new String[roundCount][2];

        for (int i = 0; i < roundCount; i++) {
            int primeNumber = Engine.randomNumber(PRIME_MIN_NUMBER, PRIME_MAX_NUMBER);

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
