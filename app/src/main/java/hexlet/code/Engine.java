package hexlet.code;

import hexlet.code.games.Greet;

import java.util.Scanner;

public class Engine {

    public static final int ROUND_COUNT = 3;

    public static int createRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void runGame(String gameDiscription, String[][] gameBody) {
        Scanner scanner = new Scanner(System.in);
        String name = Greet.sayHello(scanner);

        System.out.println(gameDiscription);

        for (int i = 0; i < ROUND_COUNT; i++) {
            String question = gameBody[i][0];
            String correctAnswer = gameBody[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (!userAnswer.equals(correctAnswer)) {
                System.out.print("'" + userAnswer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }

            if (i == ROUND_COUNT - 1) {
                System.out.println("Congratulations, " + name + "!");
            }

            System.out.println("Correct!");
        }
        scanner.close();
    }
}
