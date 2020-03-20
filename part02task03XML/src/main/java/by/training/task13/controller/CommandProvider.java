package by.training.task13.controller;

import by.training.task13.controller.command.Command;
import by.training.task13.controller.command.CommandName;
import by.training.task13.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.PARSE_SAX, new ParseSAX());
        repository.put(CommandName.PARSE_DOM, new ParseDOM());
        repository.put(CommandName.PARSE_STAX, new ParseStAX());
        repository.put(CommandName.EXIT, new Exit());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(name.toUpperCase());
        command = repository.get(commandName);

        return command;
    }
}
