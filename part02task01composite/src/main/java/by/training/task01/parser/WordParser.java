package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.composite.Mark;
import by.training.task01.composite.Word;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.parseException.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends TextParser {
    public WordParser() {
        super(ComponentToParse.LEXEME);
    }

    @Override
    public void parse(String data, Component component) throws ParseException {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(data);

        String word = "";
        String mark = "";

        try {
            Component newComponent;
            if (matcher.find()) {
                word = matcher.group();
                newComponent = new Word();
                callNext(ComponentToParse.WORD, word, newComponent);
                component.add(newComponent);
            }

            pattern = Pattern.compile("\\W+");
            matcher = pattern.matcher(data);

            if (matcher.find()) {
                mark = matcher.group();
                newComponent = new Mark();
                callNext(ComponentToParse.WORD, mark, newComponent);
                component.add(newComponent);
            }
        } catch(CompositeException ex) {
            throw new ParseException("Lexeme parse -> composite exception");
        }
    }
}

