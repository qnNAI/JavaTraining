package by.training.task01.controller;

import by.training.task01.controller.command.Command;
import by.training.task01.controller.command.CommandName;
import by.training.task01.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
       // repository.put(CommandName.CREATE, new Create());
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        /*try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }*/

        return command;
    }
}
