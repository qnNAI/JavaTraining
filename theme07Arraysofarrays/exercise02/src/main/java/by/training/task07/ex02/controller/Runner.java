package by.training.task07.ex02.controller;

import by.training.task07.ex02.service.Service;
import by.training.task07.ex02.view.PrintReader;

public class Runner {
    public static void main(String[] args) {
        PrintReader printReader = new PrintReader();
        Service service = new Service();

        int n = printReader.takeNumber();
        if (n <= 0 || n % 2 == 1) {
            printReader.printErrorEven();
        } else {
            printReader.printArrays(service.createArray(n));
        }
    }
}
