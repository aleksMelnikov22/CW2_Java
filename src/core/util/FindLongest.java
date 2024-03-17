package core.util;

import core.AnalyzeText;

import java.util.Collection;

public class FindLongest implements AnalyzeText {

    private final Collection<String> words;

    public FindLongest(Collection<String> words) {
        this.words = words;
    }

    @Override
    public void analyze() {
        String longest;
        if (!words.isEmpty()) {
            longest = words.iterator().next();
            for (String word : words) {
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
            System.out.println("Наиболее длинное слово: " + longest);
        } else {
            System.out.println("Не найдено ни одного слова");
        }
    }
}