package by.training.theme10.exercise01.controller.command.impl;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.entity.TextFile;
import by.training.theme10.exercise01.service.Service;
import by.training.theme10.exercise01.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;

public class Create implements Command {
    @Override
    public String execute(String request, TextFile file) {
        //PrintReader printReader = new PrintReader();
        Validator validator = new Validator();
        Service service = new Service();

        String errorMsg = "Не удалось создать файл!";
        String successMsg = "Файл создан успешно!";

       // String dir = printReader.inputStringParameter("Введите директорию файла");
       // String filename = printReader.inputStringParameter("Введите имя файла");

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 2) {
            return errorMsg;
        }

        String dir =  params.get(0);
        String filename = params.get(1);

        if (!validator.checkDir(dir)) {
            return errorMsg;
        }

        if (!validator.checkFileFormat(filename)) {
            filename += ".txt";
            if (!validator.checkFileFormat(filename)) { return errorMsg; }
        }

        file.setPathStrings(dir, filename);

        try {
            service.createFile(file);
        } catch (IOException ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return successMsg;
    }
}
