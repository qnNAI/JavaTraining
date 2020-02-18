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
        throw new CompositeException("Symbol -> add exception");
    }

    @Override
    public void remove(Component component) throws CompositeException {
        throw new CompositeException("Symbol -> remove exception");
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public int getChildSize() {
        return 0;
    }

    @Override
    public StringBuilder collect() {
        StringBuilder content = new StringBuilder();
        content.insert(0, symbol);
        return content;
    }

}
