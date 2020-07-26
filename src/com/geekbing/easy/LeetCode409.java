package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        boolean hasSingle = false;
        int sum = 0;
        for (char c : countMap.keySet()) {
            int count = countMap.get(c);
            if (count % 2 == 0) {
                sum = sum + count;
            } else {
                hasSingle = true;
                sum = sum + (count - 1);
            }
        }
        return hasSingle ? sum + 1 : sum;
    }

    public static void main(String[] args) {
        LeetCode409 leetCode409 = new LeetCode409();
        System.out.println(leetCode409.longestPalindrome("abccccdd"));
    }
}
