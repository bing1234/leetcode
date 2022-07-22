package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode405 {
    private static final char[] CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        if (num > 0) {
            return intToHex(num);
        }

        // 转换成二进制形式字符串
        int[] bits = toBits(num);

        // 转换成十六进制
        String ans = intToHex(calBinary(bits, 0, 7));
        ans += intToHex(calBinary(bits, 8, 15));
        ans += intToHex(calBinary(bits, 16, 23));
        ans += intToHex(calBinary(bits, 24, 31));
        return ans;
    }

    private int[] toBits(int n) {
        int[] bits = new int[32];
        int idx = 31;
        while (n != 0) {
            bits[idx] = n & 1;
            idx--;
            n = n >>> 1;
        }
        return bits;
    }

    private int calBinary(int[] bits, int left, int right) {
        int ans = 0;
        int base = 1;
        for (int i = right; i >= left; i--) {
            ans += base * bits[i];
            base *= 2;
        }
        return ans;
    }

    private String intToHex(int num) {
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            ans.insert(0, CHARS[num % 16]);
            num = num / 16;
        }
        if ("".equals(ans.toString())) {
            return "00";
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode405 leetCode405 = new LeetCode405();

        System.out.println(leetCode405.toHex(26));
        System.out.println(leetCode405.toHex(-1));
        System.out.println(leetCode405.toHex(-2147483648));
    }
}
