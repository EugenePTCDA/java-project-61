package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the game number and press Enter.");

            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "0" -> System.out.println("Goodbye!");
                case "1" -> Greet.sayHello(scanner);
                case "2" -> Even.play();
                case "3" -> Calc.play();
                case "4" -> GCD.play();
                case "5" -> Progression.play();
                case "6" -> Prime.play();
                default -> System.out.println("No such game");
            }
        }
    }
}
