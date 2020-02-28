package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.sort.SortWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortWords implements Command {
    private static final Logger sortWordLogger = LogManager.getLogger(SortWords.class.getName());

    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortWord sortWord = serviceFactory.getWordSorter();

        try {
            sortWord.sort(text);
            return "Sort words successful";
        } catch (CompositeException e) {
            sortWordLogger.error(e.getMessage());
            return "Error sort words";
        }
    }
}
