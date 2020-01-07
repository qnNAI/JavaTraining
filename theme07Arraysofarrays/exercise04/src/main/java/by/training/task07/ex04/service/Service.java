package by.training.task07.ex04.service;

public class Service {
    public int[][] sumMatrix(int[][] array1, int[][] array2) {
        int length = array1.length;

        if (array1 == null || array2 == null || length != array2.length || array1[0].length != array2[0].length) {
            return null;
        }

        int[][] sumArray = new int[length][array1[0].length];

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < array1[0].length; ++j) {
                sumArray[i][j] = array1[i][j] + array2[i][j];
            }
        }

        return sumArray;
    }

}
