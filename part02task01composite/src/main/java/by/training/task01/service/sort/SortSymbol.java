package by.training.task01.service.sort;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;

public interface SortSymbol {
    void sortBySymbol (char symbol, Component component) throws CompositeException;
}
