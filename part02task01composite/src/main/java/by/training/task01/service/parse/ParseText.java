package by.training.task01.service.parse;

import by.training.task01.composite.Component;
import by.training.task01.parser.TextParser;
import by.training.task01.parser.factory.ParserFactory;
import by.training.task01.parser.parseException.ParseException;
import by.training.task01.service.serviceException.ServiceException;

public class ParseText implements Parser {
    @Override
    public void parse(String data, Component component) throws ServiceException {
        ParserFactory parserFactory = ParserFactory.getInstance();
        TextParser parseText = parserFactory.getParser();

        try {
            parseText.parse(data, component);
        } catch (ParseException ex) {
            throw new ServiceException("Parse text -> parse exception", ex);
        }
    }
}
