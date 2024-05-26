package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String START_PHRASE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int EVEN_MIN_NUMBER = 1;
    private static final int EVEN_MAX_NUMBER = 1000;

    public static void play() {

        String[][] rounds = new String[Engine.ROUND_COUNT][2];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            int number = Engine.createRandomNumber(EVEN_MIN_NUMBER, EVEN_MAX_NUMBER);

            rounds[i][0] = Integer.toString(number);
            rounds[i][1] = checkEven(number) ? "yes" : "no";
        }

        Engine.runGame(START_PHRASE, rounds);
    }

    private static boolean checkEven(int number) {
        return number % 2 == 0;
    }
}
