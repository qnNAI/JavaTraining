package by.training.theme10.exercise01.controller.command.impl;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.entity.TextFile;
import by.training.theme10.exercise01.service.Service;
import by.training.theme10.exercise01.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;

public class ShowInfo implements Command {
    @Override
    public String execute(String request, TextFile file) {
        //PrintReader printReader = new PrintReader();
        Validator validator = new Validator();
        Service service = new Service();

        String errorMsg = "Не удалось отобразить информацию!";

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 2) {
            return errorMsg;
        }

        String dir =  params.get(0);
        String filename = params.get(1);

        if (!validator.checkDir(dir)) {
            return errorMsg;
        }

        if (!validator.checkFile(dir, filename)) {
            return errorMsg;
        }

        file.setPathStrings(dir, filename);

        String content = "";

        try {
            content = file.getContent();
        } catch (IOException ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return content;
    }
}
