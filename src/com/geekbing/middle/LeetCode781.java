package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int ans = 0;
        for (int num : map.keySet()) {
            int cnt = map.get(num);
            if (num + 1 >= cnt) {
                ans += num + 1;
            } else {
                int times = cnt / (num + 1);
                if (cnt % (num + 1) != 0) {
                    times++;
                }
                ans += (num + 1) * times;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode781 leetCode781 = new LeetCode781();
        assert leetCode781.numRabbits(new int[]{1, 1, 2}) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode781 leetCode781 = new LeetCode781();
        assert leetCode781.numRabbits(new int[]{10, 10, 10}) == 11;
    }
}
