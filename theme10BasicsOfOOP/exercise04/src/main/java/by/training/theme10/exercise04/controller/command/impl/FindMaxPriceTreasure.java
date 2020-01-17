package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;
import by.training.theme10.exercise04.service.Service;

public class FindMaxPriceTreasure implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        try {
            DragonTreasure.Treasure treasure = service.findMaxPriceTreasure(dragonTreasure);
            response = "Самое дорогое сокровище: \n" + service.makeStringParamsRow(treasure);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
