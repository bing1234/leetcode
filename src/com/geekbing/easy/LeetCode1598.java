package com.geekbing.easy;

public class LeetCode1598 {
    public int minOperations(String[] logs) {

    }

    public static void main(String[] args) {
        LeetCode1598 leetCode1598 = new LeetCode1598();
        System.out.println(leetCode1598.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(leetCode1598.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(leetCode1598.minOperations(new String[]{"d1/", "../", "../", "../"}));
    }
}
