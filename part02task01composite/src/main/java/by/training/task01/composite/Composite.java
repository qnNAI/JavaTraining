package by.training.task01.composite;

import by.training.task01.composite.compositeException.CompositeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    Composite() {
    }

    @Override
    public void add(Component component) throws CompositeException {
        components.add(component);
    }

    @Override
    public void remove(Component component) throws CompositeException {
        components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public int getChildSize() {
        return components.size();
    }

    public void sort(Comparator<Component> componentComparator) {
        Collections.sort(components, componentComparator);
    }
}
