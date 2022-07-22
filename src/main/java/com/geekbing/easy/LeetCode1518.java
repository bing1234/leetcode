package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles, left = numBottles;
        while (left >= numExchange) {
            // 兑换瓶数
            result = result + left / numExchange;
            // 喝完剩余瓶子数
            left = left / numExchange + left % numExchange;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1518 leetCode1518 = new LeetCode1518();
        System.out.println(leetCode1518.numWaterBottles(9, 3));
        System.out.println(leetCode1518.numWaterBottles(15, 4));
        System.out.println(leetCode1518.numWaterBottles(5, 5));
        System.out.println(leetCode1518.numWaterBottles(2, 3));
    }
}
