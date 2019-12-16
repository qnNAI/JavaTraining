package runner;

import divide.Divide;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Divide divider = new Divide();
        double a;
        double b;
        double c;
        double k;

        System.out.println("Введите число а");
        a = input.nextDouble();
        System.out.println("Введите число b");
        b = input.nextDouble();
        System.out.println("Введите число c");
        c = input.nextDouble();

        System.out.println("Введите число k");
        k = input.nextDouble();

        if (divider.isDevider(a, k))
        {
            System.out.println("Число k делитель числа a");
        }
        if (divider.isDevider(b, k))
        {
            System.out.println("Число k делитель числа b");
        }
        if (divider.isDevider(c, k))
        {
            System.out.println("Число k делитель числа c");
        }
    }
}
