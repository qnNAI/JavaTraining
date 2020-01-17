package by.training.task10.exercise02.controller.command.impl;

import by.training.task10.exercise02.controller.command.Command;
import by.training.task10.exercise02.entity.Payment;
import by.training.task10.exercise02.service.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AddProductPayment implements Command {
    @Override
    public String execute(String request, Payment payment) {
        Service service = new Service();
        String response = "";

        String errorMsg = "Не удалось добавить товар в корзину!";
        String successMsg = "Товар добавлен в корзину успешно!";

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 2) {
            return errorMsg;
        }

        try {
            service.addProductToPayment(params, payment);
            response = successMsg;
        } catch (IllegalArgumentException | NoSuchElementException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
