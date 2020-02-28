package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.sort.SortSymbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortLexemes implements Command {
    private static final Logger sortLexLogger = LogManager.getLogger(SortLexemes.class.getName());

    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortSymbol sortSymbol = serviceFactory.getSymbolOccurrenceSorter();

        try {
            sortSymbol.sortBySymbol(request.charAt(0), text);
            return "Sort lexemes successful";
        } catch (CompositeException | StringIndexOutOfBoundsException ex) {
            sortLexLogger.error(ex.getMessage());
            return "Error sort lexemes";
        }
    }
}
