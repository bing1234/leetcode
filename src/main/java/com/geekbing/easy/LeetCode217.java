package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode217 leetCode217 = new LeetCode217();
        System.out.println(leetCode217.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(leetCode217.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(leetCode217.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
