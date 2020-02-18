package by.training.task01.service;

import by.training.task01.composite.Component;
import by.training.task01.composite.Composite;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.service.comparator.OccurrenceComparator;

public class SymbolOccurrenceSorter implements Sorter {
    @Override
    public void sort(Component component) throws CompositeException {
        Composite text = (Composite)component;
        OccurrenceComparator occurrenceComparator = new OccurrenceComparator();

        for (int i = 0; i < text.getChildSize(); ++i) {   // paragraphs
            for (int j = 0; j < text.getChild(i).getChildSize(); ++j) {  // sentences
                Composite composite = (Composite) text.getChild(i).getChild(j); // lexeme
                composite.sort(occurrenceComparator);
            }
        }

    }
}
