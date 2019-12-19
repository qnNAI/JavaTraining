package by.training.amountofsubstructs.view;

import java.util.Scanner;

public class View {
    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println("Введите число");
        number = scanner.nextInt();
        if (number <= 0)
        {
            System.out.println("Число не натуральное!");
            System.exit(1);
        }
        return number;
    }

    public void printAmount(int counter)
    {
        System.out.println("Количество вычитаний = " + counter);
    }
}
