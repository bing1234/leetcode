package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        int sqrt = (int) Math.sqrt(num);
        for (int i = sqrt; i >= 2; i--) {
            if (sum > num) {
                return false;
            }
            if (num % i == 0) {
                sum = sum + i;
                sum = sum + num / i;
            }
        }
        if (sqrt * sqrt == num) {
            sum = sum - sqrt;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        LeetCode507 leetCode507 = new LeetCode507();
        System.out.println(leetCode507.checkPerfectNumber(28));
    }
}
