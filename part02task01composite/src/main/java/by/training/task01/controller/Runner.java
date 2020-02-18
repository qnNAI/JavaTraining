package by.training.task01.controller;

import by.training.task01.composite.Text;
import by.training.task01.composite.compositeException.CompositeException;
import by.training.task01.parser.*;
import by.training.task01.parser.parseException.ParseException;
import by.training.task01.service.SymbolOccurrenceSorter;
import by.training.task01.service.WordSorter;

public class Runner {
    public static void main(String[] args) {
        Text text = new Text();

        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();

        paragraphParser.linkWith(sentenceParser);
        sentenceParser.linkWith(lexemeParser);
        lexemeParser.linkWith(wordParser);
        wordParser.linkWith(symbolParser);

        try {
            paragraphParser.parse("qwerty, qwertyyy qwerty as. qdfwf. \n asdf.", text);

            System.out.println(text.collect());

            //ParagraphSorter paragraphSorter = new ParagraphSorter();
            //paragraphSorter.sort(text);
           // WordSorter wordSorter = new WordSorter();
            //wordSorter.sort(text);
            SymbolOccurrenceSorter occurrenceSorter = new SymbolOccurrenceSorter('q');
            occurrenceSorter.sort(text);


            System.out.println(text.collect());

        } catch (ParseException | CompositeException e) {
            e.printStackTrace();
        }
    }
}
