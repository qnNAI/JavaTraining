package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;
import by.training.theme10.exercise04.service.Service;

public class EraseSelected implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();

        String successMsg = "Список выбранных сокровищ очищен!";

        service.eraseSelected(dragonTreasure);

        return successMsg;
    }
}
