package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2073 {
    public int timeRequiredToBuyV2(int[] tickets, int k) {
        int ans = 0;
        // 当第 k 个人完成买票的那一刻，在k前面的人买的票不会超过tickets[k]，
        // 在 k 后面的人买的票不会超过 tickets[k]−1
        // 累加所有购票数即为答案
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[i], tickets[k]);
            } else {
                ans += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return ans;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        while (tickets[k] != 0) {
            int cur = 0;
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    cur++;
                    tickets[i]--;
                }
                if (tickets[k] == 0) {
                    ans += cur;
                    return ans;
                }
            }
            ans += cur;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuy(new int[]{2, 3, 2}, 2) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0) == 8;
    }

    @Test
    public void testCase3() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuy(new int[]{2, 3, 2}, 2) == 6;
    }

    @Test
    public void testCase4() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuyV2(new int[]{2, 3, 2}, 2) == 6;
    }

    @Test
    public void testCase5() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuyV2(new int[]{5, 1, 1, 1}, 0) == 8;
    }

    @Test
    public void testCase6() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuyV2(new int[]{2, 3, 2}, 2) == 6;
    }
}
