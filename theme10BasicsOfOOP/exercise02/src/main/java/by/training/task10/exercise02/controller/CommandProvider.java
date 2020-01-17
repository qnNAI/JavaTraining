package by.training.task10.exercise02.controller;

import by.training.task10.exercise02.controller.command.Command;
import by.training.task10.exercise02.controller.command.CommandName;
import by.training.task10.exercise02.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD_PROD_AVAILABLE, new AddProductAvailable());
        repository.put(CommandName.ADD_PROD_PAYMENT, new AddProductPayment());
        repository.put(CommandName.CANCEL_PAYMENT, new CancelPayment());
        repository.put(CommandName.ERASE_PROD, new EraseProducts());
        repository.put(CommandName.MAKE_PAYMENT, new MakePayment());
        repository.put(CommandName.SHOW_PROD, new ShowProducts());
        repository.put(CommandName.REMOVE_PROD, new RemoveProduct());
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
