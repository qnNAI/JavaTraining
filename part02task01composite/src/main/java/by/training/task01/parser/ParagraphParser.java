package by.training.task01.parser;

import by.training.task01.composite.Component;
import by.training.task01.composite.Paragraph;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.parseException.ParseException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ParagraphParser extends TextParser {
    public ParagraphParser() {
        super(ComponentToParse.TEXT);
    }

    @Override
    public void parse(String data, Component component) throws ParseException {
        String[] paragraphs;

        Pattern pattern = Pattern.compile("\n");
        paragraphs = pattern.split(data);

        try {
            for (String paragraph : paragraphs) {
                Component newComponent = new Paragraph();
                callNext(ComponentToParse.PARAGRAPH, paragraph, newComponent);
                component.add(newComponent);
            }
        }  catch (CompositeException ex) {
            throw new ParseException("Text parse -> composite exception", ex);
        }

    }
}
