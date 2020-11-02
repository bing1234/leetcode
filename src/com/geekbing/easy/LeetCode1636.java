package com.geekbing.easy;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/submissions/
 * 1636. 按照频率将数组升序排序
 *
 * @author bing
 */
public class LeetCode1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (o1, o2) -> {
            Integer count1 = countMap.get(o1);
            Integer count2 = countMap.get(o2);
            if (!count1.equals(count2)) {
                return count1.compareTo(count2);
            }
            return o2.compareTo(o1);
        });
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        LeetCode1636 leetCode1636 = new LeetCode1636();
        System.out.println(Arrays.toString(leetCode1636.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(leetCode1636.frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(leetCode1636.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }
}
