package by.training.task01.composite;

import by.training.task01.composite.compositeException.CompositeException;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {
    private List<Component> components = new ArrayList<>();

   /* public Composite(List<Component> components) {
        this.components = components;
    } */

    public Composite() {}

    @Override
    public void add (Component component) throws CompositeException {
        components.add(component);
    }

    @Override
    public void remove(Component component) throws CompositeException {
        components.remove(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getChild(int index) throws CompositeException {
        return components.get(index);
    }

    @Override
    public char getSymbol() throws CompositeException {
        throw new CompositeException("composite -> getSymbol attempt");
    }
}
