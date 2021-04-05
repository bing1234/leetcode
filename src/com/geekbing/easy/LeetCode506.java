package com.geekbing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode506 {
    public String[] findRelativeRanks(int[] score) {
        int[] arr = Arrays.copyOf(score, score.length);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            Integer sortIdx = map.get(score[i]);
            if (sortIdx == score.length - 1) {
                ans[i] = "Gold Medal";
            } else if (sortIdx == score.length - 2) {
                ans[i] = "Silver Medal";
            } else if (sortIdx == score.length - 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = String.valueOf(score.length - sortIdx);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode506 leetCode506 = new LeetCode506();
        System.out.println(Arrays.toString(leetCode506.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
