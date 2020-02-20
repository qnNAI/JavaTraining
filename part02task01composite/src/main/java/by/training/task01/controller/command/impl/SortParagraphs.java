package by.training.task01.controller.command.impl;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.controller.command.Command;
import by.training.task01.service.factory.ServiceFactory;
import by.training.task01.service.sort.SortParagraph;

public class SortParagraphs implements Command {
    @Override
    public String execute(String request, Component text) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortParagraph sortParagraph = serviceFactory.getParagraphSorter();

        try {
            sortParagraph.sort(text);
            return "Sort paragraphs successful";
        } catch (CompositeException e) {
            e.printStackTrace();
            return "Error sort paragraphs";
        }
    }
}
