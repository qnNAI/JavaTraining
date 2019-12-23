package by.training.delElems.view;

import java.util.ArrayList;
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

    public void viewArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}