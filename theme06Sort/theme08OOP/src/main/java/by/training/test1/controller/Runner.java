package by.training.test1.controller;

import by.training.test1.entity.Test1;
import by.training.test1.service.Service;
import by.training.test1.view.View;

public class Runner {

    public static void main(String[] args) {
        Test1 obj = new Test1(5, 10);
        Service service = new Service();
        View view = new View();

        view.printTest1(obj.toString());
        view.printMax(service.maxVars(obj));
    }
}
