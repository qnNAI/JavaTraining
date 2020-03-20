package by.training.task13.controller.command.impl;

import by.training.task13.beans.User;
import by.training.task13.controller.command.Command;

import java.util.ArrayList;

public class Exit implements Command {
    @Override
    public String execute(String request, ArrayList<User> users) {
        return "exit";
    }
}
