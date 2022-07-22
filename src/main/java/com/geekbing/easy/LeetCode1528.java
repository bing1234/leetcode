package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1528 {
    public String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        LeetCode1528 leetCode1528 = new LeetCode1528();
        System.out.println(leetCode1528.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(leetCode1528.restoreString("abc", new int[]{0, 1, 2}));
        System.out.println(leetCode1528.restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
        System.out.println(leetCode1528.restoreString("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
        System.out.println(leetCode1528.restoreString("art", new int[]{1, 0, 2}));
    }
}
