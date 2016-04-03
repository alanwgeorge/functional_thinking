package com.alangeorge.functionalthinking.java;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    Set<String> NON_WORDS = new HashSet<String>() {{
        add("the"); add("and");	add("of"); add("to"); add("a");
        add("i"); add("it"); add("in");	add("or"); add("is");
        add("d"); add("s"); add("as"); add("so"); add("but");
        add("be");
    }};

    public Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();

        Matcher m = Pattern.compile("\\w+").matcher(words);

        while (m.find()) {
            String word = m.group().toLowerCase();
            if (! NON_WORDS.contains(word)) {
                if (wordMap.get(word) == null) {
                    wordMap.put(word, 1);
                }
                else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }

        return wordMap;
    }

    public static void main(String[] args) {
        Words w = new Words();

        Map m;
        m = w.wordFreq("i love love you and you and you");

        System.out.println(m.toString());
    }
}
