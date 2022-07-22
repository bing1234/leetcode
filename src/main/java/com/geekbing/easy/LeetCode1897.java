package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1897 {
    public boolean makeEqual(String[] words) {
        int[] bucket = new int[26];
        char[] chars;
        for (String word : words) {
            chars = word.toCharArray();
            for (char c : chars) {
                bucket[c - 'a']++;
            }
        }
        int len = words.length;
        for (int num : bucket) {
            if (num % len != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1897 leetCode1897 = new LeetCode1897();

//        System.out.println(leetCode1897.makeEqual(new String[]{"abc", "aabc", "bc"}));
//        System.out.println(leetCode1897.makeEqual(new String[]{"ab", "a"}));

        System.out.println(leetCode1897.makeEqual(new String[]{"az", "a"}));
    }
}
