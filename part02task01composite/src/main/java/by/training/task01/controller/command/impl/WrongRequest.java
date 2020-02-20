package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, Component text) {
        return "Wrong command!";
    }
}
