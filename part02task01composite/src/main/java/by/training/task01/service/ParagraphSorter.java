package by.training.task01.service;

import by.training.task01.composite.Component;
import by.training.task01.composite.Composite;
import by.training.task01.service.comparator.ChildSizeComparator;

public class ParagraphSorter implements Sorter {

    @Override
    public void sort(Component component) {
        Composite text = (Composite)component;
        text.sort(new ChildSizeComparator());
    }
}
