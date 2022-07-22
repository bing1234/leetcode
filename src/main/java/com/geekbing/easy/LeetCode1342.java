package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1342 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1342 leetCode1342 = new LeetCode1342();

        System.out.println(leetCode1342.numberOfSteps(14));
        System.out.println(leetCode1342.numberOfSteps(8));
        System.out.println(leetCode1342.numberOfSteps(123));
    }
}
