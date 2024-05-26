package hexlet.code.games;

import java.util.Scanner;

public class Greet {
    public static String sayHello() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");

        scanner.close();

        return name;
    }
}
