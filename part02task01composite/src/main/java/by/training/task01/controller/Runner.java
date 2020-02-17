package by.training.task01.controller;

import by.training.task01.composite.Text;
import by.training.task01.parser.*;
import by.training.task01.parser.parseException.ParseException;

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
            paragraphParser.parse("qwerty, qwerty qwerty. tyyy \n asdf", text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
