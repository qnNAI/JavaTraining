package by.training.part02.task02.beans;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockerArray {
    private int[][] array;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public LockerArray(int[][] array) {
        this.array = array;
    }

    public int getElem(int i, int j) {
        return array[i][j];
    }

    public void setElem(int i, int j, int elem) {
        lock.lock();
        array[i][j] = elem;
        //condition.signal();
        lock.unlock();
    }

    public void readArray(String path) {
        File file = new File(path);

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bf = new BufferedReader(fileReader)) {

            String line;
            String[] numbers;
            int size;
            int lineCount = 0;

            while ((line = bf.readLine()) != null) {
                numbers = line.split(" ");

                if (array == null) {
                    size = numbers.length;
                    array = new int[size][size];
                } else {
                    size = array.length;
                }

                for (int i = 0; i < size; ++i) {
                    array[lineCount][i] = Integer.parseInt(numbers[i]);
                }

                ++lineCount;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return array.length;
    }

    public int[][] copyArray() {
        return Arrays.copyOf(array, array.length);
    }
}
