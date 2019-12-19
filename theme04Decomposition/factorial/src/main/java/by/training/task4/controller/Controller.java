package by.training.task4.controller;

import by.training.task4.service.Service;

public class Controller {
    public int getFactorial(int number)
    {
        Service service = new Service();

        if (number <= 0)
        {
            return 0;
        } else {
            return service.sumFactorials(number);
        }

    }
}
