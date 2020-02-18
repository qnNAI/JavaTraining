package by.training.task01.service.factory;

import by.training.task01.service.ParagraphSorter;
import by.training.task01.service.Sorter;
import by.training.task01.service.SymbolOccurrenceSorter;
import by.training.task01.service.WordSorter;

public class ServiceFactory {
    public static final ServiceFactory instance = new ServiceFactory();

    private final Sorter paragraphSorter = new ParagraphSorter();
    private final Sorter wordSorter = new WordSorter();
    private final Sorter symbolOccurrenceSorter = new SymbolOccurrenceSorter();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Sorter getParagraphSorter() {
        return paragraphSorter;
    }

    public Sorter getWordSorter() {
        return wordSorter;
    }

    public Sorter getSymbolOccurrenceSorter() {
        return symbolOccurrenceSorter;
    }
}
