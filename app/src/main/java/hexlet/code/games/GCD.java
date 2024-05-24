package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String START_PHRASE = "Find the greatest common divisor of given numbers.";
    private static final int GCD_MIN_NUMBER = 10;
    private static final int GCD_MAX_NUMBER = 100;

    public static void play() {
        int roundCount = Engine.getRoundsCount();
        String[][] rounds = new String[roundCount][2];

        for (int i = 0; i < roundCount; i++) {
            int num1 = Engine.randomNumber(GCD_MIN_NUMBER, GCD_MAX_NUMBER);
            int num2 = Engine.randomNumber(GCD_MIN_NUMBER, GCD_MAX_NUMBER);

            rounds[i][0] = num1 + " " + num2;
            rounds[i][1] = Integer.toString(findGCD(num1, num2));
        }

        Engine.runGame(START_PHRASE, rounds);
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
