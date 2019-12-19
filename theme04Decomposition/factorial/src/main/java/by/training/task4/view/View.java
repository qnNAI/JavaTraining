package by.training.task4.view;

import by.training.task4.controller.Controller;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller();

        int result = controller.getFactorial(9);

        if (result == 0)
        {
            System.out.println("Ошибка: неверные данные!");
        }
        else {
            System.out.println("Сумма факториалов нечётных чисел от 1 до 9 = " + result);
        }
    }
}
