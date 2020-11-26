package com.geekbing.easy;

public class LeetCode69 {
    public int mySqrt(int x) {
        return fastSqrt(x);
    }

    public static int fastSqrt(double x) {
        double xHalf = 0.5d * x;
        long reEncode = Double.doubleToLongBits(x);
        reEncode = 0x5fe6ec85e7de30daL - (reEncode >> 1);
        x = Double.longBitsToDouble(reEncode);
        x *= (1.5d - xHalf * x * x);
        x *= (1.5d - xHalf * x * x);
        x *= (1.5d - xHalf * x * x);
        return (int) (1.0D / x);
    }

    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        System.out.println(leetCode69.mySqrt(4));
        System.out.println(leetCode69.mySqrt(8));
        System.out.println(leetCode69.mySqrt(2147395599));
    }
}
