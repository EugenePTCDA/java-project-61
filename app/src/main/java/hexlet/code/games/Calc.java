package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String START_PHRASE = "What is the result of the expression?";

    public static void play() {
        int roundCount = Engine.getRoundsCount();
        String[][] rounds = new String[roundCount][2];

        for (int i = 0; i < roundCount; i++) {
            int num1 = Engine.randomNumber(1, 100);
            int num2 = Engine.randomNumber(1, 100);
            char sign = mathAction();

            rounds[i][0] = num1 + " " + sign + " " + num2;
            rounds[i][1] = Integer.toString(calcResult(num1, num2, sign));
        }

        Engine.runGame(START_PHRASE, rounds);
    }

    public static char mathAction() {
        char[] actions = {'+', '-', '*'};
        int chooseAction = Engine.randomNumber(0, 2);
        return actions[chooseAction];
    }

    public static int calcResult(int num1, int num2, char sign) {
        int result = switch (sign) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> 0;
        };
        return result;
    }
}
