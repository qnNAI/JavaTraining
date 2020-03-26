package by.training.task13.controller.command;


import by.training.task13.beans.usersHandler.UsersHandler;


public interface Command {
    String execute(String request, UsersHandler handler);
}
