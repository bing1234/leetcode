package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2091 {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        List<Integer> maxIdx = new ArrayList<>(), minIdx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = new ArrayList<>();
                maxIdx.add(i);
            } else if (nums[i] == max) {
                maxIdx.add(i);
            }
            if (nums[i] < min) {
                min = nums[i];
                minIdx = new ArrayList<>();
                minIdx.add(i);
            } else if (nums[i] == min) {
                minIdx.add(i);
            }
        }
        List<Integer> idx = new ArrayList<>();
        idx.addAll(maxIdx);
        idx.addAll(minIdx);
        idx = idx.stream().sorted().collect(Collectors.toList());

        int not = Math.max(idx.get(0), nums.length - 1 - idx.get(idx.size() - 1));
        for (int i = 1; i < idx.size(); i++) {
            not = Math.max(not, idx.get(i) - idx.get(i - 1) - 1);
        }
        return nums.length - not;
    }

    @Test
    public void testCase1() {
        LeetCode2091 leetCode2091 = new LeetCode2091();
        assert leetCode2091.minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode2091 leetCode2091 = new LeetCode2091();
        assert leetCode2091.minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode2091 leetCode2091 = new LeetCode2091();
        assert leetCode2091.minimumDeletions(new int[]{101}) == 1;
    }
}
