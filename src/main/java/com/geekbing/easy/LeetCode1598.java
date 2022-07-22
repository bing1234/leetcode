package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1598 {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if (log.startsWith("../")) {
                if (level > 0) {
                    level -= 1;
                }
            } else if (!log.startsWith("./")) {
                level += 1;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        LeetCode1598 leetCode1598 = new LeetCode1598();
        System.out.println(leetCode1598.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(leetCode1598.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(leetCode1598.minOperations(new String[]{"d1/", "../", "../", "../"}));
    }
}
