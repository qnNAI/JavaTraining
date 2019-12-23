package by.training.insertBinarySort.service;

public class Service {
    public void sortArray(/*int[] array*/)
    {
        int left = 0;
        int right = 0;
        int[] array = {5, 7, 9, 2, 4};
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                left = 0;
                right = i / 2;
                int index = i;
                boolean flag = false;

                for (int j = right; j >= left; --j) {
                    if (array[index] < array[j]) {
                        int temp = array[j];
                        array[j] = array[index];
                        array[index] = temp;
                        flag = true;
                        index = j;
                    }
                }

                if (!flag) {
                    left = i / 2;
                    right = array.length - 1;
                    for (int j = left; j <= right; ++j) {
                        if (array[index] < array[j]) {
                            int temp = array[j];
                            array[j] = array[index];
                            array[index] = temp;
                            flag = true;
                            index = j;
                        }
                    }

                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
