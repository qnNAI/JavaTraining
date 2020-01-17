package by.training.task10.exercise02.controller.command.impl;

import by.training.task10.exercise02.controller.command.Command;
import by.training.task10.exercise02.entity.Payment;
import by.training.task10.exercise02.service.Service;

public class EraseProducts implements Command {
    @Override
    public String execute(String request, Payment payment) {
        Service service = new Service();
        String response = "";

        String successMsg = "Список товаров очищен";

        service.eraseProducts(payment);

        response = successMsg;

        return response;
    }
}
