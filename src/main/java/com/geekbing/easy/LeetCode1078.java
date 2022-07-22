package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                ans.add(words[i + 2]);
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        LeetCode1078 leetCode1078 = new LeetCode1078();
        System.out.println(Arrays.toString(leetCode1078.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(leetCode1078.findOcurrences("we will we will rock you", "we", "will")));
    }
}
