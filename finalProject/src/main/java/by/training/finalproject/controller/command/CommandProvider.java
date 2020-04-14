package by.training.finalproject.controller.command;

import by.training.finalproject.controller.command.impl.LoginCmd;
import by.training.finalproject.controller.command.impl.LogoutCmd;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.LOGIN, new LoginCmd());
        repository.put(CommandName.LOGOUT, new LogoutCmd());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(name.toUpperCase());
        command = repository.get(commandName);

        return command;
    }
}
