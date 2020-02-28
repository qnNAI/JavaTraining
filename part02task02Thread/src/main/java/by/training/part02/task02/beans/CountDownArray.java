package by.training.part02.task02.beans;

import java.util.Arrays;

public class CountDownArray {
    private int[][] array = null;

    public CountDownArray(int[][] array) {
        this.array = array;
    }

    public void setElem(int i, int j, int elem) {
        array[i][j] = elem;
    }

    public int getElem(int i, int j) {
        return array[i][j];
    }

    public int getSize() {
        return array.length;
    }

    public int[][] copyArray() {
        return Arrays.copyOf(array, array.length);
    }
}
