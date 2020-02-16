package by.training.task01.controller;

import by.training.task01.composite.Paragraph;
import by.training.task01.composite.Symbol;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.ParagraphParser;
import by.training.task01.parser.WordParser;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
       /* ParagraphParser parser = new ParagraphParser();
        WordParser wordParser = new WordParser();

        Paragraph paragraph = new Paragraph();

        List<String> list =  parser.parse("qwerty").getStringList();

        for (String sent : list) {
            char[] arr = wordParser.parse(sent).getCharArr();

            Symbol symbol = new Symbol(arr[0]);
            paragraph.add(symbol);

            try {
                System.out.println(paragraph.getChild(0).getSymbol());
            } catch (CompositeException e) {
                e.printStackTrace();
            }
        }*/


    }
}
