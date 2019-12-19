package by.training.function.view;

import java.util.Scanner;

public class View {
    public final String INPUT_A = "Введите левую границу отрезка";
    public final String INPUT_B = "Введите правую границу отрезка";
    public final String INPUT_H = "Введите шаг";

    public void showParameters(double x, double f) {
        System.out.println("х = " + x + "F = " + f);
    }

    public double getParameter(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextDouble();
    }


}
