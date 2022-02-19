package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1104 {
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) {
            return new ArrayList<>(Collections.singletonList(1));
        }

        // 找到所在层级
        int level = getLevel(label);

        List<Integer> ans = new ArrayList<>();
        // 添加尾元素
        ans.add(label);
        for (int i = level - 1; i > 1; i--) {
            int cur = label / 2;
            if (i % 2 != level % 2) {
                ans.add(0, (1 << (i - 1)) + (1 << i) - 1 - cur);
            } else {
                ans.add(0, cur);
            }
            label = cur;
        }
        // 最后将1添加进结果集
        ans.add(0, 1);
        return ans;
    }

    private int getLevel(int label) {
        int level = 1, sum = 1, base = 1;
        while (label > sum) {
            sum += base * 2;
            base *= 2;
            level++;
        }
        return level;
    }

    @Test
    public void testCase1() {
        LeetCode1104 leetCode1104 = new LeetCode1104();
        List<Integer> ans = leetCode1104.pathInZigZagTree(14);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 3, 4, 14));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1104 leetCode1104 = new LeetCode1104();
        List<Integer> ans = leetCode1104.pathInZigZagTree(26);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 6, 10, 26));
        assert expert.equals(ans);
    }
}
