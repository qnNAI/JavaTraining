package by.training.task07.ex01.controller;

import by.training.task07.ex01.service.Service;
import by.training.task07.ex01.view.PrintReader;

public class Runner {
    public static void main(String[] args) {
        PrintReader printReader = new PrintReader();
        Service service = new Service();

        int[][] array = printReader.getArray();

        printReader.printArrays(array);

        printReader.printArray("Строка: ", service.getRow(printReader.getNumber("Введите номер строки"), array));
        printReader.printArray("Столбец: ", service.getColumn(printReader.getNumber("Введите номер столбца"), array));
    }
}
