package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.sort.SortSymbol;

public class SortLexemes implements Command {
    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortSymbol sortSymbol = serviceFactory.getSymbolOccurrenceSorter();

        try {
            sortSymbol.sortBySymbol(request.charAt(0), text);
            return "Sort lexemes successful";
        } catch (CompositeException | StringIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return "Error sort lexemes";
        }
    }
}
