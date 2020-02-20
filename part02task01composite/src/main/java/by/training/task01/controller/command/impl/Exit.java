package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.controller.command.Command;

public class Exit implements Command {
    @Override
    public String execute(String request, Component text) {
        return "exit";
    }
}
