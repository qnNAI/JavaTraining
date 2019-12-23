package by.training.findEven.controller;

import by.training.findEven.service.Service;
import by.training.findEven.view.View;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        ArrayList list = service.findEvenNumbers(view.inputSequence());
        view.viewList(list);
    }


}
