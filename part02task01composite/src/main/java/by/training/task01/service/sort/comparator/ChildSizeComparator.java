package by.training.task01.service.sort.comparator;

import by.training.task01.composite.Component;

import java.util.Comparator;

public class ChildSizeComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return Integer.compare(o1.getChildSize(), o2.getChildSize());
    }
}
