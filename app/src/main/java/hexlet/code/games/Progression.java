package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final String START_PHRASE = "What number is missing in the progression?";

    public static void play() {
        int roundCount = Engine.getRoundsCount();
        String[][] rounds = new String[roundCount][2];

        for (int i = 0; i < roundCount; i++) {
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
        int[] arrayNumbers = new int[10];
        int step = Engine.randomNumber(1, 100);
        arrayNumbers[0] = Engine.randomNumber(0, 100);
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