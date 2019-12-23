package by.training.viewNumbers.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    public ArrayList inputSequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность чисел");

        ArrayList list = new ArrayList();

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        return list;

    }

    public void viewList(ArrayList list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
    }
}
