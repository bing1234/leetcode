package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        // 第一个字母是否是大写
        boolean firstUpper = 'A' <= word.charAt(0) && word.charAt(0) <= 'Z';
        // 第二个字母是否是大写
        boolean secondUpper = 'A' <= word.charAt(1) && word.charAt(1) <= 'Z';

        if (firstUpper && secondUpper) {
            // 必须全部大写
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
                    return false;
                }
            }
        } else if (secondUpper) {
            return false;
        } else {
            // 后面全部必须小写
            for (int i = 2; i < word.length(); i++) {
                if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode520 leetCode520 = new LeetCode520();
        System.out.println(leetCode520.detectCapitalUse("USA"));
        System.out.println(leetCode520.detectCapitalUse("leetcode"));
        System.out.println(leetCode520.detectCapitalUse("Google"));
        System.out.println(leetCode520.detectCapitalUse("FlaG"));
    }
}
