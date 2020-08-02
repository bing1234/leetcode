package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);

        List<Integer> current;
        for (int i = 1; i < numRows; i++) {
            current = getNextLevel(pre);
            result.add(current);
            pre = current;
        }
        return result;
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
        LeetCode118 leetCode118 = new LeetCode118();
        System.out.println(leetCode118.generate(5));
    }
}
