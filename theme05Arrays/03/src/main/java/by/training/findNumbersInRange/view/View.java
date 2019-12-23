package by.training.findNumbersInRange.view;

import java.util.ArrayList;
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

    public double[] inputRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите отрезок");
        double[] range = new double[2];

        range[0] = scanner.nextDouble();
        range[1] = scanner.nextDouble();

        return range;
    }

    public void viewList(ArrayList list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
    }
}