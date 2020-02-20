package by.training.task01.parser.factory;

import by.training.task01.parser.*;

public class ParserFactory {
    private static final ParserFactory instance = new ParserFactory();

    private final TextParser parser = new ParagraphParser();

    private ParserFactory() {
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();

        wordParser.linkWith(symbolParser);
        lexemeParser.linkWith(wordParser);
        sentenceParser.linkWith(lexemeParser);
        parser.linkWith(sentenceParser);
    }

    public static ParserFactory getInstance() {
        return instance;
    }

    public TextParser getParser() {
        return parser;
    }
}
