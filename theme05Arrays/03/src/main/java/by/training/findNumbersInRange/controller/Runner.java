package by.training.findNumbersInRange.controller;

import by.training.findNumbersInRange.service.Service;
import by.training.findNumbersInRange.view.View;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        ArrayList list = service.findNumbersInRange(view.inputSequence(), view.inputRange());
        view.viewList(list);
    }
}