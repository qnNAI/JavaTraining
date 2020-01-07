package by.training.task07.ex03.controller;

import by.training.task07.ex03.service.Service;
import by.training.task07.ex03.view.PrintReader;

public class Runner {
    public static void main(String[] args) {
        PrintReader printReader = new PrintReader();
        Service service = new Service();

        int[][] array = service.createAndFillArray();

        printReader.printArrays(array);
        printReader.printList("Номера строк: ", service.findRows(array));
    }
}
