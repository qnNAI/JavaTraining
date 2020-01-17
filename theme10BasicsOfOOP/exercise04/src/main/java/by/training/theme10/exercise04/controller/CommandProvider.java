package by.training.theme10.exercise04.controller;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.controller.command.CommandName;
import by.training.theme10.exercise04.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD_TO_SELECTED, new AddTreasureToSelected());
        repository.put(CommandName.ERASE_SELECTED, new EraseSelected());
        repository.put(CommandName.FIND_MAX, new FindMaxPriceTreasure());
        repository.put(CommandName.GENERATE, new GenerateTreasures());
        repository.put(CommandName.READ_FILE, new ReadTreasuresFromFile());
        repository.put(CommandName.SET_AV_PRICE, new SetAvailablePrice());
        repository.put(CommandName.SHOW, new ShowTreasures());
        repository.put(CommandName.TAKE, new TakeTreasures());
        repository.put(CommandName.WRITE_FILE, new WriteTreasuresToFile());
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
