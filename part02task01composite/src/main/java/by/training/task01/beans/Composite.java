package by.training.task01.beans;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String content;

    public Composite(String content) {
        this.content = content;
    }

    public Composite(List<Component> components) {
        this.components = components;
    }

    public Composite(List<Component> components, String content) {
        this.components = components;
        this.content = content;
    }

    public Composite() {
        content = "";
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }
}
