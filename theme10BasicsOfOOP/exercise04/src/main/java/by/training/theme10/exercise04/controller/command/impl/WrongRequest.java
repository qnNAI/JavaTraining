package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        return "Ошибка выполнения команды!";
    }
}
