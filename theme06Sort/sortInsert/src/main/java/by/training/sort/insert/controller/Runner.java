package by.training.sort.insert.controller;

import by.training.sort.insert.service.Service;

public class Runner {

    public static void main(String[] args) {
        int[] array = {5, 7, 3, 9, 1, 2};

        Service service = new Service();

        service.sortArray(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
