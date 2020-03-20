package by.training.task13.controller.command;


import by.training.task13.beans.User;

import java.util.ArrayList;

public interface Command {
    String execute(String request, ArrayList<User> users);
}
