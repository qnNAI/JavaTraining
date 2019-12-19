package by.training.task04.summary.controller;

import by.training.task04.summary.service.Service;
import by.training.task04.summary.view.View;

import java.util.SortedSet;

public class Controller {
    public static void main(String[] args) {
        Service service = new Service();
        View view = new View();
        double number1 = view.getNumber1();
        double number2 = view.getNumber2();
        double number3 = view.getNumber3();

        view.printSum(service.sum(service.getMin(number1, number2, number3), service.getMax(number1, number2, number3)));


    }

}
