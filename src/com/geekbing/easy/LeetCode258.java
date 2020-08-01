package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode258 {
    public int addDigits(int num) {
        int result = addAllBit(num);
        while (result > 9) {
            result = addAllBit(result);
        }
        return result;
    }

    private int addAllBit(int num) {
        int result = 0;
        while (num > 0) {
            result = result + num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode258 leetCode258 = new LeetCode258();
        System.out.println(leetCode258.addDigits(38));
    }
}
