package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode459 {
    public boolean repeatedSubstringPattern(String s) {
        List<Integer> idxs = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[0]) {
                idxs.add(i);
            }
        }
        for (Integer idx : idxs) {
            if (canReplace(chars, idx)) {
                return true;
            }
        }
        return false;
    }

    private boolean canReplace(char[] chars, int len) {
        if (chars.length % len != 0) {
            return false;
        }
        int idx1 = 0, idx2 = len;
        while (idx2 < chars.length) {
            if (chars[idx1] != chars[idx2]) {
                return false;
            }
            idx1++;
            idx2++;
            if (idx1 == len) {
                idx1 = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode459 leetCode459 = new LeetCode459();

        System.out.println(leetCode459.repeatedSubstringPattern("abab"));
        System.out.println(leetCode459.repeatedSubstringPattern("aba"));
        System.out.println(leetCode459.repeatedSubstringPattern("abcabcabcabc"));
    }
}
