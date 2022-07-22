package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode5772 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return castToInt(firstWord) + castToInt(secondWord) == castToInt(targetWord);
    }

    private int castToInt(String word) {
        char[] chars = word.toCharArray();
        int ans = 0, base = 1, cur;
        for (int i = chars.length - 1; i >= 0; i--) {
            cur = chars[i] - 'a';
            ans += base * cur;
            base *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5772 leetCode5772 = new LeetCode5772();
        System.out.println(leetCode5772.isSumEqual("acb", "cba", "cdb"));
        System.out.println(leetCode5772.isSumEqual("aaa", "a", "aab"));
        System.out.println(leetCode5772.isSumEqual("aaa", "a", "aaaa"));
    }
}
