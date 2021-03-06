package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.sort.SortParagraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortParagraphs implements Command {
    private static final Logger sortParLogger = LogManager.getLogger(SortParagraphs.class.getName());

    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortParagraph sortParagraph = serviceFactory.getParagraphSorter();

        try {
            sortParagraph.sort(text);
            return "Sort paragraphs successful";
        } catch (CompositeException e) {
            sortParLogger.error(e.getMessage());
            return "Error sort paragraphs";
        }
    }
}
