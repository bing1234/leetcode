package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        String curNum = null;
        for (char c : word.toCharArray()) {
            if ('0' <= c && c <= '9') {
                if (curNum == null) {
                    curNum = String.valueOf(c);
                } else {
                    curNum = curNum + c;
                }
            } else {
                if (curNum != null) {
                    set.add(removePreZero(curNum));
                    curNum = null;
                }
            }
        }
        if (curNum != null) {
            set.add(removePreZero(curNum));
        }
        System.out.println(set);
        return set.size();
    }

    private String removePreZero(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                return num.substring(i);
            }
        }
        return "0";
    }

    public static void main(String[] args) {
        LeetCode1805 leetCode1805 = new LeetCode1805();
        System.out.println(leetCode1805.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(leetCode1805.numDifferentIntegers("leet1234code234"));
        System.out.println(leetCode1805.numDifferentIntegers("a1b01c001"));
        System.out.println(leetCode1805.numDifferentIntegers("035985750011523523129774573439111590559325a1554234973"));
    }
}
