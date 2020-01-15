package by.training.theme10.exercise01.controller.command;

import by.training.theme10.exercise01.data.TextFile;

public interface Command {
    public String execute(String request, TextFile file);
}
