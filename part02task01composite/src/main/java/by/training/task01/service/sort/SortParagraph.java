package by.training.task01.service.sort;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;

public interface SortParagraph {
    void sort(Component component) throws CompositeException;
}
