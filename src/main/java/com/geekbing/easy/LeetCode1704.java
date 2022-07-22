package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1704 {
    private static final Set<Character> VOWEL = new HashSet<>();

    static {
        VOWEL.add('a');
        VOWEL.add('e');
        VOWEL.add('i');
        VOWEL.add('o');
        VOWEL.add('u');
        VOWEL.add('A');
        VOWEL.add('E');
        VOWEL.add('I');
        VOWEL.add('O');
        VOWEL.add('U');
    }

    public boolean halvesAreAlike(String s) {
        int left = 0, leftCnt = 0, right = s.length() - 1, rightCnt = 0;
        while (left < right) {
            if (VOWEL.contains(s.charAt(left))) {
                leftCnt++;
            }
            if (VOWEL.contains(s.charAt(right))) {
                rightCnt++;
            }
            left++;
            right--;
        }
        return leftCnt == rightCnt;
    }

    public static void main(String[] args) {
        LeetCode1704 leetCode1704 = new LeetCode1704();
        System.out.println(leetCode1704.halvesAreAlike("book"));
        System.out.println(leetCode1704.halvesAreAlike("textbook"));
        System.out.println(leetCode1704.halvesAreAlike("MerryChristmas"));
        System.out.println(leetCode1704.halvesAreAlike("AbCdEfGh"));
    }
}
