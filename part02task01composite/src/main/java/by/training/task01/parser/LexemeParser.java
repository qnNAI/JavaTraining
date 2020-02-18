package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.composite.Lexeme;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.parseException.ParseException;

import java.util.regex.Pattern;

public class LexemeParser extends TextParser {

    public LexemeParser() {
        super(ComponentToParse.SENTENCE);
    }

    @Override
    public void parse(String data, Component component) throws ParseException {
        String[] lexemes;

        Pattern pattern = Pattern.compile("\\s+");
        lexemes = pattern.split(data);

        try {
            for (String lexeme : lexemes) {
                Component newComponent;
                if (!lexeme.isEmpty()) {
                    newComponent = new Lexeme();
                    callNext(ComponentToParse.LEXEME, lexeme, newComponent);
                    component.add(newComponent);
                }
            }
        } catch (CompositeException ex) {
            throw new ParseException("Sentence parse -> composite exception", ex);
        }

    }
}
