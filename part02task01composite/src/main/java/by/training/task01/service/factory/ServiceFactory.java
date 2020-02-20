package by.training.task01.service.factory;

import by.training.task01.service.parse.ParseText;
import by.training.task01.service.parse.Parser;
import by.training.task01.service.readWriteData.ReadData;
import by.training.task01.service.readWriteData.ReadFile;
import by.training.task01.service.readWriteData.WriteData;
import by.training.task01.service.readWriteData.WriteFile;
import by.training.task01.service.sort.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final SortParagraph paragraphSorter = new ParagraphSorter();
    private final SortWord wordSorter = new WordSorter();
    private final SortSymbol symbolOccurrenceSorter = new SymbolOccurrenceSorter();

    private final ReadData dataReader = new ReadFile();
    private final WriteData dataWriter = new WriteFile();

    private final Parser parser = new ParseText();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public SortParagraph getParagraphSorter() {
        return paragraphSorter;
    }

    public SortWord getWordSorter() {
        return wordSorter;
    }

    public SortSymbol getSymbolOccurrenceSorter() {
        return symbolOccurrenceSorter;
    }

    public ReadData getDataReader() {
        return dataReader;
    }

    public WriteData getDataWriter() {
        return dataWriter;
    }

    public Parser getParser() {
        return parser;
    }
}
