package com.geekbing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>(arr.length);
        for (int num : arr) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        return countMap.keySet().size() == new HashSet<>(countMap.values()).size();
    }

    public static void main(String[] args) {
        LeetCode1207 leetCode1207 = new LeetCode1207();
        System.out.println(leetCode1207.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(leetCode1207.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(leetCode1207.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
