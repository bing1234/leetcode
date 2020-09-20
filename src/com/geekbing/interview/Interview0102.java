package com.geekbing.interview;

public class Interview0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null) {
            return s2 != null;
        }
        if (s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counts = new int[256];
        for (char c : s1.toCharArray()) {
            counts[c]++;
        }
        for (char c : s2.toCharArray()) {
            counts[c]--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interview0102 interview0102 = new Interview0102();
        System.out.println(interview0102.CheckPermutation("abc", "bca"));
        System.out.println(interview0102.CheckPermutation("abc", "bad"));
    }
}
