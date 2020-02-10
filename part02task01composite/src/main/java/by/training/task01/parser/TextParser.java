package by.training.task01.parser;

import java.util.List;

public abstract class TextParser {
    private TextParser next;
    private ComponentToParse componentToParse;

    public TextParser(TextParser next) {
        this.next = next;
    }

    public TextParser linkWith(TextParser next) {
        this.next = next;
        return next;
    }

    public abstract List<String> parse(String data);

    protected List<String> callNext(String componentName, String data) {
        if (next == null) {
            return null;
        }
        return next.tryParse(componentName, data);
    }

    public List<String> tryParse(String componentName, String data) {
        // если можем обработать, парсим данные и возвращаем,
        // если не можем, передаём данные дальше по цепочке
        if (componentName.toUpperCase() == componentToParse.name()) {
            return parse(data);
        } else {
            return callNext(componentName, data);
        }
    }
}
