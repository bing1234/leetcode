package com.geekbing.middle;

public class LeetCode319 {
    public int bulbSwitch(int n) {
        // 第18个灯泡会在1,2,3,6,9,18轮翻转。
        // 第36个灯泡会在1,2,3,4,6,9,12,18,36轮翻转。
        // 规律显而易见，只有在轮数是该位置因数的时候才会执行翻转操作。
        // 更进一步的，除了完全平方数，因数都是成对出现的，这意味着实际起到翻转作用(0->1)的，只有完全平方数而已。
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        LeetCode319 leetCode319 = new LeetCode319();
        System.out.println(leetCode319.bulbSwitch(3));
    }
}
