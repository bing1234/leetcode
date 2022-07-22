package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, num % 7);
            num = num / 7;
        }
        if (negative) {
            result.insert(0, "-");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode504 leetCode504 = new LeetCode504();
        System.out.println(leetCode504.convertToBase7(100));
        System.out.println(leetCode504.convertToBase7(-7));
        System.out.println(leetCode504.convertToBase7(-8));
    }
}
