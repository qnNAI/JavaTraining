package by.training.theme10.exercise01.controller;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.controller.command.CommandName;
import by.training.theme10.exercise01.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.CREATE, new Create());
        repository.put(CommandName.RENAME, new Rename());
        repository.put(CommandName.ADD_INFO, new AddInfo());
        repository.put(CommandName.SHOW_INFO, new ShowInfo());
        repository.put(CommandName.DELETE, new Delete());
        repository.put(CommandName.ERASE, new Erase());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
