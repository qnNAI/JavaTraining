package task2;

import java.util.Scanner;

public class CircleLengthCounter {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите длину окружности");

        double circleLength = input.nextDouble();    // длина окружности

        double circleSquare = Math.PI * circleLength * circleLength; // площадь круга

        System.out.println("Рассчитанная площадь круга: " + circleSquare);

    }


}
