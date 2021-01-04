package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1704 {
    private static final Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }

    public boolean halvesAreAlike(String s) {
        int left = 0, leftCnt = 0, right = s.length() - 1, rightCnt = 0;
        while (left < right) {
            if (set.contains(s.charAt(left))) {
                leftCnt++;
            }
            if (set.contains(s.charAt(right))) {
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
