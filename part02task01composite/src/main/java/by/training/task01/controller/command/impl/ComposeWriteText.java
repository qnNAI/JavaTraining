package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.readWriteData.WriteData;
import by.training.task01.service.serviceException.ServiceException;

public class ComposeWriteText implements Command {
    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        WriteData writeData = serviceFactory.getDataWriter();

        try {
            writeData.writeData(new String(text.collect()), request);
            return "Text write successful!";
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error text write";
        }
    }
}
