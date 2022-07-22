package com.geekbing.middle;

public class LeetCode1456 {
    public int maxVowels(String s, int k) {
        int left = 0, right = 0, ans = 0, current = 0;
        while (left <= right && right < s.length()) {
            if (isVowel(s.charAt(right))) {
                current++;
                ans = Math.max(ans, current);
            }
            if (right - left + 1 < k) {
                right++;
            } else {
                if (isVowel(s.charAt(left))) {
                    current--;
                }
                left++;
                right++;
            }
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        LeetCode1456 leetCode1456 = new LeetCode1456();
        System.out.println(leetCode1456.maxVowels("abciiidef", 3));
        System.out.println(leetCode1456.maxVowels("aeiou", 2));
        System.out.println(leetCode1456.maxVowels("leetcode", 3));
        System.out.println(leetCode1456.maxVowels("rhythms", 4));
        System.out.println(leetCode1456.maxVowels("tryhard", 4));

    }
}
