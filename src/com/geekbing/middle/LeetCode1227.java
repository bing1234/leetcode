package com.geekbing.middle;

/**
 * todo
 */
public class LeetCode1227 {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0D;
        }
        if (n == 2) {
            return 0.5D;
        }
        if (n == 3) {

        }
        return 0d;
    }

    public static void main(String[] args) {
        LeetCode1227 leetCode1227 = new LeetCode1227();
        System.out.println(leetCode1227.nthPersonGetsNthSeat(1));
        System.out.println(leetCode1227.nthPersonGetsNthSeat(2));
    }
}
