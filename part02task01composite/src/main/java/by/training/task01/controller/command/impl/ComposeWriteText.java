package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.readWriteData.WriteData;
import by.training.task01.service.serviceException.ServiceException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ComposeWriteText implements Command {
    private static final Logger composeLogger = LogManager.getLogger(ComposeWriteText.class.getName());

    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        WriteData writeData = serviceFactory.getDataWriter();

        try {
            writeData.writeData(new String(text.collect()), request);
            return "Text write successful!";
        } catch (ServiceException e) {
            composeLogger.error(e.getMessage());
            return "Error text write";
        }
    }
}
