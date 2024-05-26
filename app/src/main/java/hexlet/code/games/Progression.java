package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final String START_PHRASE = "What number is missing in the progression?";
    private static final int PROGRESSION_MIN_NUMBER = 1;
    private static final int PROGRESSION_MAX_NUMBER = 1000;
    private static final int ARRAY_LENGTH = 10;

    public static void play() {

        String[][] rounds = new String[Engine.ROUND_COUNT][2];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            int[] arrayNumbers = makeArray();
            String[] questionArray = questionArray(arrayNumbers);
            int replacedNumber = findReplacedNumber(arrayNumbers, questionArray);

            rounds[i][0] = Arrays.toString(questionArray).replace(",", "")
                                                         .replace("[", "")
                                                         .replace("]", "");
            rounds[i][1] = Integer.toString(replacedNumber);
        }

        Engine.runGame(START_PHRASE, rounds);
    }

    public static int[] makeArray() {
        int[] arrayNumbers = new int[ARRAY_LENGTH];
        int step = Engine.randomNumber(PROGRESSION_MIN_NUMBER, PROGRESSION_MAX_NUMBER);
        arrayNumbers[0] = Engine.randomNumber(0, PROGRESSION_MAX_NUMBER);
        for (int i = 1; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = arrayNumbers[i - 1] + step;
        }
        return arrayNumbers;
    }

    public static String[] questionArray(int[] array) {
        String[] arrayMod = new String[array.length];
        int randomIndex = Engine.randomNumber(0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            if (i == randomIndex) {
                arrayMod[i] = "..";
            } else {
                arrayMod[i] = Integer.toString(array[i]);
            }
        }
        return arrayMod;
    }

    public static int findReplacedNumber(int[] array, String[] modifiedArray) {
        for (int i = 0; i < array.length; i++) {
            if ("..".equals(modifiedArray[i])) {
                return array[i];
            }
        }
        return -1;
    }
}
