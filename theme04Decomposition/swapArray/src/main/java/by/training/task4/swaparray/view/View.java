package by.training.task4.swaparray.view;

import by.training.task4.swaparray.service.Service;


public class View {
    int[] array = null;

    public static void main(String[] args) {
        int[] array = {1};

        Service service = new Service();

        service.swapArray(array);

        for (int i=0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

}
