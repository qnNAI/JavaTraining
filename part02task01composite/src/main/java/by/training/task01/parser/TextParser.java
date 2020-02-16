package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.parser.parseException.ParseException;

public abstract class TextParser {
    private TextParser next;
    private ComponentToParse componentToParse;

    /* TextParser(TextParser next) {
        this.next = next;
    } */

    TextParser() {
        next = null;
    }

    TextParser(ComponentToParse componentToParse) {
        this.componentToParse = componentToParse;
    }

    public TextParser linkWith(TextParser next) {
        this.next = next;
        return next;
    }

    public abstract void parse(String data, Component component) throws ParseException;

    protected void callNext(ComponentToParse componentName, String data, Component component) throws ParseException {
        if (next == null) {
            return;
        }
        next.tryParse(componentName, data, component);
    }

    public void tryParse(ComponentToParse componentName, String data, Component component) throws ParseException {
        // если можем обработать, парсим данные и возвращаем,
        // если не можем, передаём данные дальше по цепочке
        if (componentToParse == componentName) {
            parse(data, component);
            return;
        } else {
            callNext(componentName, data, component);
        }
    }
}
