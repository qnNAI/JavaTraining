package by.training.task10.exercise02.controller.command;

import by.training.task10.exercise02.entity.Payment;

public interface Command {
    public String execute(String request, Payment payment);
}
