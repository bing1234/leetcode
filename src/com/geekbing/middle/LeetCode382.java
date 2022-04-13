package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author bing
 */
public class LeetCode382 {
    private static class Solution {
        private final List<Integer> values;
        private final Random random;

        public Solution(ListNode head) {
            values = new ArrayList<>();
            ListNode idx = head;
            while (idx != null) {
                values.add(idx.val);
                idx = idx.next;
            }
            random = new Random();
        }

        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);

        int ans = solution.getRandom(); // 返回 1
        assert ans == 1 || ans == 2 || ans == 3;

        ans = solution.getRandom(); // 返回 3
        assert ans == 1 || ans == 2 || ans == 3;

        ans = solution.getRandom(); // 返回 2
        assert ans == 1 || ans == 2 || ans == 3;

        ans = solution.getRandom(); // 返回 2
        assert ans == 1 || ans == 2 || ans == 3;

        ans = solution.getRandom(); // 返回 3
        assert ans == 1 || ans == 2 || ans == 3;
    }
}
