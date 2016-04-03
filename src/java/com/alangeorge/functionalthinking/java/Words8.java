package com.alangeorge.functionalthinking.java;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words8 extends Words {
    private List<String> regexToList(String words, String regex) {
        List<String > wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);

        while (m.find()) wordList.add(m.group());

        return wordList;
    }

    @Override
    public Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        List<String> strings = regexToList(words, "\\w+");

        strings.stream()
                .map(String::toLowerCase)
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));

        return wordMap;
    }

    public static void main(String[] args) {
        Words8 w = new Words8();

        System.out.println(w.wordFreq("i love love you and you and you"));
    }
}
