package by.training.theme10.exercise01.controller.command.impl;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.data.TextFile;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, TextFile file) {
        return "Ошибка выполнения команды!";
    }
}
