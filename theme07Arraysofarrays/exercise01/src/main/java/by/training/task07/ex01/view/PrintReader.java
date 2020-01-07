package by.training.task07.ex01.view;

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

        System.out.println("Введите значения массива");
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    public int getNumber(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextInt();
    }

    public void printArray(String message, int[] array) {
        System.out.println(message);

        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Выход за границы массива!");
        }
    }

    public void printArrays(int[][] array) {
        System.out.println("Массив:");

        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array[i].length; ++j) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Массив пустой!");
        }
    }
}


