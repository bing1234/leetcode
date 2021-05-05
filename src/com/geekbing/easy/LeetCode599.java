package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        List<String> ans = new ArrayList<>();
        int minIdx = Integer.MAX_VALUE;
        for (String key : map1.keySet()) {
            Integer idx2 = map2.get(key);
            if (idx2 == null) {
                continue;
            }
            Integer idx1 = map1.get(key);
            if (idx1 + idx2 < minIdx) {
                minIdx = idx1 + idx2;
                ans = new ArrayList<>(Collections.singletonList(key));
            } else if (idx1 + idx2 == minIdx) {
                ans.add(key);
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        LeetCode599 leetCode599 = new LeetCode599();
        System.out.println(Arrays.toString(leetCode599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(leetCode599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"})));
    }
}
