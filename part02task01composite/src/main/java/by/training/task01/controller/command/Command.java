package by.training.task01.controller.command;

import by.training.task01.composite.Component;

public interface Command {
    String execute(String request, Component text);
}
