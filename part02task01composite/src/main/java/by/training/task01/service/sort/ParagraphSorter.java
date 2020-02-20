package by.training.task01.service.sort;

import by.training.task01.composite.Component;
import by.training.task01.composite.Composite;
import by.training.task01.service.sort.comparator.ChildSizeComparator;

public class ParagraphSorter implements SortParagraph {
    @Override
    public void sort(Component component) {
        Composite text = (Composite)component;
        text.sort(new ChildSizeComparator());
    }
}
