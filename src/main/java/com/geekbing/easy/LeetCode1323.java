package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1323 {
    public int maximum69Number(int num) {
        // 总和
        int result = num;
        int base = 1;

        // 当前位置的数字
        int current;
        int sixPlaceBase = 0;
        while (num != 0) {
            current = num % 10;
            if (current == 6) {
                sixPlaceBase = base;
            }
            num = num / 10;
            base = base * 10;
        }
        return result + 3 * sixPlaceBase;
    }

    public int maximum69NumberV2(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public static void main(String[] args) {
        LeetCode1323 leetCode1323 = new LeetCode1323();
        long start = System.currentTimeMillis();
        System.out.println(leetCode1323.maximum69Number(9669));
        System.out.println(leetCode1323.maximum69Number(9996));
        System.out.println(leetCode1323.maximum69Number(9999));
        System.out.println(System.currentTimeMillis() - start);
    }
}
