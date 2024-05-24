package hexlet.code;

import hexlet.code.games.Greet;

import java.util.Scanner;

public class Engine {

    private static final int ROUND_COUNT = 3;

    public static int getRoundsCount() {
        return ROUND_COUNT;
    }

    public static int randomNumber(int min, int max) {
        min = min;
        max = max;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void runGame(String gameDiscription, String[][] gameBody) {
        Scanner scanner = new Scanner(System.in);
        String name = Greet.sayHello();
        String startGamePhrase = gameDiscription;
        System.out.println(startGamePhrase);
        String[][] rounds = gameBody;
        for (int i = 0; i < ROUND_COUNT; i++) {
            String question = rounds[i][0];
            String correctAnswer = rounds[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (!userAnswer.equals(correctAnswer)) {
                System.out.print("'" + userAnswer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }

            System.out.println("Correct!");
        }
    }
}
