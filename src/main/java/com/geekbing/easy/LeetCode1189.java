package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1189 {
    public int maxNumberOfBalloons(String text) {
        // balloon
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            if (c == 'b') {
                b++;
            }
            if (c == 'a') {
                a++;
            }
            if (c == 'l') {
                l++;
            }
            if (c == 'o') {
                o++;
            }
            if (c == 'n') {
                n++;
            }
        }
        return Math.min(Math.min(Math.min(b, a), Math.min(l / 2, o / 2)), n);
    }

    public static void main(String[] args) {
        LeetCode1189 leetCode1189 = new LeetCode1189();
        System.out.println(leetCode1189.maxNumberOfBalloons("nlaebolko"));
        System.out.println(leetCode1189.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(leetCode1189.maxNumberOfBalloons("leetcode"));
    }
}
