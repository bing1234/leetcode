package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1769 {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        char[] box = boxes.toCharArray();
        // 总共的小球数量、左边的小球数量
        int total = 0, left = box[0] - '0', cur;
        for (int i = 0; i < box.length; i++) {
            cur = box[i] - '0';
            ans[0] += i * cur;
            total += cur;
        }
        for (int i = 1; i < box.length; i++) {
            ans[i] = ans[i - 1] - total + 2 * left;
            left += box[i] - '0';
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1769 leetCode1769 = new LeetCode1769();
        System.out.println(Arrays.toString(leetCode1769.minOperations("110")));
        System.out.println(Arrays.toString(leetCode1769.minOperations("001011")));
    }
}
