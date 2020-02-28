package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.parse.Parser;
import by.training.task01.service.readWriteData.ReadData;
import by.training.task01.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadAndDecompose implements Command {
    private static final Logger decomposeLogger = LogManager.getLogger(ReadAndDecompose.class.getName());

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
            decomposeLogger.error(ex.getMessage());
            return "Error text read and parse!";
        }
    }
}
