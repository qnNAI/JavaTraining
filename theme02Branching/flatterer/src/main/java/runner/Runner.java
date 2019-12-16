package runner;

import flutterer.Flatterer;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flatterer flatterer = new Flatterer();
        String str = "";

        System.out.println("Введите букву");
        str = scanner.nextLine();
        flatterer.printMessage(str);
    }
}
