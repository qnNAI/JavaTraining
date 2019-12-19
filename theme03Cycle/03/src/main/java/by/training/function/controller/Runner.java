package by.training.function.controller;

import by.training.function.service.Service;
import by.training.function.view.View;

public class Runner {
    public static void main(String[] args) {
        Service service = new Service();
        View view = new View();

        int a = 0;
        int b = 0;
        double h =0;

        a = (int)view.getParameter(view.INPUT_A);
        b = (int)view.getParameter(view.INPUT_B);
        h = view.getParameter(view.INPUT_H);

        for (int i = a; i < b; i += h) {
            view.showParameters(i, service.calculateFunction(i));
        }
    }
}
