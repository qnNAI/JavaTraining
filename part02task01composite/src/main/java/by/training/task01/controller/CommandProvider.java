package by.training.task01.controller;

import by.training.task01.controller.command.Command;
import by.training.task01.controller.command.CommandName;
import by.training.task01.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.READ_DECOMPOSE, new ReadAndDecompose());
        repository.put(CommandName.COMPOSE_WRITE, new ComposeWriteText());
        repository.put(CommandName.SHOW, new Show());
        repository.put(CommandName.SORT_PARAGRAPHS, new SortParagraphs());
        repository.put(CommandName.SORT_SENTENCES, new SortWords());
        repository.put(CommandName.SORT_LEXEMES, new SortLexemes());
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
