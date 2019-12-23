package by.training.shakesort.service;

public class Service {
    public void shakeSort() {
        int[] array = {5, 7, 4, 2, 9};
        int left = 1;
        int right = array.length - 1;

        while (left <= right) {
            for (int i = right; i >= left; i--)     {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            ++left;

            for (int i = left; i <= right; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            --right;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
