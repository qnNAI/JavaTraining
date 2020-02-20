package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.sort.SortSymbol;
import by.training.task01.service.sort.SortWord;

public class SortWords implements Command {
    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortWord sortWord = serviceFactory.getWordSorter();

        try {
            sortWord.sort(text);
            return "Sort words successful";
        } catch (CompositeException e) {
            e.printStackTrace();
            return "Error sort words";
        }
    }
}
