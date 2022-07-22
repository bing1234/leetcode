package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : arr) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        // 负数在前，正数在后。负数按照从大到小排列，正数按照从小到大排列
        List<Integer> nums = cntMap.keySet().stream().sorted((o1, o2) -> {
            if (o1 <= 0 && o2 <= 0) {
                return o2.compareTo(o1);
            } else {
                return o1.compareTo(o2);
            }
        }).collect(Collectors.toList());
        for (int num : nums) {
            int numCnt = cntMap.getOrDefault(num, 0);
            int doubleCnt = cntMap.getOrDefault(num * 2, 0);
            if (numCnt > doubleCnt) {
                return false;
            } else if (numCnt == doubleCnt) {
                cntMap.remove(num);
                cntMap.remove(num * 2);
            } else {
                cntMap.remove(num);
                cntMap.put(num * 2, doubleCnt - numCnt);
            }
        }
        return cntMap.isEmpty();
    }

    @Test
    public void testCase1() {
        LeetCode954 leetCode954 = new LeetCode954();
        assert !leetCode954.canReorderDoubled(new int[]{3, 1, 3, 6});
    }

    @Test
    public void testCase2() {
        LeetCode954 leetCode954 = new LeetCode954();
        assert !leetCode954.canReorderDoubled(new int[]{2, 1, 2, 6});
    }

    @Test
    public void testCase3() {
        LeetCode954 leetCode954 = new LeetCode954();
        assert leetCode954.canReorderDoubled(new int[]{4, -2, 2, -4});
    }
}
