package by.training.theme10.exercise01.controller.command.impl;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.entity.TextFile;
import by.training.theme10.exercise01.service.Service;
import by.training.theme10.exercise01.validation.Validator;

import java.util.ArrayList;

public class Rename implements Command {
    @Override
    public String execute(String request, TextFile textFile) {
        //PrintReader printReader = new PrintReader();
        Validator validator = new Validator();
        Service service = new Service();

        String errorMsg = "Не удалось переименовать файл!";
        String successMsg = "Файл переименован успешно!";


        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 3) {
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

        textFile.setPathStrings(dir, filename);

       // String newFilename = printReader.inputStringParameter("Введите новое имя файла").trim();
        String newFilename = params.get(2);

        if (!validator.checkFileFormat(newFilename)) {
            return errorMsg;
        }

        try {
            service.renameFile(textFile, newFilename);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return successMsg;
    }

}
