package by.training.task07.ex04.view;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintReader {
    public int[][] getArray() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int[][] array = null;

        System.out.println("Введите количество строк");
        m = scanner.nextInt();
        System.out.println("Введите количество столбцов");
        n = scanner.nextInt();

        if (n >= 0 && m >= 0) {
            array = new int[m][n];
        } else {
            System.out.println("Ошибка!");
            System.exit(1);
        }

        System.out.println("Введите значения матрицы");
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Матрица заполнена.");

        return array;
    }

    public void printArrays(int[][] array) {
        System.out.println("Матрица:");

        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array[i].length; ++j) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Матрица пуста!");
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


}


