package by.training.theme10.exercise04.controller.command.impl;

import by.training.theme10.exercise04.controller.command.Command;
import by.training.theme10.exercise04.entity.DragonTreasure;
import by.training.theme10.exercise04.service.Service;

import java.io.IOException;

public class ReadTreasuresFromFile implements Command {
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        String successMsg = "Данные считаны из файла";

        try {
            String filename = service.parseRequest(request).get(0);
            service.scanTreasuresFile(filename, dragonTreasure); // считываем данные из файла
            response = successMsg;
        } catch (Exception ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
