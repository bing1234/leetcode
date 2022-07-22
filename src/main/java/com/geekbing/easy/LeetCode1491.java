package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1491 {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
        for (int money : salary) {
            if (money > max) {
                max = money;
            }
            if (money < min) {
                min = money;
            }
            sum = sum + money;
        }
        return (sum - max - min) * 1.00000D / (salary.length - 2);
    }

    public static void main(String[] args) {
        LeetCode1491 leetCode1491 = new LeetCode1491();
        System.out.println(leetCode1491.average(new int[]{4000, 3000, 1000, 2000}));
        System.out.println(leetCode1491.average(new int[]{1000, 2000, 3000}));
        System.out.println(leetCode1491.average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        System.out.println(leetCode1491.average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }
}
