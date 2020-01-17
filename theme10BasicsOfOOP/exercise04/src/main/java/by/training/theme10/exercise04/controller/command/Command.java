package by.training.theme10.exercise04.controller.command;

import by.training.theme10.exercise04.entity.DragonTreasure;

public interface Command {
    String execute(String request, DragonTreasure dragonTreasure);
}
