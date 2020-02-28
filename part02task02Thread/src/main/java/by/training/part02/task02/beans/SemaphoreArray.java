package by.training.part02.task02.beans;

import by.training.part02.task02.beans.beansException.BeansException;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class SemaphoreArray {
    private static final int THREAD_NUM = 1;
    private int[][] array;
    private final Semaphore semaphore = new Semaphore(THREAD_NUM, true);

    public SemaphoreArray(int[][] array) {
        this.array = array;
    }

    public int getElem(int i, int j) throws BeansException {
        if (i < array.length && j < array.length) {
            return array[i][j];
        } else {
            throw new BeansException("Выход за границы массива!");
        }
    }

    public int getSize() {
        return array.length;
    }

    public void setElem(int elem, int i, int j) throws BeansException {
        if (semaphore.tryAcquire()) {
            try {
                if (i < array.length && j < array.length) {
                    array[i][j] = elem;
                } else {
                    throw new BeansException("Выход за границы массива!");
                }
            } finally {
                semaphore.release();
            }
        }
    }

    public boolean isFilled() {
        boolean isFilled = true;

        for (int i = 0; i < array.length; ++i) {
            if (array[i][i] == 0) {
                isFilled = false;
                break;
            }
        }
        return isFilled;
    }

    public int[][] copyArray() {
        return Arrays.copyOf(array, array.length);
    }
}
