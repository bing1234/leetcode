package com.geekbing.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class Interview1604 {
    private static class WordsFrequency {
        private final Map<String, Integer> map;

        public WordsFrequency(String[] book) {
            map = new HashMap<>(book.length);
            for (String word : book) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        public int get(String word) {
            Integer count = map.get(word);
            return count == null ? 0 : count;
        }
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});

        System.out.println(wordsFrequency.get("you")); //返回0，"you"没有出现过
        System.out.println(wordsFrequency.get("have")); //返回2，"have"出现2次
        System.out.println(wordsFrequency.get("an")); //返回1
        System.out.println(wordsFrequency.get("apple")); //返回1
        System.out.println(wordsFrequency.get("pen")); //返回1
    }
}
