package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode500 {
    private static final int[] PLACES = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean sameLine = wordInSameLine(word);
            if (sameLine) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    private boolean wordInSameLine(String word) {
        int first = PLACES[convertCharToPlace(word.charAt(0))];
        for (char c : word.toCharArray()) {
            if (PLACES[convertCharToPlace(c)] != first) {
                return false;
            }
        }
        return true;
    }

    private int convertCharToPlace(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 97;
        }
        return c - 65;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');

        LeetCode500 leetCode500 = new LeetCode500();
        System.out.println(Arrays.toString(leetCode500.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
