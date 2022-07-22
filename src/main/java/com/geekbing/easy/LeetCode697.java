package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode697 {
    public int findShortestSubArray(int[] nums) {
        // 最多的次数
        int maxCount = 0;
        // 数字、出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        // 数字、(该元素第一次出现的下标、最后一次出现的下标)
        Map<Integer, Tuple> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            countMap.put(nums[i], count);
            maxCount = Math.max(maxCount, count);

            Tuple tuple = map.get(nums[i]);
            if (tuple == null) {
                tuple = new Tuple();
                tuple.setFirst(i);
                tuple.setLast(i);
            } else {
                tuple.setLast(i);
            }
            map.put(nums[i], tuple);
        }

        int ans = Integer.MAX_VALUE;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == maxCount) {
                Tuple tuple = map.get(key);
                ans = Math.min(ans, tuple.getLast() - tuple.first + 1);
            }
        }
        return ans;
    }

    private static final class Tuple {
        private Integer first;
        private Integer last;

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getLast() {
            return last;
        }

        public void setLast(Integer last) {
            this.last = last;
        }
    }

    public static void main(String[] args) {
        LeetCode697 leetCode697 = new LeetCode697();
        System.out.println(leetCode697.findShortestSubArray(new int[]{1}));
        System.out.println(leetCode697.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(leetCode697.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
