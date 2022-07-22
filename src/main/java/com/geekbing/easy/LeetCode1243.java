package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode1243 {
    public List<Integer> transformArray(int[] arr) {
        boolean change = true;
        while (change) {
            change = false;
            int pre = arr[0];
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > pre && arr[i] > arr[i + 1]) {
                    pre = arr[i];
                    arr[i]--;
                    change = true;
                } else if (arr[i] < pre && arr[i] < arr[i + 1]) {
                    pre = arr[i];
                    arr[i]++;
                    change = true;
                } else {
                    pre = arr[i];
                }
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    @Test
    public void testCase1() {
        LeetCode1243 leetCode1243 = new LeetCode1243();
        List<Integer> ans = leetCode1243.transformArray(new int[]{6, 2, 3, 4});
        List<Integer> expert = new ArrayList<>(Arrays.asList(6, 3, 3, 4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1243 leetCode1243 = new LeetCode1243();
        List<Integer> ans = leetCode1243.transformArray(new int[]{1, 6, 3, 4, 3, 5});
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 4, 4, 4, 4, 5));
        assert expert.equals(ans);
    }
}
