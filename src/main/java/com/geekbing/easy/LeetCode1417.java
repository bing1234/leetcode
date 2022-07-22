package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1417 {
    public String reformat(String s) {
        List<Character> nums = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if ('a' <= c && c <= 'z') {
                chars.add(c);
            } else {
                nums.add(c);
            }
        }
        if (Math.abs(nums.size() - chars.size()) >= 2) {
            return "";
        }
        String ans = "";
        int i;
        for (i = 0; i < Math.min(nums.size(), chars.size()); i++) {
            ans = ans + nums.get(i);
            ans = ans + chars.get(i);
        }
        if (nums.size() > chars.size()) {
            return ans + nums.get(i);
        } else if (nums.size() == chars.size()) {
            return ans;
        } else {
            return chars.get(i) + ans;
        }
    }

    public String reformat2(String s) {
        String ans = "";
        // index1指向字母，index2指向数字
        int index1 = 0, index2 = 0, count1 = 0, count2 = 0;
        while (index1 < s.length() || index2 < s.length()) {
            while (index1 < s.length() && (s.charAt(index1) < 'a' || s.charAt(index1) > 'z')) {
                index1++;
            }
            if (index1 < s.length()) {
                count1++;
                ans = ans + s.charAt(index1);
            }
            while (index2 < s.length() && (s.charAt(index2) < '0' || s.charAt(index2) > '9')) {
                index2++;
            }
            if (index2 < s.length()) {
                count2++;
                ans = ans + s.charAt(index2);
            }
            index1++;
            index2++;
        }
        if (Math.abs(count1 - count2) >= 2) {
            return "";
        }
        if (count1 >= count2) {
            return ans;
        } else {
            char last = ans.charAt(ans.length() - 1);
            ans = last + ans.substring(0, ans.length() - 1);
            return ans;
        }
    }

    public static void main(String[] args) {
        LeetCode1417 leetCode1417 = new LeetCode1417();
        System.out.println(leetCode1417.reformat2("a0b1c2"));
        System.out.println(leetCode1417.reformat2("leetcode"));
        System.out.println(leetCode1417.reformat2("1229857369"));
        System.out.println(leetCode1417.reformat2("covid2019"));
        System.out.println(leetCode1417.reformat2("ab123"));
    }
}
