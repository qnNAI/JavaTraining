package by.training.task10.exercise02.controller.command.impl;


import by.training.task10.exercise02.controller.command.Command;
import by.training.task10.exercise02.entity.Payment;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, Payment payment) {
        return "Ошибка выполнения команды!";
    }
}
