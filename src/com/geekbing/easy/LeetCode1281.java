package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1281 {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;

        int current;
        while (n != 0) {
            current = n % 10;
            product = product * current;
            sum = sum + current;

            n = n / 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        LeetCode1281 leetCode1281 = new LeetCode1281();
        System.out.println(leetCode1281.subtractProductAndSum(234));
        System.out.println(leetCode1281.subtractProductAndSum(4421));
    }
}
