package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode859 {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || "".equals(A) || "".equals(B) || A.length() != B.length()) {
            return false;
        }
        int diff = 0;
        int[] bucket = new int[26];
        List<Character> diffA = new ArrayList<>();
        List<Character> diffB = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (diff > 2) {
                return false;
            }
            bucket[A.charAt(i) - 'a']++;
            if (A.charAt(i) != B.charAt(i)) {
                diffA.add(A.charAt(i));
                diffB.add(B.charAt(i));
                diff++;
            }
        }
        if (diff == 0) {
            return Arrays.stream(bucket).filter(num -> num >= 2).count() >= 1;
        } else if (diff == 1) {
            return false;
        } else if (diff == 2) {
            return diffA.get(0).equals(diffB.get(1)) && diffA.get(1).equals(diffB.get(0));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode859 leetCode859 = new LeetCode859();
        System.out.println(leetCode859.buddyStrings("ab", "ba"));
        System.out.println(leetCode859.buddyStrings("ab", "ab"));
        System.out.println(leetCode859.buddyStrings("aa", "aa"));
        System.out.println(leetCode859.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(leetCode859.buddyStrings("", "aa"));
    }
}
