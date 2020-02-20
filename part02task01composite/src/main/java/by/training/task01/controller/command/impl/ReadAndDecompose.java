package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.parse.Parser;
import by.training.task01.service.readWriteData.ReadData;
import by.training.task01.service.serviceException.ServiceException;

public class ReadAndDecompose implements Command {
    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReadData dataReader = serviceFactory.getDataReader();
        Parser parser = serviceFactory.getParser();
        String data;

        try {
            data = dataReader.readData(request);
            parser.parse(data, text);
            return "Text read and parse successful";
        } catch (ServiceException ex) {
            ex.printStackTrace();
            return "Error text read and parse!";
        }
    }
}
