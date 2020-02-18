package by.training.task01.service;

import by.training.task01.composite.Component;
import by.training.task01.composite.compositeException.CompositeException;

public interface Sorter {
    void sort(Component component) throws CompositeException;
}
