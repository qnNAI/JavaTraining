package by.training.part02.task02.view.viewFactory;

import by.training.part02.task02.view.console.ConsolePrintReader;
import by.training.part02.task02.view.console.PrintReader;

public class ViewFactory {
    private static final ViewFactory instance = new ViewFactory();

    private final ConsolePrintReader printReader = new PrintReader();

    private ViewFactory() {}

    public static ViewFactory getInstance() {
        return instance;
    }

    public ConsolePrintReader getPrintReader() {
        return printReader;
    }
}
