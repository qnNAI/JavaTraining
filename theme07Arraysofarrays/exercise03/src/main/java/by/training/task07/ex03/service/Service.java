package by.training.task07.ex03.service;

import java.util.ArrayList;
import java.util.Random;

public class Service {
    public ArrayList<Integer> findRows(int[][] array) {
        if (array == null) {
            return null;
        }

        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                    if (array[i][j] == 5) {
                        ++count;
                    }
            }
            if (count >= 3) {
                list.add(i);
            }
        }

        return list;
    }

    public int[][] createAndFillArray() {
        int[][] array = new int[10][20];
        Random random = new Random();

         for (int i = 0; i < 10; ++i) {
             for (int j = 0; j < 20; ++j) {
                 array[i][j] = random.nextInt(15);
             }
         }

         return array;
    }
}
