package by.training.task01.composite;

import by.training.task01.composite.compositeException.CompositeException;

public class Symbol implements Component {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
        symbol = '\u0000';
    }

    @Override
    public void add(Component component) throws CompositeException {
        throw new CompositeException("Leaf -> add exception");
    }

    @Override
    public void remove(Component component) throws CompositeException {
        throw new CompositeException("Leaf -> remove exception");
    }

    @Override
    public Component getChild(int index) throws CompositeException {
        throw new CompositeException("Leaf -> get child exception");
    }

    @Override
    public void collect() {

    }

    @Override
    public char getSymbol() {
        return symbol;
    }


}
