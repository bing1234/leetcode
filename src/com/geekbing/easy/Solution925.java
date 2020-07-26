package com.geekbing.easy;

/**
 * @author bing
 */
public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int indexN = 0, indexT = 0, countN, countT;
        char currentN, currentT;
        while (indexN < name.length() && indexT < typed.length()) {
            currentN = name.charAt(indexN++);
            countN = 1;
            // 找到第一个不连续的字符
            while (indexN < name.length() && name.charAt(indexN) == currentN) {
                countN++;
                indexN++;
            }

            currentT = typed.charAt(indexT++);
            countT = 1;
            while (indexT < typed.length() && typed.charAt(indexT) == currentT) {
                indexT++;
                countT++;
            }

            if (currentN != currentT || countN > countT) {
                return false;
            }
        }
        return indexN == name.length() && indexT == typed.length();
    }

    public static void main(String[] args) {
        Solution925 solution925 = new Solution925();
        System.out.println(solution925.isLongPressedName("alex", "aaleex"));
        System.out.println(solution925.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(solution925.isLongPressedName("leelee", "lleeelee"));
        System.out.println(solution925.isLongPressedName("laiden", "laiden"));
    }
}
