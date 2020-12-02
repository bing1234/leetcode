package com.geekbing.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * todo 答案错误
 */
public class LeetCode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && (k - i) <= nums2.length) {
                int[] temp = merge(pickMax(nums1, i), pickMax(nums2, k - i));
                if (!judgeMax(ans, 0, temp, 0)) {
                    ans = temp;
                }
            }
        }
        return ans;
    }

    private boolean judgeMax(int[] num1, int start1, int[] num2, int start2) {
        if (start1 >= num1.length) {
            return false;
        }
        if (start2 >= num2.length) {
            return true;
        }
        int idx1 = start1, idx2 = start2;
        while (idx1 < num1.length && idx2 < num2.length) {
            if (num1[idx1] > num2[idx2]) {
                return true;
            } else if (num1[idx1] < num2[idx2]) {
                return false;
            }
            idx1++;
            idx2++;
        }
        return num1.length > num2.length;
    }

    private int[] pickMax(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int drop = nums.length - k;
        for (int num : nums) {
            while (drop > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                drop -= 1;
            }
            stack.push(num);
        }
        List<Integer> temp = new ArrayList<>();
        while (!stack.isEmpty()) {
            temp.add(0, stack.pop());
        }
        return temp.subList(0, k).stream().mapToInt(Integer::valueOf).toArray();
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length || idx2 < nums2.length) {
            int num1 = idx1 == nums1.length ? 0 : nums1[idx1];
            int num2 = idx2 == nums2.length ? 0 : nums2[idx2];
            if (judgeMax(nums1, idx1, nums2, idx2)) {
                ans[idx++] = num1;
                idx1++;
            } else {
                ans[idx++] = num2;
                idx2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode321 leetCode321 = new LeetCode321();
//        System.out.println(Arrays.toString(leetCode321.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
//        System.out.println(Arrays.toString(leetCode321.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
//        System.out.println(Arrays.toString(leetCode321.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
        System.out.println(Arrays.toString(leetCode321.maxNumber(new int[]{8, 6, 9}, new int[]{1, 7, 5}, 3)));
    }
}
