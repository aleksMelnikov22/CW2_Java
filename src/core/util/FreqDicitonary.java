package core.util;

import core.AnalyzeText;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FreqDicitonary implements AnalyzeText {
    private final Collection<String> words;

    public FreqDicitonary(Collection<String> words) {
        this.words = words;
    }
    public Map<String, Integer> getDictionary() {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (String word : words) {
            dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
        }
        return dictionary;
    }

    @Override
    public void analyze() {
        Map<String, Integer> dictionary = getDictionary();
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}