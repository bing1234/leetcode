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
        cur.next = pre;
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

    @Test
    public void testCase4() {
        ListNode head = buildListNode(new int[]{47, 22, 81, 46, 94, 95, 90, 22, 55, 91, 6, 83, 49, 65, 10, 32, 41, 26, 83, 99, 14, 85, 42, 99, 89, 69, 30, 92, 32, 74, 9, 81, 5, 9});

        LeetCode2130 leetCode2130 = new LeetCode2130();
        int ans = leetCode2130.pairSum(head);
        assert ans == 182;
    }

    private ListNode buildListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode idx = head;
        for (int i = 1; i < arr.length; i++) {
            idx.next = new ListNode(arr[i]);
            idx = idx.next;
        }
        return head;
    }
}
