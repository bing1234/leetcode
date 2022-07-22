package com.geekbing.hard;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1312 {
    public int minInsertions(String s) {
        int longest = 0;

        return s.length() - longest;
    }

    public static void main(String[] args) {
        LeetCode1312 leetCode1312 = new LeetCode1312();
        System.out.println(leetCode1312.minInsertions("zzazz"));
        System.out.println(leetCode1312.minInsertions("mbadm"));
        System.out.println(leetCode1312.minInsertions("leetcode"));
        System.out.println(leetCode1312.minInsertions("g"));
        System.out.println(leetCode1312.minInsertions("no"));
    }
}
