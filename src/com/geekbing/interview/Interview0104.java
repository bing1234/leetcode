package com.geekbing.interview;

public class Interview0104 {
    public boolean canPermutePalindrome(String s) {
        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        boolean hasSingle = false;
        for (int count : counts) {
            if (count % 2 == 1) {
                if (hasSingle) {
                    return false;
                }
                hasSingle = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interview0104 interview0104 = new Interview0104();
        System.out.println(interview0104.canPermutePalindrome("tactcoa"));
    }
}
