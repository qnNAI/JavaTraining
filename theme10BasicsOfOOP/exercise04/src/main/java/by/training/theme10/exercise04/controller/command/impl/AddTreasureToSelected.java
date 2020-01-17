package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;
import by.training.theme10.exercise04.service.Service;

import java.util.ArrayList;

public class AddTreasureToSelected implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        String errorMsg = "Не удалось добавить сокровище!";
        String successMsg = "Сокровище добавлено в выбранные сокровища!";

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 3) {
            return errorMsg;
        }

        try {
            service.addTreasureToSelected(params, dragonTreasure);
            response = successMsg;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
