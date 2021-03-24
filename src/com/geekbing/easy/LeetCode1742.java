package com.geekbing.easy;

public class LeetCode1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] counts = new int[46];
        for (int num = lowLimit; num <= highLimit; num++) {
            counts[sumOfNum(num)]++;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        return max;
    }

    private int sumOfNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1742 leetCode1742 = new LeetCode1742();
        System.out.println(leetCode1742.countBalls(1, 10));
        System.out.println(leetCode1742.countBalls(5, 15));
        System.out.println(leetCode1742.countBalls(19, 28));
    }
}
