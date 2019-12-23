package by.training.viewNumbers.controller;

import by.training.viewNumbers.service.Service;
import by.training.viewNumbers.view.View;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        ArrayList list = service.findNumbers(view.inputSequence());
        view.viewList(list);
    }
}
