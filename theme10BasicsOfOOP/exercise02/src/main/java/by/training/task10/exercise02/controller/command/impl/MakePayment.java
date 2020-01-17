package by.training.task10.exercise02.controller.command.impl;

import by.training.task10.exercise02.controller.command.Command;
import by.training.task10.exercise02.entity.Payment;
import by.training.task10.exercise02.service.Service;

public class MakePayment implements Command {
    @Override
    public String execute(String request, Payment payment) {
        Service service = new Service();
        String response = "";

        try {
            response = service.makePayment(payment);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
