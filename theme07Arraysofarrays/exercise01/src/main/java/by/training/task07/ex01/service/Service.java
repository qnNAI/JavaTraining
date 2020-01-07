package by.training.task07.ex01.service;

public class Service {
    public int[] getRow(int index, int[][] array) {
        if (array == null || index >= array.length) {
            return null;
        }

        int colAmount = array[array.length - 1].length;
        int[] row = new int[colAmount];
        for (int i = 0; i < colAmount; ++i) {
            row[i] = array[index][i];
        }
        return row;
    }

    public int[] getColumn(int index, int[][] array) {
        if (array == null || index >= array[0].length) {
            return null;
        }


        int[] column = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            column[i] = array[i][index];
        }
        return column;
    }
}
