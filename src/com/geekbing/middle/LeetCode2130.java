package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2130 {
    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode pre = slow, cur = pre.next, next = cur.next;
        slow.next = null;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        ListNode headIdx = head, newHeadIdx = cur;
        int ans = Integer.MIN_VALUE;
        while (headIdx != null && newHeadIdx != null) {
            ans = Math.max(ans, headIdx.val + newHeadIdx.val);
            headIdx = headIdx.next;
            newHeadIdx = newHeadIdx.next;
        }
        return ans;
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
        LeetCode2130 leetCode2130 = new LeetCode2130();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        int ans = leetCode2130.pairSum(head);
        assert ans == 6;
    }

    @Test
    public void testCase2() {
        LeetCode2130 leetCode2130 = new LeetCode2130();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        int ans = leetCode2130.pairSum(head);
        assert ans == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2130 leetCode2130 = new LeetCode2130();
        ListNode head = new ListNode(1);
        head.next = new ListNode(100000);
        int ans = leetCode2130.pairSum(head);
        assert ans == 100001;
    }
}
