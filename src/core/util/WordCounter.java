package core.util;

import core.AnalyzeText;

import java.util.Collection;

public class WordCounter implements AnalyzeText {
    private final Collection<String> words;

    public WordCounter(Collection<String> words) {
        this.words = words;
    }


    private Integer getWordCount() {
        return  this.words.size();
    }

    @Override
    public void analyze() {
        System.out.println("Количество слов в тексте " + getWordCount());
    }
}