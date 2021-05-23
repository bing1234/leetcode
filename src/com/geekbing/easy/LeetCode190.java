package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode190 {
    public int reverseBits(int n) {
        // 转换成二进制形式
        int[] bits = binaryBits(n);
        // 二进制反转
        revertBits(bits);
        // 计算转换成整数值
        return calBinaryBits(bits);
    }

    private int[] binaryBits(int n) {
        int[] bits = new int[32];
        int idx = 31;
        while (n != 0) {
            bits[idx] = n & 1;
            idx--;
            n = n >>> 1;
        }
        return bits;
    }

    private void revertBits(int[] bits) {
        int left = 0, right = bits.length - 1, temp;
        while (left < right) {
            // 交换
            temp = bits[left];
            bits[left] = bits[right];
            bits[right] = temp;

            left++;
            right--;
        }
    }

    private int calBinaryBits(int[] bits) {
        int ans = 0, base = 1;
        if (bits[0] == 1) {
            // 负数：1、先对各位取反；2、将其转换为十进制数；3、加上负号，再减去1
            for (int i = 31; i >= 0; i--) {
                ans += base * (bits[i] ^ 1);
                base *= 2;
            }
            return -ans - 1;
        } else {
            // 正数
            for (int i = 31; i >= 0; i--) {
                ans += base * bits[i];
                base *= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode190 leetCode190 = new LeetCode190();
        System.out.println(leetCode190.reverseBits(43261596));
        System.out.println(leetCode190.reverseBits(-3));
    }
}
