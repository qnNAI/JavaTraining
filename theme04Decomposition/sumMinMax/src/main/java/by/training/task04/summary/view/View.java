package by.training.task04.summary.view;

import java.util.Scanner;

public class View {
    public double getNumber1()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число");
        return scanner.nextDouble();
    }

    public double getNumber2()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите второе число");
        return scanner.nextDouble();
    }

    public double getNumber3()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите третье число");
        return scanner.nextDouble();
    }

    public void printSum(double sum)
    {
        System.out.println("Сумма большего и меньшего чисел = " + sum);
    }
}
