package by.training.sort.insert.service;

public class Service {
    public void sortArray(int[] array)
    {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                for (int j = i - 1; j >= 0; j--) {
                    if (j < array.length && array[j] > array[j + 1] ) {
                        counter++;
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }

            }
        }
    //    System.out.println(counter);
    }
}
