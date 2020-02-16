package by.training.task01.composite;


import by.training.task01.composite.compositeException.CompositeException;

public interface Component {
    void add(Component component) throws CompositeException;
    void remove(Component component) throws CompositeException;
    Component getChild(int index) throws CompositeException;
    void collect();
    char getSymbol() throws CompositeException;
}
