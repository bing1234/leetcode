package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        List<Integer> pre = new ArrayList<>(), current = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            current = getNextLevel(pre);
            pre = current;
        }
        return current;
    }

    private List<Integer> getNextLevel(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < nums.size() - 1; i++) {
            result.add(nums.get(i) + nums.get(i + 1));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        LeetCode119 leetCode119 = new LeetCode119();
        System.out.println(leetCode119.getRow(3));
    }
}
