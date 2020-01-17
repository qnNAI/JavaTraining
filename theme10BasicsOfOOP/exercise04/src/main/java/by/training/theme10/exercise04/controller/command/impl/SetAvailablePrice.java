package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;
import by.training.theme10.exercise04.service.Service;

public class SetAvailablePrice implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        String successMsg = "Задана доступная сумма";

        try {
            service.setPriceAvailable(Double.parseDouble(service.parseRequest(request).get(0)), dragonTreasure);
            response = successMsg;
        } catch (Exception ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
