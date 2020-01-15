package by.training.theme10.exercise01.controller.command.impl;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.entity.TextFile;

public class Exit implements Command {
    @Override
    public String execute(String request, TextFile file) {
        return "выход из программы";
    }
}
