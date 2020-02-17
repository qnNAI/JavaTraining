package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.composite.Sentence;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.parseException.ParseException;

import java.util.regex.Pattern;

public class SentenceParser extends TextParser {

    public SentenceParser() {
        super(ComponentToParse.PARAGRAPH);
    }

    @Override
    public void parse(String data, Component component) throws ParseException {
        String[] sentences;

        Pattern pattern = Pattern.compile("\\.\\s?");
        sentences = pattern.split(data);

        try {
            for (String sentence : sentences) {
                Component newComponent = new Sentence();
                callNext(ComponentToParse.SENTENCE, sentence, newComponent);
                component.add(newComponent);
            }
        } catch (CompositeException ex) {
            throw new ParseException("Paragraph parse -> composite exception", ex);
        }
    }
}
