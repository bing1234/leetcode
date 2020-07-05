package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                result.add(nums[i + 1]);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] decompressRLElistV2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            count = count + nums[i];
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                result[index] = nums[i + 1];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1313 leetCode1313 = new LeetCode1313();
        System.out.println(Arrays.toString(leetCode1313.decompressRLElistV2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(leetCode1313.decompressRLElistV2(new int[]{1, 1, 2, 3})));
    }
}
