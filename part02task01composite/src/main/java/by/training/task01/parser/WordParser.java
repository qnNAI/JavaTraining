package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.composite.Word;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.parseException.ParseException;

import java.util.regex.Pattern;

public class WordParser extends TextParser {
    public WordParser() {
        super(ComponentToParse.LEXEME);
    }

    @Override
    public void parse(String data, Component component) throws ParseException {
        String[] words;

        Pattern pattern = Pattern.compile("\\w+&");
        words = pattern.split(data);

        try {
            for (String word : words) {
                Component newComponent = new Word();
                callNext(ComponentToParse.LEXEME, word, newComponent);
                component.add(newComponent);
            }
        } catch (CompositeException ex) {
            throw new ParseException("Lexeme parse -> composite exception", ex);
        }

    }
}

