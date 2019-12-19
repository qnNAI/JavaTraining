package by.training.amountofsubstructs.controller;

import by.training.amountofsubstructs.service.Service;
import by.training.amountofsubstructs.view.View;

public class Runner {
    public static void main(String[] args) {
        Service service = new Service();
        View view = new View();

        int number = view.getNumber();
        int counter = 0;

        while (number >= 10) {
            number = service.getSubstructedNumber(number);
            ++counter;
        }
        ++counter;

        view.printAmount(counter);

    }
}
