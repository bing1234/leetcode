package com.geekbing.easy;

public class LeetCode1370 {
    public String sortString(String s) {
        int[] buckets = buildBuckets(s);
        // 从左向右拿字符
        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != 0) {
                    buckets[i]--;
                    ans.append((char) ('a' + i));
                    count++;
                }
            }
            for (int i = buckets.length - 1; i >= 0; i--) {
                if (buckets[i] != 0) {
                    buckets[i]--;
                    ans.append((char) ('a' + i));
                    count++;
                }
            }
        }
        return ans.toString();
    }

    private int[] buildBuckets(String s) {
        int[] buckets = new int[26];
        for (char c : s.toCharArray()) {
            buckets[c - 'a']++;
        }
        return buckets;
    }

    public static void main(String[] args) {
        LeetCode1370 leetCode1370 = new LeetCode1370();
        System.out.println(leetCode1370.sortString("aaaabbbbcccc"));
        System.out.println(leetCode1370.sortString("rat"));
        System.out.println(leetCode1370.sortString("leetcode"));
        System.out.println(leetCode1370.sortString("ggggggg"));
        System.out.println(leetCode1370.sortString("spo"));
    }
}
