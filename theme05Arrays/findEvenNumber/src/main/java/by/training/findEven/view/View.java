package by.training.findEven.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    public ArrayList inputSequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность чисел");

        ArrayList list = new ArrayList();

        while (scanner.hasNextDouble()) {
            list.add(scanner.nextDouble());
        }

        return list;

    }

    public void viewList(ArrayList list) {
        if (list.size() == 0) {
            System.out.println("Нет четных чисел");
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
    }
}
