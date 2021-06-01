package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode696 {
    public int countBinarySubstrings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int ans = 0, i = 0, start;
        List<Integer> lens = new ArrayList<>();
        while (i < chars.length) {
            start = i;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
            }
            lens.add(i - start + 1);
            i++;
        }
        for (i = 0; i < lens.size() - 1; i++) {
            ans += Math.min(lens.get(i), lens.get(i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode696 leetCode696 = new LeetCode696();
        System.out.println(leetCode696.countBinarySubstrings("00110011"));
        System.out.println(leetCode696.countBinarySubstrings("10101"));
    }
}
