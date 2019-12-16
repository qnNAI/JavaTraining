package runner;

import measure.Measure;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Measure measure = new Measure();
        double A;
        double B;
        double x;
        double y;
        double z;

        System.out.println("Введите А");
        A = scanner.nextDouble();
        System.out.println("Введите B");
        B = scanner.nextDouble();
        System.out.println("Введите x");
        x = scanner.nextDouble();
        System.out.println("Введите y");
        y = scanner.nextDouble();
        System.out.println("Введите z");
        z = scanner.nextDouble();

        if (measure.isSuitable(A, B, x, y))
        {
            System.out.println("Кирпич пройдёт");
        } else {
            System.out.println("Кирпич не пройдёт");
        }
    }
}
