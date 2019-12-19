package by.training.bubblesort.controller;

import by.training.bubblesort.service.Service;
import by.training.bubblesort.view.View;

public class Runner {
    public static void main(String[] args) {
        int[] array = {5, 6, 2, 9, 1, 0};

        Service service = new Service();
        View view = new View();

        service.bubbleSort(array);
        view.printArray(array);


    }
}
