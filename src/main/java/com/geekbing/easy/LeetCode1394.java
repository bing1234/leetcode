package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1394 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        int max = -1;
        for (int key : countMap.keySet()) {
            if (key > max && key == countMap.get(key)) {
                max = key;
            }
        }
        return max;
    }

    public int findLuckyV2(int[] arr) {
        int[] counts = new int[500];

        for (int num : arr) {
            counts[num - 1]++;
        }

        for (int i = counts.length - 1; i >= 0; i--) {
            if (i + 1 == counts[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1394 leetCode1394 = new LeetCode1394();
        System.out.println(leetCode1394.findLucky(new int[]{2, 2, 3, 4}));
        System.out.println(leetCode1394.findLucky(new int[]{1, 2, 2, 3, 3, 3}));
        System.out.println(leetCode1394.findLucky(new int[]{2, 2, 2, 3, 3}));
        System.out.println(leetCode1394.findLucky(new int[]{5}));
        System.out.println(leetCode1394.findLucky(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}
