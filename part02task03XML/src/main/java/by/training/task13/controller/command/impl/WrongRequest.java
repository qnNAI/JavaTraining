package by.training.task13.controller.command.impl;

import by.training.task13.beans.usersHandler.UsersHandler;
import by.training.task13.controller.command.Command;


public class WrongRequest implements Command {
    @Override
    public String execute(String request, UsersHandler handler) {
        return "Wrong command!";
    }
}
