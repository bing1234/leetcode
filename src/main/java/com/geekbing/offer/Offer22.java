package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = lengthOfListNode(head);
        int cnt = len - k;
        ListNode idx = head;
        for (int i = 0; i < cnt; i++) {
            idx = idx.next;
        }
        return idx;
    }

    private int lengthOfListNode(ListNode head) {
        int count = 0;
        ListNode idx = head;
        while (idx != null) {
            count++;
            idx = idx.next;
        }
        return count;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void testCase1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Offer22 offer22 = new Offer22();
        ListNode node = offer22.getKthFromEnd(head, 2);
        assert node.val == 4;
    }
}
