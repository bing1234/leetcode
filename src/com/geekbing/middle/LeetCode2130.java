package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * todo
 * @author bing
 */
public class LeetCode2130 {
    public int pairSum(ListNode head) {
        return 0;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2130 leetCode2130 = new LeetCode2130();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        assert leetCode2130.pairSum(head) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode2130 leetCode2130 = new LeetCode2130();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        assert leetCode2130.pairSum(head) == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2130 leetCode2130 = new LeetCode2130();
        ListNode head = new ListNode(1);
        head.next = new ListNode(100000);
        assert leetCode2130.pairSum(head) == 100001;
    }
}
