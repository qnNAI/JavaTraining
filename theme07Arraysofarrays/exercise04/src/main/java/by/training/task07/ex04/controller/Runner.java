package by.training.task07.ex04.controller;

import by.training.task07.ex04.service.Service;
import by.training.task07.ex04.view.PrintReader;

public class Runner {
    public static void main(String[] args) {
        PrintReader printReader = new PrintReader();
        Service service = new Service();
        int[][] sumArray = null;

        printReader.printMessage("Матрицы должны быть одинаковой размерности.");

        sumArray = service.sumMatrix(printReader.getArray(), printReader.getArray());

        printReader.printMessage("Суммарная матрица");
        printReader.printArrays(sumArray);
    }
}
