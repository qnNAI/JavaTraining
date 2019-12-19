package by.training.arrayofnumbers.controller;

import by.training.arrayofnumbers.service.Service;
import by.training.arrayofnumbers.view.View;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Service service = new Service();
        View view = new View();
        ArrayList list = new ArrayList();

        int numberK = view.getNumber("Введите число К");
        int numberN = view.getNumber("Введите число N");

        if (numberK < 0 || numberN < 0) {
            System.out.println("Неверный формат чисел!");
            System.exit(1);
        }

        int i = 0;
        while (i <= numberN) {
            if (service.getSumDigits(i) == numberK) {
                list.add(i);
            }
            ++i;
        }

        view.printArray(list);

    }
}
