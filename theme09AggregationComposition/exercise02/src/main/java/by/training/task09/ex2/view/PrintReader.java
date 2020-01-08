package by.training.task09.ex2.view;

import java.util.Scanner;

public class PrintReader {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public int inputChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант:");
        System.out.println("1 - ехать");
        System.out.println("2 - заправиться");
        System.out.println("3 - поменять колесо");
        System.out.println("4 - вывести информацию о машине");
        System.out.println("0 - выход");

        return scanner.nextInt();
    }

    public static int inputEngineType() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип двигателя:");
        System.out.println("1 - бензиновый");
        System.out.println("2 - дизельный");
        System.out.println("3 - газовый");

        return scanner.nextInt();
    }

    public int inputWheelType() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип колеса:");
        System.out.println("1 - зимнее");
        System.out.println("2 - летнее");

        return scanner.nextInt();
    }

    public String inputCarModel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите марку автомобиля.");

        return scanner.nextLine();
    }


}
