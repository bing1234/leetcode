package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1221 {
    public int balancedStringSplit(String s) {
        int countR = 0, result = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                countR++;
            } else {
                countR--;
            }
            if (countR == 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1221 leetCode1221 = new LeetCode1221();
        System.out.println(leetCode1221.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(leetCode1221.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(leetCode1221.balancedStringSplit("LLLLRRRR"));
    }
}
