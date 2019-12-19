package by.training.task4.swaparray.service;

import java.util.ArrayList;

public class Service {
    public void swapArray(int[] array)
    {
        for (int i = 0; i < array.length / 2 ; i++)
        {
            int temp = array[i];
            array[i] = array[array.length-i - 1];
            array[array.length-i - 1] = temp;
        }
    }
}
