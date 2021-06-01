package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode164 {
    public int compareVersion(String version1, String version2) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode164 leetCode164 = new LeetCode164();

        System.out.println(leetCode164.compareVersion("1.01", "1.001"));
        System.out.println(leetCode164.compareVersion("1.0", "1.0.0"));
        System.out.println(leetCode164.compareVersion("0.1", "1.1"));
        System.out.println(leetCode164.compareVersion("1.0.1", "1"));
        System.out.println(leetCode164.compareVersion("7.5.2.4", "7.5.3"));
    }
}
