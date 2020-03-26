package by.training.task13.controller.command.impl;

import by.training.task13.beans.usersHandler.UsersHandler;
import by.training.task13.controller.command.Command;


public class Exit implements Command {
    @Override
    public String execute(String request, UsersHandler handler) {
        return "exit";
    }
}
