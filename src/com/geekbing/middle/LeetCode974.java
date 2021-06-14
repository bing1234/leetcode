package com.geekbing.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode974 {
    public int subarraysDivByK(int[] nums, int k) {
        // [...i] + [i...j] = [...j]
        // [...j] - [...i] = [i...j]
        // [...j] % k - [...i] % k = [i...j] % k = 0
        // [...j] % k = [...i] % k

        int ans = 0, preSumRemain = 0;
        // key: 前缀和%k, value: 前缀和%k的数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        Integer val;
        for (int num : nums) {
            preSumRemain += num;
            preSumRemain = (preSumRemain % k + k) % k;

            val = map.get(preSumRemain);
            if (val != null) {
                ans += val;
            }
            map.put(preSumRemain, map.getOrDefault(preSumRemain, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode974 leetCode974 = new LeetCode974();

//        System.out.println(leetCode974.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(leetCode974.subarraysDivByK(new int[]{7, 4, -10}, 5));
    }
}
