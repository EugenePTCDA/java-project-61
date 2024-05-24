package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String START_PHRASE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        int roundCount = Engine.getRoundsCount();
        String[][] rounds = new String[roundCount][2];

        for (int i = 0; i < roundCount; i++) {
            int number = Engine.randomNumber(1, 1000);

            rounds[i][0] = Integer.toString(number);
            rounds[i][1] = checkEven(number) ? "yes" : "no";
        }

        Engine.runGame(START_PHRASE, rounds);
    }

    public static boolean checkEven(int number) {
        return number % 2 == 0;
    }
}
