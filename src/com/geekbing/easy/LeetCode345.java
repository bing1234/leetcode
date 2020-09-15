package com.geekbing.easy;

public class LeetCode345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && isNotVowel(chars[left])) {
                left++;
            }
            while (left < right && isNotVowel(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isNotVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }

    public static void main(String[] args) {
        LeetCode345 leetCode345 = new LeetCode345();
        System.out.println(leetCode345.reverseVowels("hello"));
        System.out.println(leetCode345.reverseVowels("leetcode"));
    }
}
