package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.composite.Symbol;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.parseException.ParseException;

import java.util.regex.Pattern;

public class SymbolParser extends TextParser {

    public SymbolParser() {
        super(ComponentToParse.WORD);
    }

    @Override
    public void parse(String data, Component component) throws ParseException {
        String[] symbols;

        Pattern pattern = Pattern.compile("");
        symbols = pattern.split(data);

        try {
            Symbol newComponent;
            for (String symbol : symbols) {
                if (!symbol.isEmpty()) {
                    newComponent = new Symbol(symbol.charAt(0));
                    component.add(newComponent);
                }
            }
        } catch (CompositeException ex) {
            throw new ParseException("Word parse -> composite exception", ex);
        }
    }
}
