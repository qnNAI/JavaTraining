package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;
import by.training.theme10.exercise04.service.Service;

public class GenerateTreasures implements Command {
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String successMsg = "Сокровища сгенерированы!";

        service.generateTreasures(dragonTreasure);

        return successMsg;
    }
}
