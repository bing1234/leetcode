package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] bucket = new int[n + 1];

        int pre = rounds[0], cur, max = 0;
        for (int i = 1; i < rounds.length; i++) {
            cur = rounds[i];
            if (pre <= cur) {
                for (int j = pre; j <= cur; j++) {
                    bucket[j]++;
                    max = Math.max(max, bucket[j]);
                }
            } else {
                for (int j = pre; j <= n; j++) {
                    bucket[j]++;
                    max = Math.max(max, bucket[j]);
                }
                for (int j = 1; j <= cur; j++) {
                    bucket[j]++;
                    max = Math.max(max, bucket[j]);
                }
            }
            pre = cur + 1 > n ? 1 : cur + 1;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1560 leetCode1560 = new LeetCode1560();
        System.out.println(leetCode1560.mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(leetCode1560.mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(leetCode1560.mostVisited(7, new int[]{1, 3, 5, 7}));
    }
}
